// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//package bkool.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BKOOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMI=1, ASSIGN=2, COMMA=3, LBRAC=4, RBRAC=5, LPAREN=6, RPAREN=7, ADD=8, 
		SUB=9, MUL=10, DIV=11, INTTYPE=12, FLOATTYPE=13, FLOATLIT=14, INTLIT=15, 
		IDENTIFIER=16, CLASS=17, WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "'='", "','", "'('", "')'", "'{'", "'}'", "'+'", "'-'", 
		"'*'", "'/'", "'int'", "'float'", "FLOATLIT", "INTLIT", "IDENTIFIER", 
		"'class'", "WS"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_var_dl = 3, RULE_idlist = 4, 
		RULE_func_decl = 5, RULE_mctype = 6, RULE_parlist = 7, RULE_body = 8, 
		RULE_mem = 9, RULE_stmt = 10, RULE_assign = 11, RULE_call = 12, RULE_explist = 13, 
		RULE_exp = 14, RULE_moreterm = 15, RULE_term = 16, RULE_morefact = 17, 
		RULE_fact = 18;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "var_dl", "idlist", "func_decl", "mctype", 
		"parlist", "body", "mem", "stmt", "assign", "call", "explist", "exp", 
		"moreterm", "term", "morefact", "fact"
	};

	@Override
	public String getGrammarFileName() { return "BKOOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BKOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BKOOLParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); decl();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(43); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BKOOLParser.IDENTIFIER, 0); }
		public TerminalNode CLASS() { return getToken(BKOOLParser.CLASS, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(CLASS);
			setState(46); match(IDENTIFIER);
			setState(47); match(LPAREN);
			setState(48); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public IdlistContext idlist() {
			return getRuleContext(IdlistContext.class,0);
		}
		public MctypeContext mctype() {
			return getRuleContext(MctypeContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); mctype();
			setState(51); idlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_dlContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(BKOOLParser.SEMI, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_dlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_dl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterVar_dl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitVar_dl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitVar_dl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_dlContext var_dl() throws RecognitionException {
		Var_dlContext _localctx = new Var_dlContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_dl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); var_decl();
			setState(54); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdlistContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BKOOLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BKOOLParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(BKOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BKOOLParser.COMMA, i);
		}
		public IdlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterIdlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitIdlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitIdlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdlistContext idlist() throws RecognitionException {
		IdlistContext _localctx = new IdlistContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_idlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); match(IDENTIFIER);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(57); match(COMMA);
				setState(58); match(IDENTIFIER);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declContext extends ParserRuleContext {
		public ParlistContext parlist() {
			return getRuleContext(ParlistContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode LBRAC() { return getToken(BKOOLParser.LBRAC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BKOOLParser.IDENTIFIER, 0); }
		public TerminalNode RBRAC() { return getToken(BKOOLParser.RBRAC, 0); }
		public MctypeContext mctype() {
			return getRuleContext(MctypeContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitFunc_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitFunc_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); mctype();
			setState(65); match(IDENTIFIER);
			setState(66); match(LBRAC);
			setState(68);
			_la = _input.LA(1);
			if (_la==INTTYPE || _la==FLOATTYPE) {
				{
				setState(67); parlist();
				}
			}

			setState(70); match(RBRAC);
			setState(71); body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MctypeContext extends ParserRuleContext {
		public TerminalNode FLOATTYPE() { return getToken(BKOOLParser.FLOATTYPE, 0); }
		public TerminalNode INTTYPE() { return getToken(BKOOLParser.INTTYPE, 0); }
		public MctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mctype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterMctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitMctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MctypeContext mctype() throws RecognitionException {
		MctypeContext _localctx = new MctypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mctype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==INTTYPE || _la==FLOATTYPE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParlistContext extends ParserRuleContext {
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(BKOOLParser.SEMI); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public TerminalNode SEMI(int i) {
			return getToken(BKOOLParser.SEMI, i);
		}
		public ParlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterParlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitParlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitParlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParlistContext parlist() throws RecognitionException {
		ParlistContext _localctx = new ParlistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); var_decl();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(76); match(SEMI);
				setState(77); var_decl();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<MemContext> mem() {
			return getRuleContexts(MemContext.class);
		}
		public TerminalNode RPAREN() { return getToken(BKOOLParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(BKOOLParser.LPAREN, 0); }
		public MemContext mem(int i) {
			return getRuleContext(MemContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(LPAREN);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTTYPE) | (1L << FLOATTYPE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(84); mem();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemContext extends ParserRuleContext {
		public Var_dlContext var_dl() {
			return getRuleContext(Var_dlContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public MemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterMem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitMem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemContext mem() throws RecognitionException {
		MemContext _localctx = new MemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mem);
		try {
			setState(94);
			switch (_input.LA(1)) {
			case INTTYPE:
			case FLOATTYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(92); var_dl();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(93); stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96); assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); call();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(BKOOLParser.ASSIGN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BKOOLParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(BKOOLParser.SEMI, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); match(IDENTIFIER);
			setState(101); match(ASSIGN);
			setState(102); exp();
			setState(103); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TerminalNode LBRAC() { return getToken(BKOOLParser.LBRAC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BKOOLParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(BKOOLParser.SEMI, 0); }
		public TerminalNode RBRAC() { return getToken(BKOOLParser.RBRAC, 0); }
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); match(IDENTIFIER);
			setState(106); match(LBRAC);
			setState(108);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRAC) | (1L << FLOATLIT) | (1L << INTLIT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(107); explist();
				}
			}

			setState(110); match(RBRAC);
			setState(111); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplistContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(BKOOLParser.COMMA); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BKOOLParser.COMMA, i);
		}
		public ExplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterExplist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitExplist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitExplist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplistContext explist() throws RecognitionException {
		ExplistContext _localctx = new ExplistContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_explist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); exp();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(114); match(COMMA);
				setState(115); exp();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public MoretermContext moreterm(int i) {
			return getRuleContext(MoretermContext.class,i);
		}
		public List<MoretermContext> moreterm() {
			return getRuleContexts(MoretermContext.class);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); term();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(122); moreterm();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MoretermContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode SUB() { return getToken(BKOOLParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(BKOOLParser.ADD, 0); }
		public MoretermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moreterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterMoreterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitMoreterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMoreterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoretermContext moreterm() throws RecognitionException {
		MoretermContext _localctx = new MoretermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_moreterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(129); term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public MorefactContext morefact(int i) {
			return getRuleContext(MorefactContext.class,i);
		}
		public List<MorefactContext> morefact() {
			return getRuleContexts(MorefactContext.class);
		}
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); fact();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(132); morefact();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MorefactContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(BKOOLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(BKOOLParser.DIV, 0); }
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public MorefactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_morefact; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterMorefact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitMorefact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitMorefact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MorefactContext morefact() throws RecognitionException {
		MorefactContext _localctx = new MorefactContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_morefact);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(139); fact();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactContext extends ParserRuleContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TerminalNode LBRAC() { return getToken(BKOOLParser.LBRAC, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BKOOLParser.IDENTIFIER, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRAC() { return getToken(BKOOLParser.RBRAC, 0); }
		public TerminalNode INTLIT() { return getToken(BKOOLParser.INTLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(BKOOLParser.FLOATLIT, 0); }
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).enterFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BKOOLListener ) ((BKOOLListener)listener).exitFact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BKOOLVisitor ) return ((BKOOLVisitor<? extends T>)visitor).visitFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fact);
		int _la;
		try {
			setState(155);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); match(IDENTIFIER);
				setState(147);
				_la = _input.LA(1);
				if (_la==LBRAC) {
					{
					setState(142); match(LBRAC);
					setState(144);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRAC) | (1L << FLOATLIT) | (1L << INTLIT) | (1L << IDENTIFIER))) != 0)) {
						{
						setState(143); explist();
						}
					}

					setState(146); match(RBRAC);
					}
				}

				}
				break;
			case INTLIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(149); match(INTLIT);
				}
				break;
			case FLOATLIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(150); match(FLOATLIT);
				}
				break;
			case LBRAC:
				enterOuterAlt(_localctx, 4);
				{
				setState(151); match(LBRAC);
				setState(152); exp();
				setState(153); match(RBRAC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\6\2*\n\2\r\2\16\2+\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\7\6>\n\6\f\6\16\6A\13\6\3\7\3\7"+
		"\3\7\3\7\5\7G\n\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\7\tQ\n\t\f\t\16\tT\13"+
		"\t\3\n\3\n\7\nX\n\n\f\n\16\n[\13\n\3\n\3\n\3\13\3\13\5\13a\n\13\3\f\3"+
		"\f\5\fe\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16o\n\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\7\17w\n\17\f\17\16\17z\13\17\3\20\3\20\7\20~\n\20\f"+
		"\20\16\20\u0081\13\20\3\21\3\21\3\21\3\22\3\22\7\22\u0088\n\22\f\22\16"+
		"\22\u008b\13\22\3\23\3\23\3\23\3\24\3\24\3\24\5\24\u0093\n\24\3\24\5\24"+
		"\u0096\n\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u009e\n\24\3\24\2\2\25"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\3\2\16\17\3\2\n\13\3"+
		"\2\f\r\u009c\2)\3\2\2\2\4/\3\2\2\2\6\64\3\2\2\2\b\67\3\2\2\2\n:\3\2\2"+
		"\2\fB\3\2\2\2\16K\3\2\2\2\20M\3\2\2\2\22U\3\2\2\2\24`\3\2\2\2\26d\3\2"+
		"\2\2\30f\3\2\2\2\32k\3\2\2\2\34s\3\2\2\2\36{\3\2\2\2 \u0082\3\2\2\2\""+
		"\u0085\3\2\2\2$\u008c\3\2\2\2&\u009d\3\2\2\2(*\5\4\3\2)(\3\2\2\2*+\3\2"+
		"\2\2+)\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\2\2\3.\3\3\2\2\2/\60\7\23\2\2\60"+
		"\61\7\22\2\2\61\62\7\b\2\2\62\63\7\t\2\2\63\5\3\2\2\2\64\65\5\16\b\2\65"+
		"\66\5\n\6\2\66\7\3\2\2\2\678\5\6\4\289\7\3\2\29\t\3\2\2\2:?\7\22\2\2;"+
		"<\7\5\2\2<>\7\22\2\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\13\3\2\2"+
		"\2A?\3\2\2\2BC\5\16\b\2CD\7\22\2\2DF\7\6\2\2EG\5\20\t\2FE\3\2\2\2FG\3"+
		"\2\2\2GH\3\2\2\2HI\7\7\2\2IJ\5\22\n\2J\r\3\2\2\2KL\t\2\2\2L\17\3\2\2\2"+
		"MR\5\6\4\2NO\7\3\2\2OQ\5\6\4\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2"+
		"S\21\3\2\2\2TR\3\2\2\2UY\7\b\2\2VX\5\24\13\2WV\3\2\2\2X[\3\2\2\2YW\3\2"+
		"\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7\t\2\2]\23\3\2\2\2^a\5\b\5\2_"+
		"a\5\26\f\2`^\3\2\2\2`_\3\2\2\2a\25\3\2\2\2be\5\30\r\2ce\5\32\16\2db\3"+
		"\2\2\2dc\3\2\2\2e\27\3\2\2\2fg\7\22\2\2gh\7\4\2\2hi\5\36\20\2ij\7\3\2"+
		"\2j\31\3\2\2\2kl\7\22\2\2ln\7\6\2\2mo\5\34\17\2nm\3\2\2\2no\3\2\2\2op"+
		"\3\2\2\2pq\7\7\2\2qr\7\3\2\2r\33\3\2\2\2sx\5\36\20\2tu\7\5\2\2uw\5\36"+
		"\20\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\35\3\2\2\2zx\3\2\2\2{\177"+
		"\5\"\22\2|~\5 \21\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\37\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\t\3\2\2\u0083\u0084"+
		"\5\"\22\2\u0084!\3\2\2\2\u0085\u0089\5&\24\2\u0086\u0088\5$\23\2\u0087"+
		"\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a#\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\t\4\2\2\u008d\u008e"+
		"\5&\24\2\u008e%\3\2\2\2\u008f\u0095\7\22\2\2\u0090\u0092\7\6\2\2\u0091"+
		"\u0093\5\34\17\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0096\7\7\2\2\u0095\u0090\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u009e\3\2\2\2\u0097\u009e\7\21\2\2\u0098\u009e\7\20\2\2\u0099\u009a\7"+
		"\6\2\2\u009a\u009b\5\36\20\2\u009b\u009c\7\7\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u008f\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0098\3\2\2\2\u009d\u0099\3\2"+
		"\2\2\u009e\'\3\2\2\2\20+?FRY`dnx\177\u0089\u0092\u0095\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}