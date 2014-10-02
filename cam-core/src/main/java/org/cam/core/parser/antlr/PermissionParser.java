// Generated from /home/wuyaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, STAR=16, GT=17, 
		GE=18, EQ=19, NE=20, LT=21, LE=22, LIKE=23, TRUE=24, FALSE=25, NULL=26, 
		ID=27, STRING=28, FLOAT=29, INT=30, WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'from'", "')'", "'in'", "'.'", "'select'", "','", "'or'", 
		"'('", "':'", "'${'", "'user'", "'as'", "'and'", "'where'", "'}'", "'*'", 
		"'>'", "'>='", "'='", "'!='", "'<'", "'<='", "'like'", "'true'", "'false'", 
		"'null'", "ID", "STRING", "FLOAT", "INT", "WS"
	};
	public static final int
		RULE_permission = 0, RULE_action = 1, RULE_objectType = 2, RULE_criteria = 3, 
		RULE_condition = 4, RULE_list = 5, RULE_literalList = 6, RULE_queryList = 7, 
		RULE_idAlias = 8, RULE_entity = 9, RULE_value = 10, RULE_scalarVariable = 11, 
		RULE_innerObject = 12;
	public static final String[] ruleNames = {
		"permission", "action", "objectType", "criteria", "condition", "list", 
		"literalList", "queryList", "idAlias", "entity", "value", "scalarVariable", 
		"innerObject"
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
			setState(26); action();
			setState(27); match(T__6);
			setState(28); objectType();
			setState(29); match(T__6);
			setState(30); criteria();
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
			setState(32);
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
			setState(43);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); match(ID);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(35); match(T__11);
					setState(36); match(ID);
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); match(STAR);
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
			setState(47);
			switch (_input.LA(1)) {
			case T__7:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); condition(0);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(46); match(STAR);
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
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
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
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new CompExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(50); match(ID);
				setState(51);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << EQ) | (1L << NE) | (1L << LT) | (1L << LE) | (1L << LIKE))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(52); value();
				}
				break;
			case 2:
				{
				_localctx = new InExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53); match(ID);
				setState(54); match(T__12);
				setState(55); match(T__7);
				setState(56); list();
				setState(57); match(T__13);
				}
				break;
			case 3:
				{
				_localctx = new ParentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); match(T__7);
				setState(60); condition(0);
				setState(61); match(T__13);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(71);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new AndExprContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(65);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(66); match(T__2);
						setState(67); condition(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExprContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(68);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(69); match(T__8);
						setState(70); condition(3);
						}
						break;
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ListContext extends ParserRuleContext {
		public QueryListContext queryList() {
			return getRuleContext(QueryListContext.class,0);
		}
		public LiteralListContext literalList() {
			return getRuleContext(LiteralListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_list);
		try {
			setState(78);
			switch (_input.LA(1)) {
			case T__5:
			case TRUE:
			case FALSE:
			case NULL:
			case ID:
			case STRING:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(76); literalList();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(77); queryList();
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

	public static class LiteralListContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public LiteralListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterLiteralList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitLiteralList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitLiteralList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralListContext literalList() throws RecognitionException {
		LiteralListContext _localctx = new LiteralListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_literalList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); value();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(81); match(T__9);
				setState(82); value();
				}
				}
				setState(87);
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

	public static class QueryListContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public IdAliasContext idAlias() {
			return getRuleContext(IdAliasContext.class,0);
		}
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public QueryListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterQueryList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitQueryList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitQueryList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryListContext queryList() throws RecognitionException {
		QueryListContext _localctx = new QueryListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_queryList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(T__10);
			setState(89); idAlias();
			setState(90); match(T__14);
			setState(91); entity();
			setState(94);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(92); match(T__3);
				setState(93); match(ID);
				}
			}

			setState(96); match(T__1);
			setState(97); condition(0);
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

	public static class IdAliasContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PermissionParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PermissionParser.ID, i);
		}
		public IdAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterIdAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitIdAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitIdAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdAliasContext idAlias() throws RecognitionException {
		IdAliasContext _localctx = new IdAliasContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_idAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(ID);
			setState(102);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(100); match(T__3);
				setState(101); match(ID);
				}
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

	public static class EntityContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PermissionParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PermissionParser.ID, i);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitEntity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitEntity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(ID);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(105); match(T__11);
				setState(106); match(ID);
				}
				}
				setState(111);
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

	public static class ValueContext extends ParserRuleContext {
		public Token boo;
		public TerminalNode FLOAT() { return getToken(PermissionParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(PermissionParser.INT, 0); }
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public TerminalNode NULL() { return getToken(PermissionParser.NULL, 0); }
		public TerminalNode STRING() { return getToken(PermissionParser.STRING, 0); }
		public ScalarVariableContext scalarVariable() {
			return getRuleContext(ScalarVariableContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			setState(119);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(112); match(ID);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(113); scalarVariable();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(114); match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(115); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(116); match(FLOAT);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(117);
				((ValueContext)_localctx).boo = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((ValueContext)_localctx).boo = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(118); match(NULL);
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

	public static class ScalarVariableContext extends ParserRuleContext {
		public InnerObjectContext innerObject() {
			return getRuleContext(InnerObjectContext.class,0);
		}
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public ScalarVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterScalarVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitScalarVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitScalarVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarVariableContext scalarVariable() throws RecognitionException {
		ScalarVariableContext _localctx = new ScalarVariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_scalarVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(T__5);
			setState(122); innerObject();
			setState(123); match(T__11);
			setState(124); match(ID);
			setState(125); match(T__0);
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

	public static class InnerObjectContext extends ParserRuleContext {
		public InnerObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterInnerObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitInnerObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitInnerObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerObjectContext innerObject() throws RecognitionException {
		InnerObjectContext _localctx = new InnerObjectContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_innerObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(T__4);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0084\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\4\7\4(\n\4\f\4\16\4+\13\4\3\4\5\4.\n\4\3\5\3\5\5\5\62\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6B\n\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\3\7\5\7Q\n\7\3\b\3\b\3\b\7\bV\n"+
		"\b\f\b\16\bY\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\5\ni\n\n\3\13\3\13\3\13\7\13n\n\13\f\13\16\13q\13\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\fz\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\2\3\n"+
		"\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\5\4\2\22\22\35\35\3\2\23\31\3\2"+
		"\32\33\u0088\2\34\3\2\2\2\4\"\3\2\2\2\6-\3\2\2\2\b\61\3\2\2\2\nA\3\2\2"+
		"\2\fP\3\2\2\2\16R\3\2\2\2\20Z\3\2\2\2\22e\3\2\2\2\24j\3\2\2\2\26y\3\2"+
		"\2\2\30{\3\2\2\2\32\u0081\3\2\2\2\34\35\5\4\3\2\35\36\7\13\2\2\36\37\5"+
		"\6\4\2\37 \7\13\2\2 !\5\b\5\2!\3\3\2\2\2\"#\t\2\2\2#\5\3\2\2\2$)\7\35"+
		"\2\2%&\7\6\2\2&(\7\35\2\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*."+
		"\3\2\2\2+)\3\2\2\2,.\7\22\2\2-$\3\2\2\2-,\3\2\2\2.\7\3\2\2\2/\62\5\n\6"+
		"\2\60\62\7\22\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\t\3\2\2\2\63\64\b\6\1\2"+
		"\64\65\7\35\2\2\65\66\t\3\2\2\66B\5\26\f\2\678\7\35\2\289\7\5\2\29:\7"+
		"\n\2\2:;\5\f\7\2;<\7\4\2\2<B\3\2\2\2=>\7\n\2\2>?\5\n\6\2?@\7\4\2\2@B\3"+
		"\2\2\2A\63\3\2\2\2A\67\3\2\2\2A=\3\2\2\2BK\3\2\2\2CD\f\5\2\2DE\7\17\2"+
		"\2EJ\5\n\6\6FG\f\4\2\2GH\7\t\2\2HJ\5\n\6\5IC\3\2\2\2IF\3\2\2\2JM\3\2\2"+
		"\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2MK\3\2\2\2NQ\5\16\b\2OQ\5\20\t\2PN\3"+
		"\2\2\2PO\3\2\2\2Q\r\3\2\2\2RW\5\26\f\2ST\7\b\2\2TV\5\26\f\2US\3\2\2\2"+
		"VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\17\3\2\2\2YW\3\2\2\2Z[\7\7\2\2[\\\5\22"+
		"\n\2\\]\7\3\2\2]`\5\24\13\2^_\7\16\2\2_a\7\35\2\2`^\3\2\2\2`a\3\2\2\2"+
		"ab\3\2\2\2bc\7\20\2\2cd\5\n\6\2d\21\3\2\2\2eh\7\35\2\2fg\7\16\2\2gi\7"+
		"\35\2\2hf\3\2\2\2hi\3\2\2\2i\23\3\2\2\2jo\7\35\2\2kl\7\6\2\2ln\7\35\2"+
		"\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\25\3\2\2\2qo\3\2\2\2rz\7\35"+
		"\2\2sz\5\30\r\2tz\7\36\2\2uz\7 \2\2vz\7\37\2\2wz\t\4\2\2xz\7\34\2\2yr"+
		"\3\2\2\2ys\3\2\2\2yt\3\2\2\2yu\3\2\2\2yv\3\2\2\2yw\3\2\2\2yx\3\2\2\2z"+
		"\27\3\2\2\2{|\7\f\2\2|}\5\32\16\2}~\7\6\2\2~\177\7\35\2\2\177\u0080\7"+
		"\21\2\2\u0080\31\3\2\2\2\u0081\u0082\7\r\2\2\u0082\33\3\2\2\2\16)-\61"+
		"AIKPW`hoy";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}