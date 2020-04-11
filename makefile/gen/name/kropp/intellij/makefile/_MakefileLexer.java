/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package name.kropp.intellij.makefile;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static name.kropp.intellij.makefile.psi.MakefileTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>MakefileLexer.flex</tt>
 */
public class _MakefileLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INCLUDES = 2;
  public static final int SOURCE = 4;
  public static final int SOURCE_FORCED = 6;
  public static final int DEFINE = 8;
  public static final int DEFINEBODY = 10;
  public static final int CONDITIONALS = 12;
  public static final int FUNCTION = 14;
  public static final int EXPORT = 16;
  public static final int EXPORTVAR = 18;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  1,  0,  1,  0,  1,  0,  1,  0,  1,  0,  1,  0,  1,  0,  1, 
     0,  1,  0, 1
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1040 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\177\200");

  /* The ZZ_CMAP_A table has 256 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\5\1\1\2\0\1\4\22\0\1\2\1\41\1\43\1\6\1\52\2\42\1\44\1\53\1\54\1\42"+
    "\1\41\1\45\1\30\14\42\1\40\1\50\1\42\1\37\1\42\1\41\1\36\33\42\1\3\3\42\1"+
    "\46\1\13\1\24\1\34\1\27\1\7\1\17\1\16\1\21\1\15\1\33\1\42\1\22\1\32\1\14\1"+
    "\11\1\26\1\51\1\10\1\20\1\25\1\23\1\35\1\12\1\31\2\42\1\55\1\47\1\56\1\42"+
    "\201\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\3\1\5\24\4"+
    "\1\6\1\7\3\4\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\4\1\22\1\4"+
    "\1\22\2\5\1\23\6\4\1\24\11\4\1\24\24\4"+
    "\2\0\1\25\2\0\1\4\1\0\1\23\13\4\1\24"+
    "\33\4\1\25\2\26\2\4\1\27\2\4\1\24\7\4"+
    "\1\30\20\4\1\31\1\32\11\4\1\33\1\4\1\34"+
    "\12\4\1\35\1\36\5\4\1\37\1\4\1\24\3\4"+
    "\1\40\1\4\1\41\2\4\1\42\1\43\1\4\1\44";

  private static int [] zzUnpackAction() {
    int [] result = new int[213];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\u011a\0\u0149"+
    "\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292\0\u02c1"+
    "\0\u02f0\0\u031f\0\u034e\0\u037d\0\u03ac\0\u03db\0\u040a\0\u0439"+
    "\0\u0468\0\u0497\0\u04c6\0\u04f5\0\136\0\u0524\0\u0553\0\u0582"+
    "\0\u05b1\0\136\0\136\0\136\0\136\0\136\0\136\0\136"+
    "\0\136\0\136\0\u05e0\0\u060f\0\u063e\0\136\0\u066d\0\u069c"+
    "\0\u06cb\0\u06fa\0\u0729\0\u0758\0\u0787\0\u07b6\0\u07e5\0\u0814"+
    "\0\u0843\0\u0872\0\u08a1\0\u08d0\0\u08ff\0\u092e\0\u095d\0\u098c"+
    "\0\u09bb\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5\0\u0b04"+
    "\0\u0b33\0\u0b62\0\u0b91\0\u0bc0\0\u0bef\0\u0c1e\0\u0c4d\0\u0c7c"+
    "\0\u0cab\0\u0cda\0\u0d09\0\u0d38\0\u0d67\0\u0d96\0\u0dc5\0\u0df4"+
    "\0\u0e23\0\u034e\0\u0e52\0\u0e81\0\u0eb0\0\u0edf\0\u0f0e\0\u0f3d"+
    "\0\u0f6c\0\u0f9b\0\u0fca\0\u0ff9\0\u1028\0\u1057\0\u1086\0\u10b5"+
    "\0\u10e4\0\u1113\0\u034e\0\u1142\0\u1171\0\u11a0\0\u11cf\0\u11fe"+
    "\0\u122d\0\u125c\0\u128b\0\u12ba\0\u12e9\0\u1318\0\u1347\0\u1376"+
    "\0\u13a5\0\u13d4\0\u1403\0\u1432\0\u1461\0\u1490\0\u14bf\0\u14ee"+
    "\0\u151d\0\u154c\0\u157b\0\u15aa\0\u15d9\0\u1608\0\136\0\136"+
    "\0\u034e\0\u1637\0\u1666\0\u034e\0\u1695\0\u16c4\0\u16f3\0\u1722"+
    "\0\u1751\0\u1780\0\u17af\0\u17de\0\u180d\0\u183c\0\u034e\0\u186b"+
    "\0\u189a\0\u18c9\0\u18f8\0\u1927\0\u1956\0\u1985\0\u19b4\0\u19e3"+
    "\0\u1a12\0\u1a41\0\u1a70\0\u1a9f\0\u1ace\0\u1afd\0\u1b2c\0\u034e"+
    "\0\u034e\0\u1b5b\0\u1b8a\0\u1bb9\0\u1be8\0\u1c17\0\u1c46\0\u1c75"+
    "\0\u1ca4\0\u1cd3\0\u034e\0\u1d02\0\u034e\0\u1d31\0\u1d60\0\u1d8f"+
    "\0\u1dbe\0\u1ded\0\u1e1c\0\u1e4b\0\u1e7a\0\u1ea9\0\u1ed8\0\u034e"+
    "\0\u034e\0\u1f07\0\u1f36\0\u1f65\0\u1f94\0\u1fc3\0\u034e\0\u1ff2"+
    "\0\u2021\0\u2050\0\u207f\0\u20ae\0\u034e\0\u20dd\0\u034e\0\u210c"+
    "\0\u213b\0\u034e\0\u034e\0\u216a\0\u034e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[213];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\4\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\23\1\27\1\30"+
    "\1\31\2\23\1\32\1\33\1\34\1\23\1\35\1\36"+
    "\1\37\1\23\1\40\1\41\1\42\1\43\1\44\1\45"+
    "\1\23\1\46\1\47\1\50\1\51\1\52\1\3\1\4"+
    "\1\5\1\6\1\4\1\53\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\23\1\27\1\30\1\31\2\23"+
    "\1\32\1\33\1\34\1\54\1\35\1\36\1\37\1\23"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\23\1\46"+
    "\1\47\1\50\1\51\1\52\60\0\1\4\2\0\1\4"+
    "\54\0\1\5\55\0\1\55\1\0\1\56\1\57\1\0"+
    "\1\56\31\0\1\56\2\0\1\56\20\0\1\7\51\0"+
    "\1\60\1\0\1\60\1\61\1\0\1\60\1\62\50\60"+
    "\7\0\1\23\1\63\3\23\1\64\5\23\1\65\6\23"+
    "\1\66\3\23\1\67\1\23\2\0\4\23\4\0\1\23"+
    "\14\0\1\70\27\23\2\0\4\23\4\0\1\23\14\0"+
    "\1\23\1\71\24\23\1\72\1\23\2\0\4\23\4\0"+
    "\1\23\14\0\2\23\1\73\1\23\1\74\1\23\1\75"+
    "\21\23\2\0\4\23\4\0\1\23\14\0\5\23\1\76"+
    "\7\23\1\77\2\23\1\100\7\23\2\0\4\23\4\0"+
    "\1\23\14\0\2\23\1\101\25\23\2\0\4\23\4\0"+
    "\1\23\14\0\5\23\1\102\2\23\1\103\17\23\2\0"+
    "\4\23\4\0\1\23\14\0\14\23\1\104\13\23\2\0"+
    "\4\23\4\0\1\23\14\0\2\23\1\105\3\23\1\106"+
    "\4\23\1\107\14\23\2\0\4\23\4\0\1\23\14\0"+
    "\2\23\1\110\3\23\1\111\3\23\1\112\1\23\1\113"+
    "\1\23\1\114\11\23\2\0\4\23\4\0\1\23\14\0"+
    "\30\23\2\0\4\23\4\0\1\23\14\0\4\23\1\115"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\5\23\1\116"+
    "\22\23\2\0\4\23\4\0\1\23\14\0\4\23\1\117"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\1\23\1\120"+
    "\2\23\1\121\23\23\2\0\4\23\4\0\1\23\14\0"+
    "\1\122\5\23\1\123\21\23\2\0\4\23\4\0\1\23"+
    "\14\0\6\23\1\111\21\23\2\0\4\23\4\0\1\23"+
    "\14\0\2\23\1\124\25\23\2\0\4\23\4\0\1\23"+
    "\14\0\4\23\1\125\23\23\2\0\4\23\4\0\1\23"+
    "\14\0\4\23\1\126\12\23\1\127\10\23\2\0\4\23"+
    "\4\0\1\23\44\0\1\35\1\130\25\0\30\23\1\35"+
    "\1\0\4\23\4\0\1\23\5\0\7\131\30\40\2\131"+
    "\2\40\1\132\1\40\4\131\1\40\5\131\7\133\30\41"+
    "\2\133\3\41\1\132\4\133\1\41\5\133\5\0\1\53"+
    "\51\0\1\134\2\0\1\134\1\0\2\134\27\135\1\23"+
    "\2\134\4\135\4\134\1\135\5\134\2\0\1\55\2\0"+
    "\1\55\52\0\2\55\2\0\1\55\51\0\1\60\1\0"+
    "\1\60\1\61\1\0\55\60\1\61\1\136\52\60\1\62"+
    "\1\0\1\62\1\137\1\0\52\62\7\0\1\23\1\140"+
    "\26\23\2\0\4\23\4\0\1\23\14\0\20\23\1\141"+
    "\7\23\2\0\4\23\4\0\1\23\14\0\11\23\1\142"+
    "\16\23\2\0\4\23\4\0\1\23\14\0\17\23\1\143"+
    "\10\23\2\0\4\23\4\0\1\23\14\0\4\23\1\144"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\4\23\1\145"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\6\23\1\146"+
    "\21\23\2\0\4\23\4\0\1\23\14\0\1\147\27\23"+
    "\2\0\4\23\4\0\1\23\14\0\1\23\1\150\26\23"+
    "\2\0\4\23\4\0\1\23\14\0\1\23\1\151\26\23"+
    "\2\0\4\23\4\0\1\23\14\0\13\23\1\152\14\23"+
    "\2\0\4\23\4\0\1\23\14\0\20\23\1\153\7\23"+
    "\2\0\4\23\4\0\1\23\14\0\11\23\1\154\16\23"+
    "\2\0\4\23\4\0\1\23\14\0\20\23\1\155\7\23"+
    "\2\0\4\23\4\0\1\23\14\0\16\23\1\156\11\23"+
    "\2\0\4\23\4\0\1\23\14\0\10\23\1\157\14\23"+
    "\1\160\2\23\2\0\4\23\4\0\1\23\14\0\1\161"+
    "\4\23\1\162\12\23\1\163\7\23\2\0\4\23\4\0"+
    "\1\23\14\0\6\23\1\164\21\23\2\0\4\23\4\0"+
    "\1\23\14\0\1\23\1\165\26\23\2\0\4\23\4\0"+
    "\1\23\14\0\1\23\1\115\3\23\1\166\5\23\1\167"+
    "\14\23\2\0\4\23\4\0\1\23\14\0\4\23\1\170"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\1\23\1\171"+
    "\26\23\2\0\4\23\4\0\1\23\14\0\5\23\1\172"+
    "\22\23\2\0\4\23\4\0\1\23\14\0\1\125\27\23"+
    "\2\0\4\23\4\0\1\23\14\0\10\23\1\173\4\23"+
    "\1\174\12\23\2\0\4\23\4\0\1\23\14\0\1\23"+
    "\1\175\26\23\2\0\4\23\4\0\1\23\14\0\11\23"+
    "\1\176\16\23\2\0\4\23\4\0\1\23\14\0\20\23"+
    "\1\177\7\23\2\0\4\23\4\0\1\23\14\0\11\23"+
    "\1\200\16\23\2\0\4\23\4\0\1\23\14\0\6\23"+
    "\1\201\21\23\2\0\4\23\4\0\1\23\14\0\16\23"+
    "\1\202\11\23\2\0\4\23\4\0\1\23\14\0\10\23"+
    "\1\203\17\23\2\0\4\23\4\0\1\23\14\0\1\23"+
    "\1\153\26\23\2\0\4\23\4\0\1\23\14\0\6\23"+
    "\1\204\21\23\2\0\4\23\4\0\1\23\14\0\13\23"+
    "\1\144\14\23\2\0\4\23\4\0\1\23\14\0\13\23"+
    "\1\205\14\23\2\0\4\23\4\0\1\23\14\0\4\23"+
    "\1\206\23\23\2\0\4\23\4\0\1\23\44\0\1\35"+
    "\17\0\43\131\1\207\13\131\44\133\1\207\12\133\1\134"+
    "\2\0\1\134\1\0\31\134\1\210\21\134\2\0\1\134"+
    "\1\0\2\134\27\135\1\211\2\134\4\135\4\134\1\135"+
    "\5\134\1\0\1\60\55\0\1\62\1\60\1\62\1\137"+
    "\1\136\52\62\7\0\2\23\1\123\25\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\212\5\23\1\213\21\23\2\0"+
    "\4\23\4\0\1\23\14\0\1\214\27\23\2\0\4\23"+
    "\4\0\1\23\14\0\2\23\1\215\25\23\2\0\4\23"+
    "\4\0\1\23\14\0\13\23\1\153\14\23\2\0\4\23"+
    "\4\0\1\23\14\0\13\23\1\154\14\23\2\0\4\23"+
    "\4\0\1\23\14\0\7\23\1\124\20\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\23\1\216\26\23\2\0\4\23"+
    "\4\0\1\23\14\0\20\23\1\217\7\23\2\0\4\23"+
    "\4\0\1\23\14\0\5\23\1\220\22\23\2\0\4\23"+
    "\4\0\1\23\14\0\20\23\1\221\7\23\2\0\4\23"+
    "\4\0\1\23\14\0\17\23\1\222\10\23\2\0\4\23"+
    "\4\0\1\23\14\0\11\23\1\223\5\23\1\224\10\23"+
    "\2\0\4\23\4\0\1\23\14\0\20\23\1\225\7\23"+
    "\2\0\4\23\4\0\1\23\14\0\2\23\1\153\25\23"+
    "\2\0\4\23\4\0\1\23\14\0\13\23\1\226\14\23"+
    "\2\0\4\23\4\0\1\23\14\0\30\23\2\0\4\23"+
    "\4\0\1\227\14\0\1\230\17\23\1\231\7\23\2\0"+
    "\4\23\4\0\1\23\14\0\1\232\27\23\2\0\4\23"+
    "\4\0\1\23\14\0\13\23\1\233\14\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\234\27\23\2\0\4\23\4\0"+
    "\1\23\14\0\20\23\1\235\7\23\2\0\4\23\4\0"+
    "\1\23\14\0\1\153\15\23\1\236\11\23\2\0\4\23"+
    "\4\0\1\23\14\0\26\23\1\140\1\23\2\0\4\23"+
    "\4\0\1\23\14\0\16\23\1\153\11\23\2\0\4\23"+
    "\4\0\1\23\14\0\25\23\1\160\2\23\2\0\4\23"+
    "\4\0\1\23\14\0\10\23\1\237\17\23\2\0\4\23"+
    "\4\0\1\23\14\0\11\23\1\171\16\23\2\0\4\23"+
    "\4\0\1\23\14\0\6\23\1\240\21\23\2\0\4\23"+
    "\4\0\1\23\14\0\16\23\1\241\11\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\242\27\23\2\0\4\23\4\0"+
    "\1\23\14\0\1\243\27\23\2\0\4\23\4\0\1\23"+
    "\14\0\26\23\1\244\1\23\2\0\4\23\4\0\1\23"+
    "\14\0\11\23\1\245\16\23\2\0\4\23\4\0\1\23"+
    "\14\0\6\23\1\246\21\23\2\0\4\23\4\0\1\23"+
    "\14\0\5\23\1\153\22\23\2\0\4\23\4\0\1\23"+
    "\14\0\14\23\1\233\13\23\2\0\4\23\4\0\1\23"+
    "\14\0\16\23\1\247\11\23\2\0\4\23\4\0\1\23"+
    "\14\0\10\23\1\250\17\23\2\0\4\23\4\0\1\23"+
    "\14\0\10\23\1\251\17\23\2\0\4\23\4\0\1\23"+
    "\14\0\1\23\1\252\26\23\2\0\4\23\4\0\1\23"+
    "\14\0\1\23\1\253\26\23\2\0\4\23\4\0\1\23"+
    "\14\0\11\23\1\153\1\23\1\254\14\23\2\0\4\23"+
    "\4\0\1\23\14\0\6\23\1\255\21\23\2\0\4\23"+
    "\4\0\1\23\14\0\25\23\1\256\2\23\2\0\4\23"+
    "\4\0\1\23\14\0\4\23\1\257\23\23\2\0\4\23"+
    "\4\0\1\23\14\0\14\23\1\260\13\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\23\1\261\26\23\2\0\4\23"+
    "\4\0\1\23\14\0\6\23\1\123\21\23\2\0\4\23"+
    "\4\0\1\23\14\0\14\23\1\262\13\23\2\0\4\23"+
    "\4\0\1\23\14\0\30\23\2\0\4\23\4\0\1\263"+
    "\14\0\1\264\27\23\2\0\4\23\4\0\1\23\14\0"+
    "\10\23\1\265\17\23\2\0\4\23\4\0\1\23\14\0"+
    "\1\153\27\23\2\0\4\23\4\0\1\23\14\0\4\23"+
    "\1\266\23\23\2\0\4\23\4\0\1\23\14\0\11\23"+
    "\1\267\16\23\2\0\4\23\4\0\1\23\14\0\1\270"+
    "\27\23\2\0\4\23\4\0\1\23\14\0\6\23\1\271"+
    "\21\23\2\0\4\23\4\0\1\23\14\0\17\23\1\153"+
    "\10\23\2\0\4\23\4\0\1\23\14\0\3\23\1\272"+
    "\24\23\2\0\4\23\4\0\1\23\14\0\10\23\1\273"+
    "\17\23\2\0\4\23\4\0\1\23\14\0\5\23\1\274"+
    "\22\23\2\0\4\23\4\0\1\23\14\0\4\23\1\275"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\14\23\1\276"+
    "\13\23\2\0\4\23\4\0\1\23\14\0\5\23\1\277"+
    "\22\23\2\0\4\23\4\0\1\23\14\0\12\23\1\300"+
    "\15\23\2\0\4\23\4\0\1\23\14\0\16\23\1\301"+
    "\11\23\2\0\4\23\4\0\1\23\14\0\6\23\1\302"+
    "\21\23\2\0\4\23\4\0\1\23\14\0\6\23\1\174"+
    "\21\23\2\0\4\23\4\0\1\23\14\0\5\23\1\303"+
    "\22\23\2\0\4\23\4\0\1\23\14\0\4\23\1\304"+
    "\23\23\2\0\4\23\4\0\1\23\14\0\16\23\1\305"+
    "\11\23\2\0\4\23\4\0\1\23\14\0\10\23\1\173"+
    "\17\23\2\0\4\23\4\0\1\23\14\0\1\173\27\23"+
    "\2\0\4\23\4\0\1\23\14\0\20\23\1\306\7\23"+
    "\2\0\4\23\4\0\1\23\14\0\10\23\1\307\17\23"+
    "\2\0\4\23\4\0\1\23\14\0\25\23\1\305\2\23"+
    "\2\0\4\23\4\0\1\23\14\0\16\23\1\310\11\23"+
    "\2\0\4\23\4\0\1\23\14\0\1\23\1\311\26\23"+
    "\2\0\4\23\4\0\1\23\14\0\22\23\1\153\5\23"+
    "\2\0\4\23\4\0\1\23\14\0\2\23\1\304\25\23"+
    "\2\0\4\23\4\0\1\23\14\0\6\23\1\312\21\23"+
    "\2\0\4\23\4\0\1\23\14\0\4\23\1\313\23\23"+
    "\2\0\4\23\4\0\1\23\14\0\16\23\1\314\11\23"+
    "\2\0\4\23\4\0\1\23\14\0\15\23\1\174\12\23"+
    "\2\0\4\23\4\0\1\23\14\0\1\315\27\23\2\0"+
    "\4\23\4\0\1\23\14\0\20\23\1\316\7\23\2\0"+
    "\4\23\4\0\1\23\14\0\7\23\1\153\20\23\2\0"+
    "\4\23\4\0\1\23\14\0\1\23\1\76\26\23\2\0"+
    "\4\23\4\0\1\23\14\0\12\23\1\153\15\23\2\0"+
    "\4\23\4\0\1\23\14\0\1\317\27\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\23\1\220\26\23\2\0\4\23"+
    "\4\0\1\23\14\0\21\23\1\320\6\23\2\0\4\23"+
    "\4\0\1\23\14\0\5\23\1\321\22\23\2\0\4\23"+
    "\4\0\1\23\14\0\23\23\1\233\4\23\2\0\4\23"+
    "\4\0\1\23\14\0\1\322\27\23\2\0\4\23\4\0"+
    "\1\23\14\0\1\323\27\23\2\0\4\23\4\0\1\23"+
    "\14\0\2\23\1\324\25\23\2\0\4\23\4\0\1\23"+
    "\14\0\1\325\27\23\2\0\4\23\4\0\1\23\14\0"+
    "\14\23\1\171\13\23\2\0\4\23\4\0\1\23\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8601];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\31\1\1\11\4\1\11\11\3\1\1\11"+
    "\51\1\2\0\1\1\2\0\1\1\1\0\50\1\2\11"+
    "\115\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[213];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _MakefileLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _MakefileLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      if (zzMarkedPosL > zzStartRead) {
        switch (zzBufferL.charAt(zzMarkedPosL-1)) {
        case '\n':
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':  // fall through
          zzAtBOL = true;
          break;
        case '\r': 
          if (zzMarkedPosL < zzEndReadL)
            zzAtBOL = zzBufferL.charAt(zzMarkedPosL) != '\n';
          else if (zzAtEOF)
            zzAtBOL = false;
          else {
            boolean eof = zzRefill();
            zzMarkedPosL = zzMarkedPos;
            zzEndReadL = zzEndRead;
            zzBufferL = zzBuffer;
            if (eof) 
              zzAtBOL = false;
            else 
              zzAtBOL = zzBufferL.charAt(zzMarkedPosL) != '\n';
          }
          break;
        default:
          zzAtBOL = false;
        }
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      if (zzAtBOL)
        zzState = ZZ_LEXSTATE[zzLexicalState+1];
      else
        zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 37: break;
          case 2: 
            { return EOL;
            } 
            // fall through
          case 38: break;
          case 3: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 39: break;
          case 4: 
            { return CHARS;
            } 
            // fall through
          case 40: break;
          case 5: 
            { return COMMENT;
            } 
            // fall through
          case 41: break;
          case 6: 
            { return ASSIGN;
            } 
            // fall through
          case 42: break;
          case 7: 
            { return COLON;
            } 
            // fall through
          case 43: break;
          case 8: 
            { return COMMA;
            } 
            // fall through
          case 44: break;
          case 9: 
            { return BACKTICK;
            } 
            // fall through
          case 45: break;
          case 10: 
            { return PIPE;
            } 
            // fall through
          case 46: break;
          case 11: 
            { return SEMICOLON;
            } 
            // fall through
          case 47: break;
          case 12: 
            { return DOLLAR;
            } 
            // fall through
          case 48: break;
          case 13: 
            { return OPEN_PAREN;
            } 
            // fall through
          case 49: break;
          case 14: 
            { return CLOSE_PAREN;
            } 
            // fall through
          case 50: break;
          case 15: 
            { return OPEN_CURLY;
            } 
            // fall through
          case 51: break;
          case 16: 
            { return CLOSE_CURLY;
            } 
            // fall through
          case 52: break;
          case 17: 
            { return TAB;
            } 
            // fall through
          case 53: break;
          case 18: 
            { return SPLIT;
            } 
            // fall through
          case 54: break;
          case 19: 
            { return DOC_COMMENT;
            } 
            // fall through
          case 55: break;
          case 20: 
            { return FUNCTION_NAME;
            } 
            // fall through
          case 56: break;
          case 21: 
            { return STRING;
            } 
            // fall through
          case 57: break;
          case 22: 
            { return MACRO;
            } 
            // fall through
          case 58: break;
          case 23: 
            { return KEYWORD_ELSE;
            } 
            // fall through
          case 59: break;
          case 24: 
            { return KEYWORD_IFEQ;
            } 
            // fall through
          case 60: break;
          case 25: 
            { return KEYWORD_ENDEF;
            } 
            // fall through
          case 61: break;
          case 26: 
            { return KEYWORD_ENDIF;
            } 
            // fall through
          case 62: break;
          case 27: 
            { return KEYWORD_IFNEQ;
            } 
            // fall through
          case 63: break;
          case 28: 
            { return KEYWORD_IFDEF;
            } 
            // fall through
          case 64: break;
          case 29: 
            { return KEYWORD_VPATH;
            } 
            // fall through
          case 65: break;
          case 30: 
            { return KEYWORD_EXPORT;
            } 
            // fall through
          case 66: break;
          case 31: 
            { return KEYWORD_IFNDEF;
            } 
            // fall through
          case 67: break;
          case 32: 
            { return KEYWORD_DEFINE;
            } 
            // fall through
          case 68: break;
          case 33: 
            { return KEYWORD_INCLUDE;
            } 
            // fall through
          case 69: break;
          case 34: 
            { return KEYWORD_PRIVATE;
            } 
            // fall through
          case 70: break;
          case 35: 
            { return KEYWORD_OVERRIDE;
            } 
            // fall through
          case 71: break;
          case 36: 
            { return KEYWORD_UNDEFINE;
            } 
            // fall through
          case 72: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
