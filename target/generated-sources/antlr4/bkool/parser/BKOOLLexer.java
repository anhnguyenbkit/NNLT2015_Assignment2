// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//	package bkool.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BKOOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BOOL=2, BREAK=3, CLASS=4, CONTINUE=5, DO=6, ELSE=7, EXTENDS=8, 
		FLOAT=9, IF=10, INTEGER=11, NEW=12, STRING=13, THEN=14, WHILE=15, RETURN=16, 
		TRUE=17, FALSE=18, VOID=19, NULL=20, SELF=21, FINAL=22, STATIC=23, IntegerLiteral=24, 
		FloatingPointLiteral=25, BooleanLiteral=26, StringLiteral=27, NullLiteral=28, 
		LPAREN=29, RPAREN=30, LBRACE=31, RBRACE=32, LBRACK=33, RBRACK=34, SEMI=35, 
		COLON=36, COMMA=37, DOT=38, ASSIGN=39, CONSTANTDECLARATION=40, GT=41, 
		LT=42, BANG=43, EQUAL=44, LE=45, GE=46, NOTEQUAL=47, AND=48, OR=49, INC_OR_ADD=50, 
		DEC_OR_SUB=51, MUL=52, FLOATDIV=53, INTDIV=54, CARET=55, MOD=56, Identifier=57, 
		WS=58, COMMENT=59, LINE_COMMENT=60, UNCLOSE_STRING=61;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='"
	};
	public static final String[] ruleNames = {
		"T__0", "BOOL", "BREAK", "CLASS", "CONTINUE", "DO", "ELSE", "EXTENDS", 
		"FLOAT", "IF", "INTEGER", "NEW", "STRING", "THEN", "WHILE", "RETURN", 
		"TRUE", "FALSE", "VOID", "NULL", "SELF", "FINAL", "STATIC", "IntegerLiteral", 
		"DecimalIntegerLiteral", "DecimalNumeral", "Digits", "Digit", "NonZeroDigit", 
		"FloatingPointLiteral", "DecimalFloatingPointLiteral", "ExponentPart", 
		"ExponentIndicator", "SignedInteger", "Sign", "BooleanLiteral", "StringLiteral", 
		"StringCharacters", "StringCharacter", "EscapseSequence", "NullLiteral", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COLON", 
		"COMMA", "DOT", "ASSIGN", "CONSTANTDECLARATION", "GT", "LT", "BANG", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "INC_OR_ADD", "DEC_OR_SUB", "MUL", 
		"FLOATDIV", "INTDIV", "CARET", "MOD", "Identifier", "WS", "COMMENT", "LINE_COMMENT", 
		"UNCLOSE_STRING"
	};


	public BKOOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BKOOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 73: UNCLOSE_STRING_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void UNCLOSE_STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: System.out.print("There is an unclosed string."); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2?\u01d8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\5\33\u0121\n\33\5\33\u0123\n\33\3\34\3\34\7\34\u0127\n\34\f"+
		"\34\16\34\u012a\13\34\3\35\3\35\5\35\u012e\n\35\3\36\3\36\3\37\3\37\3"+
		" \3 \3 \3 \5 \u0138\n \3 \3 \3 \3 \3 \3 \5 \u0140\n \5 \u0142\n \3!\3"+
		"!\3!\3\"\3\"\3#\5#\u014a\n#\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%"+
		"\u0159\n%\3&\3&\5&\u015d\n&\3&\3&\3\'\6\'\u0162\n\'\r\'\16\'\u0163\3("+
		"\3(\5(\u0168\n(\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>"+
		"\3>\3?\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\7G\u01b3"+
		"\nG\fG\16G\u01b6\13G\3H\6H\u01b9\nH\rH\16H\u01ba\3H\3H\3I\3I\3I\3I\7I"+
		"\u01c3\nI\fI\16I\u01c6\13I\3I\3I\3I\3I\3I\3J\3J\7J\u01cf\nJ\fJ\16J\u01d2"+
		"\13J\3J\3J\3K\3K\3K\3\u01c4\2L\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\2\65\2\67\29\2;\2=\33?\2A\2C\2E\2G\2I\34K\35M\2O\2Q\2S\36U\37W"+
		" Y![\"]#_$a%c&e\'g(i)k*m+o,q-s.u/w\60y\61{\62}\63\177\64\u0081\65\u0083"+
		"\66\u0085\67\u00878\u00899\u008b:\u008d;\u008f<\u0091=\u0093>\u0095?\3"+
		"\2\13\3\2\63;\4\2GGgg\4\2--//\4\2$$^^\t\2$$^^ddhhppttvv\5\2C\\aac|\6\2"+
		"\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u01db\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2=\3\2"+
		"\2\2\2I\3\2\2\2\2K\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2"+
		"\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g"+
		"\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2"+
		"\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2"+
		"\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2"+
		"\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\3\u0097\3\2\2\2\5\u009a\3\2\2"+
		"\2\7\u009f\3\2\2\2\t\u00a5\3\2\2\2\13\u00ab\3\2\2\2\r\u00b4\3\2\2\2\17"+
		"\u00b7\3\2\2\2\21\u00bc\3\2\2\2\23\u00c4\3\2\2\2\25\u00ca\3\2\2\2\27\u00cd"+
		"\3\2\2\2\31\u00d5\3\2\2\2\33\u00d9\3\2\2\2\35\u00e0\3\2\2\2\37\u00e5\3"+
		"\2\2\2!\u00eb\3\2\2\2#\u00f2\3\2\2\2%\u00f7\3\2\2\2\'\u00fd\3\2\2\2)\u0102"+
		"\3\2\2\2+\u0107\3\2\2\2-\u010c\3\2\2\2/\u0112\3\2\2\2\61\u0119\3\2\2\2"+
		"\63\u011b\3\2\2\2\65\u0122\3\2\2\2\67\u0124\3\2\2\29\u012d\3\2\2\2;\u012f"+
		"\3\2\2\2=\u0131\3\2\2\2?\u0141\3\2\2\2A\u0143\3\2\2\2C\u0146\3\2\2\2E"+
		"\u0149\3\2\2\2G\u014d\3\2\2\2I\u0158\3\2\2\2K\u015a\3\2\2\2M\u0161\3\2"+
		"\2\2O\u0167\3\2\2\2Q\u0169\3\2\2\2S\u016c\3\2\2\2U\u0171\3\2\2\2W\u0173"+
		"\3\2\2\2Y\u0175\3\2\2\2[\u0177\3\2\2\2]\u0179\3\2\2\2_\u017b\3\2\2\2a"+
		"\u017d\3\2\2\2c\u017f\3\2\2\2e\u0181\3\2\2\2g\u0183\3\2\2\2i\u0185\3\2"+
		"\2\2k\u0188\3\2\2\2m\u018a\3\2\2\2o\u018c\3\2\2\2q\u018e\3\2\2\2s\u0190"+
		"\3\2\2\2u\u0193\3\2\2\2w\u0196\3\2\2\2y\u0199\3\2\2\2{\u019c\3\2\2\2}"+
		"\u019f\3\2\2\2\177\u01a2\3\2\2\2\u0081\u01a4\3\2\2\2\u0083\u01a6\3\2\2"+
		"\2\u0085\u01a8\3\2\2\2\u0087\u01aa\3\2\2\2\u0089\u01ac\3\2\2\2\u008b\u01ae"+
		"\3\2\2\2\u008d\u01b0\3\2\2\2\u008f\u01b8\3\2\2\2\u0091\u01be\3\2\2\2\u0093"+
		"\u01cc\3\2\2\2\u0095\u01d5\3\2\2\2\u0097\u0098\7?\2\2\u0098\u0099\7?\2"+
		"\2\u0099\4\3\2\2\2\u009a\u009b\7d\2\2\u009b\u009c\7q\2\2\u009c\u009d\7"+
		"q\2\2\u009d\u009e\7n\2\2\u009e\6\3\2\2\2\u009f\u00a0\7d\2\2\u00a0\u00a1"+
		"\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7m\2\2\u00a4"+
		"\b\3\2\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7c\2\2\u00a8"+
		"\u00a9\7u\2\2\u00a9\u00aa\7u\2\2\u00aa\n\3\2\2\2\u00ab\u00ac\7e\2\2\u00ac"+
		"\u00ad\7q\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7k\2\2"+
		"\u00b0\u00b1\7p\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7g\2\2\u00b3\f\3\2"+
		"\2\2\u00b4\u00b5\7f\2\2\u00b5\u00b6\7q\2\2\u00b6\16\3\2\2\2\u00b7\u00b8"+
		"\7g\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		"\20\3\2\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7z\2\2\u00be\u00bf\7v\2\2\u00bf"+
		"\u00c0\7g\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3\7u\2\2"+
		"\u00c3\22\3\2\2\2\u00c4\u00c5\7h\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7"+
		"q\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7v\2\2\u00c9\24\3\2\2\2\u00ca\u00cb"+
		"\7k\2\2\u00cb\u00cc\7h\2\2\u00cc\26\3\2\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf"+
		"\7p\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7i\2\2\u00d2"+
		"\u00d3\7g\2\2\u00d3\u00d4\7t\2\2\u00d4\30\3\2\2\2\u00d5\u00d6\7p\2\2\u00d6"+
		"\u00d7\7g\2\2\u00d7\u00d8\7y\2\2\u00d8\32\3\2\2\2\u00d9\u00da\7u\2\2\u00da"+
		"\u00db\7v\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2"+
		"\u00de\u00df\7i\2\2\u00df\34\3\2\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7"+
		"j\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7p\2\2\u00e4\36\3\2\2\2\u00e5\u00e6"+
		"\7y\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7n\2\2\u00e9"+
		"\u00ea\7g\2\2\u00ea \3\2\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7g\2\2\u00ed"+
		"\u00ee\7v\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7p\2\2"+
		"\u00f1\"\3\2\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7w"+
		"\2\2\u00f5\u00f6\7g\2\2\u00f6$\3\2\2\2\u00f7\u00f8\7h\2\2\u00f8\u00f9"+
		"\7c\2\2\u00f9\u00fa\7n\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7g\2\2\u00fc"+
		"&\3\2\2\2\u00fd\u00fe\7x\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7k\2\2\u0100"+
		"\u0101\7f\2\2\u0101(\3\2\2\2\u0102\u0103\7p\2\2\u0103\u0104\7w\2\2\u0104"+
		"\u0105\7n\2\2\u0105\u0106\7n\2\2\u0106*\3\2\2\2\u0107\u0108\7u\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u010a\7n\2\2\u010a\u010b\7h\2\2\u010b,\3\2\2\2\u010c"+
		"\u010d\7h\2\2\u010d\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0110\7c\2\2"+
		"\u0110\u0111\7n\2\2\u0111.\3\2\2\2\u0112\u0113\7u\2\2\u0113\u0114\7v\2"+
		"\2\u0114\u0115\7c\2\2\u0115\u0116\7v\2\2\u0116\u0117\7k\2\2\u0117\u0118"+
		"\7e\2\2\u0118\60\3\2\2\2\u0119\u011a\5\63\32\2\u011a\62\3\2\2\2\u011b"+
		"\u011c\5\65\33\2\u011c\64\3\2\2\2\u011d\u0123\7\62\2\2\u011e\u0120\5;"+
		"\36\2\u011f\u0121\5\67\34\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0123\3\2\2\2\u0122\u011d\3\2\2\2\u0122\u011e\3\2\2\2\u0123\66\3\2\2"+
		"\2\u0124\u0128\59\35\2\u0125\u0127\59\35\2\u0126\u0125\3\2\2\2\u0127\u012a"+
		"\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u01298\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b\u012e\7\62\2\2\u012c\u012e\5;\36\2\u012d\u012b\3"+
		"\2\2\2\u012d\u012c\3\2\2\2\u012e:\3\2\2\2\u012f\u0130\t\2\2\2\u0130<\3"+
		"\2\2\2\u0131\u0132\5? \2\u0132>\3\2\2\2\u0133\u0134\5\67\34\2\u0134\u0135"+
		"\7\60\2\2\u0135\u0137\5\67\34\2\u0136\u0138\5A!\2\u0137\u0136\3\2\2\2"+
		"\u0137\u0138\3\2\2\2\u0138\u0142\3\2\2\2\u0139\u013a\5\67\34\2\u013a\u013b"+
		"\5A!\2\u013b\u0142\3\2\2\2\u013c\u013d\5\67\34\2\u013d\u013f\7\60\2\2"+
		"\u013e\u0140\5\67\34\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142"+
		"\3\2\2\2\u0141\u0133\3\2\2\2\u0141\u0139\3\2\2\2\u0141\u013c\3\2\2\2\u0142"+
		"@\3\2\2\2\u0143\u0144\5C\"\2\u0144\u0145\5E#\2\u0145B\3\2\2\2\u0146\u0147"+
		"\t\3\2\2\u0147D\3\2\2\2\u0148\u014a\5G$\2\u0149\u0148\3\2\2\2\u0149\u014a"+
		"\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\5\67\34\2\u014cF\3\2\2\2\u014d"+
		"\u014e\t\4\2\2\u014eH\3\2\2\2\u014f\u0150\7v\2\2\u0150\u0151\7t\2\2\u0151"+
		"\u0152\7w\2\2\u0152\u0159\7g\2\2\u0153\u0154\7h\2\2\u0154\u0155\7c\2\2"+
		"\u0155\u0156\7n\2\2\u0156\u0157\7u\2\2\u0157\u0159\7g\2\2\u0158\u014f"+
		"\3\2\2\2\u0158\u0153\3\2\2\2\u0159J\3\2\2\2\u015a\u015c\7$\2\2\u015b\u015d"+
		"\5M\'\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015f\7$\2\2\u015fL\3\2\2\2\u0160\u0162\5O(\2\u0161\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164N\3\2\2\2"+
		"\u0165\u0168\n\5\2\2\u0166\u0168\5Q)\2\u0167\u0165\3\2\2\2\u0167\u0166"+
		"\3\2\2\2\u0168P\3\2\2\2\u0169\u016a\7^\2\2\u016a\u016b\t\6\2\2\u016bR"+
		"\3\2\2\2\u016c\u016d\7p\2\2\u016d\u016e\7w\2\2\u016e\u016f\7n\2\2\u016f"+
		"\u0170\7n\2\2\u0170T\3\2\2\2\u0171\u0172\7*\2\2\u0172V\3\2\2\2\u0173\u0174"+
		"\7+\2\2\u0174X\3\2\2\2\u0175\u0176\7}\2\2\u0176Z\3\2\2\2\u0177\u0178\7"+
		"\177\2\2\u0178\\\3\2\2\2\u0179\u017a\7]\2\2\u017a^\3\2\2\2\u017b\u017c"+
		"\7_\2\2\u017c`\3\2\2\2\u017d\u017e\7=\2\2\u017eb\3\2\2\2\u017f\u0180\7"+
		"<\2\2\u0180d\3\2\2\2\u0181\u0182\7.\2\2\u0182f\3\2\2\2\u0183\u0184\7\60"+
		"\2\2\u0184h\3\2\2\2\u0185\u0186\7<\2\2\u0186\u0187\7?\2\2\u0187j\3\2\2"+
		"\2\u0188\u0189\7?\2\2\u0189l\3\2\2\2\u018a\u018b\7@\2\2\u018bn\3\2\2\2"+
		"\u018c\u018d\7>\2\2\u018dp\3\2\2\2\u018e\u018f\7#\2\2\u018fr\3\2\2\2\u0190"+
		"\u0191\7-\2\2\u0191\u0192\7-\2\2\u0192t\3\2\2\2\u0193\u0194\7>\2\2\u0194"+
		"\u0195\7?\2\2\u0195v\3\2\2\2\u0196\u0197\7@\2\2\u0197\u0198\7?\2\2\u0198"+
		"x\3\2\2\2\u0199\u019a\7>\2\2\u019a\u019b\7@\2\2\u019bz\3\2\2\2\u019c\u019d"+
		"\7(\2\2\u019d\u019e\7(\2\2\u019e|\3\2\2\2\u019f\u01a0\7~\2\2\u01a0\u01a1"+
		"\7~\2\2\u01a1~\3\2\2\2\u01a2\u01a3\7-\2\2\u01a3\u0080\3\2\2\2\u01a4\u01a5"+
		"\7/\2\2\u01a5\u0082\3\2\2\2\u01a6\u01a7\7,\2\2\u01a7\u0084\3\2\2\2\u01a8"+
		"\u01a9\7\61\2\2\u01a9\u0086\3\2\2\2\u01aa\u01ab\7^\2\2\u01ab\u0088\3\2"+
		"\2\2\u01ac\u01ad\7`\2\2\u01ad\u008a\3\2\2\2\u01ae\u01af\7\'\2\2\u01af"+
		"\u008c\3\2\2\2\u01b0\u01b4\t\7\2\2\u01b1\u01b3\t\b\2\2\u01b2\u01b1\3\2"+
		"\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u008e\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b9\t\t\2\2\u01b8\u01b7\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bc\3\2\2\2\u01bc\u01bd\bH\2\2\u01bd\u0090\3\2\2\2\u01be\u01bf\7*\2"+
		"\2\u01bf\u01c0\7,\2\2\u01c0\u01c4\3\2\2\2\u01c1\u01c3\13\2\2\2\u01c2\u01c1"+
		"\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5"+
		"\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\7,\2\2\u01c8\u01c9\7+\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\bI\2\2\u01cb\u0092\3\2\2\2\u01cc\u01d0"+
		"\7%\2\2\u01cd\u01cf\n\n\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0"+
		"\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01d0\3\2"+
		"\2\2\u01d3\u01d4\bJ\2\2\u01d4\u0094\3\2\2\2\u01d5\u01d6\7$\2\2\u01d6\u01d7"+
		"\bK\3\2\u01d7\u0096\3\2\2\2\23\2\u0120\u0122\u0128\u012d\u0137\u013f\u0141"+
		"\u0149\u0158\u015c\u0163\u0167\u01b4\u01ba\u01c4\u01d0\4\b\2\2\3K\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}