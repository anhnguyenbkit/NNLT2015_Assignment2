// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//package bkool.parser;

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
		SEMI=1, ASSIGN=2, COMMA=3, LBRAC=4, RBRAC=5, LPAREN=6, RPAREN=7, ADD=8, 
		SUB=9, MUL=10, DIV=11, INTTYPE=12, FLOATTYPE=13, FLOATLIT=14, INTLIT=15, 
		IDENTIFIER=16, CLASS=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'"
	};
	public static final String[] ruleNames = {
		"SEMI", "ASSIGN", "COMMA", "LBRAC", "RBRAC", "LPAREN", "RPAREN", "ADD", 
		"SUB", "MUL", "DIV", "INTTYPE", "FLOATTYPE", "FLOATLIT", "INTLIT", "IDENTIFIER", 
		"CLASS", "WS"
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\6\17I\n\17\r\17\16\17J\3\17\3\17\6\17O\n\17\r\17\16\17P\3\20"+
		"\6\20T\n\20\r\20\16\20U\3\21\6\21Y\n\21\r\21\16\21Z\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\5\3\2\62;\3"+
		"\2c|\5\2\13\f\17\17\"\"i\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2"+
		"\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23"+
		"\67\3\2\2\2\259\3\2\2\2\27;\3\2\2\2\31=\3\2\2\2\33A\3\2\2\2\35H\3\2\2"+
		"\2\37S\3\2\2\2!X\3\2\2\2#\\\3\2\2\2%b\3\2\2\2\'(\7=\2\2(\4\3\2\2\2)*\7"+
		"?\2\2*\6\3\2\2\2+,\7.\2\2,\b\3\2\2\2-.\7*\2\2.\n\3\2\2\2/\60\7+\2\2\60"+
		"\f\3\2\2\2\61\62\7}\2\2\62\16\3\2\2\2\63\64\7\177\2\2\64\20\3\2\2\2\65"+
		"\66\7-\2\2\66\22\3\2\2\2\678\7/\2\28\24\3\2\2\29:\7,\2\2:\26\3\2\2\2;"+
		"<\7\61\2\2<\30\3\2\2\2=>\7k\2\2>?\7p\2\2?@\7v\2\2@\32\3\2\2\2AB\7h\2\2"+
		"BC\7n\2\2CD\7q\2\2DE\7c\2\2EF\7v\2\2F\34\3\2\2\2GI\t\2\2\2HG\3\2\2\2I"+
		"J\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2LN\7\60\2\2MO\t\2\2\2NM\3\2\2\2"+
		"OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\36\3\2\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2"+
		"\2US\3\2\2\2UV\3\2\2\2V \3\2\2\2WY\t\3\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2"+
		"\2Z[\3\2\2\2[\"\3\2\2\2\\]\7e\2\2]^\7n\2\2^_\7c\2\2_`\7u\2\2`a\7u\2\2"+
		"a$\3\2\2\2bc\t\4\2\2cd\3\2\2\2de\b\23\2\2e&\3\2\2\2\7\2JPUZ\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}