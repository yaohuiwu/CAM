// Generated from /home/yaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
package org.cam.core.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PermissionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		STAR=10, GT=11, GE=12, EQ=13, NE=14, LT=15, LE=16, LIKE=17, TRUE=18, FALSE=19, 
		ID=20, STRING=21, FLOAT=22, INT=23, WS=24;
	public static final String[] tokenNames = {
		"<INVALID>", "'in'", "'.'", "')'", "','", "'or'", "'('", "':'", "'null'", 
		"'and'", "'*'", "'>'", "'>='", "'='", "'!='", "'<'", "'<='", "'like'", 
		"'true'", "'false'", "ID", "STRING", "FLOAT", "INT", "WS"
	};
	public static final int
		RULE_permission = 0, RULE_action = 1, RULE_objectType = 2, RULE_criteria = 3, 
		RULE_condition = 4, RULE_value = 5;
	public static final String[] ruleNames = {
		"permission", "action", "objectType", "criteria", "condition", "value"
	};

	@Override
	public String getGrammarFileName() { return "Permission.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PermissionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PermissionContext extends ParserRuleContext {
		public CriteriaContext criteria() {
			return getRuleContext(CriteriaContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public PermissionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_permission; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterPermission(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitPermission(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitPermission(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PermissionContext permission() throws RecognitionException {
		PermissionContext _localctx = new PermissionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_permission);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); action();
			setState(13); match(T__2);
			setState(14); objectType();
			setState(15); match(T__2);
			setState(16); criteria();
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public TerminalNode STAR() { return getToken(PermissionParser.STAR, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_la = _input.LA(1);
			if ( !(_la==STAR || _la==ID) ) {
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

	public static class ObjectTypeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PermissionParser.ID); }
		public TerminalNode STAR() { return getToken(PermissionParser.STAR, 0); }
		public TerminalNode ID(int i) {
			return getToken(PermissionParser.ID, i);
		}
		public ObjectTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterObjectType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitObjectType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitObjectType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectTypeContext objectType() throws RecognitionException {
		ObjectTypeContext _localctx = new ObjectTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_objectType);
		int _la;
		try {
			setState(29);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(20); match(ID);
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(21); match(T__7);
					setState(22); match(ID);
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); match(STAR);
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

	public static class CriteriaContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PermissionParser.STAR, 0); }
		public CriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_criteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CriteriaContext criteria() throws RecognitionException {
		CriteriaContext _localctx = new CriteriaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_criteria);
		try {
			setState(33);
			switch (_input.LA(1)) {
			case T__3:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(31); condition(0);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(32); match(STAR);
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

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndExprContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public AndExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentExprContext extends ConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ParentExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterParentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitParentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitParentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InExprContext extends ConditionContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public InExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitInExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitInExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public OrExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ConditionContext {
		public Token op;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public CompExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new CompExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(36); match(ID);
				setState(37);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << EQ) | (1L << NE) | (1L << LT) | (1L << LE) | (1L << LIKE))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(38); value();
				}
				break;
			case 2:
				{
				_localctx = new InExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39); match(ID);
				setState(40); match(T__8);
				setState(41); match(T__3);
				setState(42); value();
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(43); match(T__5);
					setState(44); value();
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(50); match(T__6);
				}
				break;
			case 3:
				{
				_localctx = new ParentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52); match(T__3);
				setState(53); condition(0);
				setState(54); match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(64);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AndExprContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(58);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(59); match(T__0);
						setState(60); condition(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExprContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(61);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(62); match(T__4);
						setState(63); condition(3);
						}
						break;
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Token boo;
		public TerminalNode FLOAT() { return getToken(PermissionParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(PermissionParser.INT, 0); }
		public TerminalNode STRING() { return getToken(PermissionParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		int _la;
		try {
			setState(74);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(71); match(FLOAT);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				((ValueContext)_localctx).boo = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((ValueContext)_localctx).boo = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 5);
				{
				setState(73); match(T__1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32O\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\7\4\32\n\4\f\4\16\4\35\13\4\3\4\5\4 \n\4\3\5\3\5\5\5$\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\60\n\6\f\6\16\6\63\13\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6;\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6C\n\6\f\6\16\6"+
		"F\13\6\3\7\3\7\3\7\3\7\3\7\5\7M\n\7\3\7\2\3\n\b\2\4\6\b\n\f\2\5\4\2\f"+
		"\f\26\26\3\2\r\23\3\2\24\25T\2\16\3\2\2\2\4\24\3\2\2\2\6\37\3\2\2\2\b"+
		"#\3\2\2\2\n:\3\2\2\2\fL\3\2\2\2\16\17\5\4\3\2\17\20\7\t\2\2\20\21\5\6"+
		"\4\2\21\22\7\t\2\2\22\23\5\b\5\2\23\3\3\2\2\2\24\25\t\2\2\2\25\5\3\2\2"+
		"\2\26\33\7\26\2\2\27\30\7\4\2\2\30\32\7\26\2\2\31\27\3\2\2\2\32\35\3\2"+
		"\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34 \3\2\2\2\35\33\3\2\2\2\36 \7\f\2\2"+
		"\37\26\3\2\2\2\37\36\3\2\2\2 \7\3\2\2\2!$\5\n\6\2\"$\7\f\2\2#!\3\2\2\2"+
		"#\"\3\2\2\2$\t\3\2\2\2%&\b\6\1\2&\'\7\26\2\2\'(\t\3\2\2(;\5\f\7\2)*\7"+
		"\26\2\2*+\7\3\2\2+,\7\b\2\2,\61\5\f\7\2-.\7\6\2\2.\60\5\f\7\2/-\3\2\2"+
		"\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2"+
		"\64\65\7\5\2\2\65;\3\2\2\2\66\67\7\b\2\2\678\5\n\6\289\7\5\2\29;\3\2\2"+
		"\2:%\3\2\2\2:)\3\2\2\2:\66\3\2\2\2;D\3\2\2\2<=\f\5\2\2=>\7\13\2\2>C\5"+
		"\n\6\6?@\f\4\2\2@A\7\7\2\2AC\5\n\6\5B<\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3"+
		"\2\2\2DE\3\2\2\2E\13\3\2\2\2FD\3\2\2\2GM\7\27\2\2HM\7\31\2\2IM\7\30\2"+
		"\2JM\t\4\2\2KM\7\n\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2"+
		"\2M\r\3\2\2\2\n\33\37#\61:BDL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}