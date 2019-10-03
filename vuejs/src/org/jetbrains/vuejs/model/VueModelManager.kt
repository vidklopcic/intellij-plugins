// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.vuejs.model

import com.intellij.codeInsight.completion.CompletionUtil
import com.intellij.lang.ecmascript6.psi.ES6ClassExpression
import com.intellij.lang.ecmascript6.psi.ES6ImportedBinding
import com.intellij.lang.ecmascript6.psi.JSExportAssignment
import com.intellij.lang.ecmascript6.resolve.ES6PsiUtil
import com.intellij.lang.injection.InjectedLanguageManager
import com.intellij.lang.javascript.psi.*
import com.intellij.lang.javascript.psi.ecma6.ES6Decorator
import com.intellij.lang.javascript.psi.ecmal4.JSClass
import com.intellij.lang.javascript.psi.stubs.JSImplicitElement
import com.intellij.lang.javascript.psi.stubs.impl.JSImplicitElementImpl
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlElement
import com.intellij.psi.xml.XmlFile
import com.intellij.psi.xml.XmlTag
import com.intellij.util.castSafelyTo
import com.intellij.xml.util.HtmlUtil
import com.intellij.xml.util.HtmlUtil.SCRIPT_TAG_NAME
import one.util.streamex.StreamEx
import org.jetbrains.vuejs.index.*
import org.jetbrains.vuejs.lang.html.VueFileType
import org.jetbrains.vuejs.model.source.*
import org.jetbrains.vuejs.model.source.VueComponents.Companion.getExportedDescriptor

class VueModelManager {

  companion object {

    fun getGlobal(context: PsiElement): VueGlobal? {
      return VueGlobalImpl.get(context)
    }

    fun findEnclosingContainer(templateElement: PsiElement): VueEntitiesContainer? {
      return findComponent(templateElement) as? VueEntitiesContainer
             ?: findVueApp(templateElement)
             ?: getGlobal(templateElement)
    }

    private fun findComponent(templateElement: PsiElement): VueComponent? {
      val baseElement: PsiElement? =
        if (templateElement is JSElement && templateElement.containingFile is XmlFile) {
          PsiTreeUtil.getParentOfType(templateElement, XmlElement::class.java)
        }
        else {
          templateElement
        }

      return when (baseElement) {
        is XmlElement -> InjectedLanguageManager.getInstance(baseElement.project)
                           .getInjectionHost(baseElement)
                           ?.let { it as? JSLiteralExpression }
                           ?.let { CompletionUtil.getOriginalOrSelf(it) }
                           ?.let { it.parent as? JSProperty }
                         ?: baseElement
        is JSElement -> InjectedLanguageManager.getInstance(templateElement.project).getInjectionHost(templateElement) as? XmlElement
        else -> null
      }
        ?.let { getEnclosingComponentDescriptor(CompletionUtil.getOriginalOrSelf(it)) }
        ?.let { getComponent(it.obj ?: it.clazz!!) }
    }

    private fun getEnclosingComponentDescriptor(element: PsiElement): VueComponentDescriptor? {
      var context: PsiElement? = element
      if (context is JSProperty) {
        context = context.context
      }
      if (context is JSObjectLiteralExpression) {
        val parentContext = PsiTreeUtil.getContextOfType(context, JSObjectLiteralExpression::class.java,
                                                         ES6Decorator::class.java)
        if (parentContext is ES6Decorator) {
          context = parentContext
        }
      }

      return when (context) {
        is JSObjectLiteralExpression -> VueComponentDescriptor(obj = context)
        is ES6Decorator -> {
          val clazz = when (val parentContext = context.context?.context) {
            is JSExportAssignment -> parentContext.stubSafeElement as? JSClass
            is JSClass -> parentContext
            else -> null
          }
          val obj = VueComponents.getDescriptorFromDecorator(context)
          if (clazz != null || obj != null)
            VueComponentDescriptor(obj = obj, clazz = clazz)
          else
            null
        }
        is JSClass -> {
          val decorator = VueComponents.getElementComponentDecorator(
            when (val decoratorContext = context.context) {
              is JSExportAssignment -> decoratorContext
              else -> context
            })
          VueComponentDescriptor(
            obj = decorator?.let { VueComponents.getDescriptorFromDecorator(it) },
            clazz = context)
        }
        null -> null
        else -> getDescriptorFromVueModule(context)
                ?: getDescriptorFromReferencedScript(context)
                ?: findReferencingComponentDescriptor(context)
      }
    }

    private fun findReferencingComponentDescriptor(context: PsiElement): VueComponentDescriptor? {
      if (context !is XmlElement) return null

      PsiTreeUtil.findFirstParent(context) {
        (it as? XmlTag)?.let { tag ->
          tag.name == SCRIPT_TAG_NAME
          && tag.getAttribute("type")?.value == "text/x-template"
        } ?: false
      }?.let { scriptTag ->
        val id = (scriptTag as XmlTag).getAttribute("id")?.value ?: return null

        var result: VueComponentDescriptor? = null
        StubIndex.getInstance().processElements(VueIdIndex.KEY, id, context.project,
                                                GlobalSearchScope.projectScope(context.project),
                                                PsiElement::class.java) { element ->
          if ((element as? JSProperty)?.indexingData
              ?.implicitElements
              ?.any {
                it.userString == VueIdIndex.JS_KEY
                && it?.qualifiedName == id
                && it.isValid
              } == true) {
            result = getEnclosingComponentDescriptor(element)
          }
          true
        }
        return result
      }

      val file = VueSourceComponent.getHostFile(context) ?: return null
      val name = file.viewProvider.virtualFile.name
      var result: VueComponentDescriptor? = null

      StubIndex.getInstance().processElements(VueUrlIndex.KEY, name, context.project,
                                              GlobalSearchScope.projectScope(context.project),
                                              PsiElement::class.java) { element ->
        if (element is JSProperty) {
          if (element.indexingData?.implicitElements
                ?.any {
                  it.userString == VueUrlIndex.JS_KEY
                  && it?.qualifiedName == name
                  && it.isValid
                } == true
              && element.value
                ?.let { VueSourceComponent.getReferencedTemplate(it) }
                ?.value?.containingFile == file) {
            result = getEnclosingComponentDescriptor(element)
          }
        }
        else if (element is XmlAttribute
                 && element.parent?.name == HtmlUtil.TEMPLATE_TAG_NAME
                 && element.valueElement?.references
                   ?.any { it.resolve()?.containingFile == context.containingFile } == true) {
          result = getDescriptorFromVueModule(element)
                   ?: getDescriptorFromReferencedScript(element)
        }
        true
      }
      return result
    }

    private fun getDescriptorFromVueModule(element: PsiElement): VueComponentDescriptor? {
      return findModule(element)
        ?.let { content -> ES6PsiUtil.findDefaultExport(content) as? JSExportAssignment }
        ?.let { defaultExport -> getExportedDescriptor(defaultExport) }
    }

    private fun getDescriptorFromReferencedScript(element: PsiElement): VueComponentDescriptor? {
      val file = element as? XmlFile ?: element.containingFile as? XmlFile
      if (file != null && file.fileType == VueFileType.INSTANCE) {
        // TODO stub safe resolution
        return findTopLevelVueTag(file, SCRIPT_TAG_NAME)
          ?.let { resolveTagSrcReference(it) }
          ?.castSafelyTo<PsiFile>()
          ?.let { content -> ES6PsiUtil.findDefaultExport(content) as? JSExportAssignment }
          ?.let { defaultExport -> getExportedDescriptor(defaultExport) }
      }
      return null
    }

    private fun findVueApp(templateElement: PsiElement): VueApp? {
      val global = getGlobal(templateElement) ?: return null
      val xmlElement =
        if (templateElement is XmlElement) {
          templateElement
        }
        else {
          when (val context = PsiTreeUtil.getContextOfType(templateElement, PsiFile::class.java, XmlElement::class.java)) {
            is XmlElement -> context
            is PsiFile -> InjectedLanguageManager.getInstance(templateElement.project).getInjectionHost(context)
            else -> return null
          }
        } ?: return null

      var result: VueApp? = null
      PsiTreeUtil.findFirstParent(xmlElement, Condition {
        if (it is PsiFile) return@Condition true
        val idValue = (it as? XmlTag)?.getAttribute("id")?.valueElement?.value
                      ?: return@Condition false
        if (!StringUtil.isEmptyOrSpaces(idValue)) {
          val idReference = "#$idValue"
          global.apps.find { app -> idReference == app.element }?.let { app ->
            result = app
            return@Condition true
          }
        }
        false
      })
      return result
    }

    fun getComponent(element: PsiElement): VueComponent? {
      val context: PsiElement = getComponentImplicitElement(element)?.context ?: element
      if (!context.isValid)
        return null
      return CachedValuesManager.getCachedValue(context) {
        val implicitElement = getComponentImplicitElement(context)
        val data = implicitElement?.let { getVueIndexData(it) }
        val descriptor = getEnclosingComponentDescriptor(context)
        var declaration: PsiElement = descriptor?.obj ?: context
        if (declaration is JSImplicitElement) {
          declaration = declaration.context ?: declaration
        }
        if (declaration is JSProperty) {
          declaration = declaration.parent ?: declaration
        }
        else if (declaration is JSCallExpression) {
          data?.descriptorRef
            ?.let { VueComponents.resolveReferenceToVueComponent(context, it) }
            ?.obj
            ?.let { declaration = it }
        }
        CachedValueProvider.Result.create(VueSourceComponent(implicitElement ?: buildImplicitElement(context),
                                                             descriptor?.clazz,
                                                             declaration as? JSObjectLiteralExpression,
                                                             data),
                                          context, declaration)
      }
    }

    fun getMixin(mixin: JSObjectLiteralExpression): VueMixin {
      return getMixin(mixin as PsiElement)!!
    }

    fun getMixin(mixin: PsiElement): VueMixin? {
      val context = when (mixin) {
        is JSObjectLiteralExpression -> mixin
        is ES6ImportedBinding -> StreamEx.of(mixin.findReferencedElements())
          .select(JSExportAssignment::class.java)
          .map { getExportedDescriptor(it) }
          .nonNull()
          .map { it!!.clazz ?: it.obj!! }
          .findFirst()
          .orElse(null)
        else -> getEnclosingComponentDescriptor(mixin)?.let { it.clazz ?: it.obj!! }
      }
      return CachedValuesManager.getCachedValue(context ?: return null) {
        val descriptor = getEnclosingComponentDescriptor(context)
        val declaration: PsiElement = descriptor?.obj ?: context

        CachedValueProvider.Result.create(VueSourceMixin(getComponentImplicitElement(context)
                                                         ?: buildImplicitElement(context),
                                                         descriptor?.clazz,
                                                         descriptor?.obj),
                                          context, declaration)
      }
    }

    fun getApp(appDeclaration: JSObjectLiteralExpression): VueApp {
      return CachedValuesManager.getCachedValue(appDeclaration) {
        CachedValueProvider.Result.create(VueSourceApp(getComponentImplicitElement(appDeclaration)
                                                       ?: buildImplicitElement(appDeclaration),
                                                       appDeclaration),
                                          appDeclaration)
      }
    }

    private fun getComponentImplicitElement(declaration: PsiElement): JSImplicitElement? {
      return if (declaration is JSImplicitElement && declaration.userString == VueComponentsIndex.JS_KEY)
        declaration
      else if (declaration is JSObjectLiteralExpression) {
        val implicitElement = declaration.findProperty("name")
                                ?.let { getComponentImplicitElement(it) as? JSImplicitElementImpl }
                              ?: declaration.firstProperty
                                ?.let { buildImplicitElement(it) }
        var parent = PsiTreeUtil.getContextOfType(declaration, ES6ClassExpression::class.java, JSExportAssignment::class.java)
        if (parent is JSExportAssignment) {
          parent = parent.stubSafeElement as? ES6ClassExpression
        }
        if (parent is ES6ClassExpression)
          (implicitElement?.toBuilder() ?: JSImplicitElementImpl.Builder("<anonymous>", parent))
            .setProvider(parent)
            .forbidAstAccess()
            .toImplicitElement()
        else
          implicitElement
      }
      else if (declaration is ES6ClassExpression)
        buildImplicitElement(declaration, declaration.name ?: "<anonymous>")
      else
        (declaration as? JSImplicitElementProvider)?.indexingData?.implicitElements?.find {
          it.userString == VueComponentsIndex.JS_KEY
        }
    }

    private fun buildImplicitElement(parent: PsiElement, name: String = "<anonymous>") =
      JSImplicitElementImpl(JSImplicitElementImpl.Builder(name, parent).forbidAstAccess())

  }
}
