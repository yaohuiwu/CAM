// Generated from /home/wuyaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, STAR=15, GT=16, GE=17, EQ=18, 
		NE=19, LT=20, LE=21, LIKE=22, TRUE=23, FALSE=24, ID=25, STRING=26, FLOAT=27, 
		INT=28, WS=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'from'", "'select'", "'.'", "'in'", "')'", "','", "'or'", 
		"':'", "'('", "'as'", "'null'", "'and'", "'where'", "'$'", "'*'", "'>'", 
		"'>='", "'='", "'!='", "'<'", "'<='", "'like'", "'true'", "'false'", "ID", 
		"STRING", "FLOAT", "INT", "WS"
	};
	public static final int
		RULE_permission = 0, RULE_action = 1, RULE_objectType = 2, RULE_criteria = 3, 
		RULE_query = 4, RULE_idAlias = 5, RULE_condition = 6, RULE_list = 7, RULE_value = 8, 
		RULE_scalarVar = 9;
	public static final String[] ruleNames = {
		"permission", "action", "objectType", "criteria", "query", "idAlias", 
		"condition", "list", "value", "scalarVar"
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
			setState(20); action();
			setState(21); match(T__6);
			setState(22); objectType();
			setState(23); match(T__6);
			setState(24); criteria();
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
			setState(26);
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
			setState(37);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(28); match(ID);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(29); match(T__11);
					setState(30); match(ID);
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(36); match(STAR);
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
			setState(41);
			switch (_input.LA(1)) {
			case T__5:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); condition(0);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); match(STAR);
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

	public static class QueryContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<IdAliasContext> idAlias() {
			return getRuleContexts(IdAliasContext.class);
		}
		public IdAliasContext idAlias(int i) {
			return getRuleContext(IdAliasContext.class,i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(T__12);
			setState(44); idAlias();
			setState(45); match(T__13);
			setState(46); idAlias();
			setState(47); match(T__1);
			setState(48); condition(0);
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
		enterRule(_localctx, 10, RULE_idAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); match(ID);
			setState(53);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(51); match(T__4);
				setState(52); match(ID);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new CompExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56); match(ID);
				setState(57);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << EQ) | (1L << NE) | (1L << LT) | (1L << LE) | (1L << LIKE))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(58); value();
				}
				break;
			case 2:
				{
				_localctx = new InExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59); match(ID);
				setState(60); match(T__10);
				setState(61); match(T__5);
				setState(62); list();
				setState(63); match(T__9);
				}
				break;
			case 3:
				{
				_localctx = new ParentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); match(T__5);
				setState(66); condition(0);
				setState(67); match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(77);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AndExprContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(71);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(72); match(T__2);
						setState(73); condition(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExprContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(74);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(75); match(T__7);
						setState(76); condition(3);
						}
						break;
					}
					} 
				}
				setState(81);
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

	public static class ListContext extends ParserRuleContext {
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
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
		enterRule(_localctx, 14, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); value();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(83); match(T__8);
				setState(84); value();
				}
				}
				setState(89);
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
		public TerminalNode STRING() { return getToken(PermissionParser.STRING, 0); }
		public ScalarVarContext scalarVar() {
			return getRuleContext(ScalarVarContext.class,0);
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
		enterRule(_localctx, 16, RULE_value);
		int _la;
		try {
			setState(97);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(90); match(ID);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); scalarVar();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(92); match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(93); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(94); match(FLOAT);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				((ValueContext)_localctx).boo = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
					((ValueContext)_localctx).boo = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 7);
				{
				setState(96); match(T__3);
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

	public static class ScalarVarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PermissionParser.ID, 0); }
		public ScalarVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).enterScalarVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PermissionListener ) ((PermissionListener)listener).exitScalarVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PermissionVisitor ) return ((PermissionVisitor<? extends T>)visitor).visitScalarVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarVarContext scalarVar() throws RecognitionException {
		ScalarVarContext _localctx = new ScalarVarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_scalarVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(T__0);
			setState(100); match(ID);
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
		case 6: return condition_sempred((ConditionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37i\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4\"\n\4\f\4\16\4%\13\4\3"+
		"\4\5\4(\n\4\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5"+
		"\78\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bH\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bP\n\b\f\b\16\bS\13\b\3\t\3\t\3\t\7\tX\n"+
		"\t\f\t\16\t[\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nd\n\n\3\13\3\13\3\13"+
		"\3\13\2\3\16\f\2\4\6\b\n\f\16\20\22\24\2\5\4\2\21\21\33\33\3\2\22\30\3"+
		"\2\31\32m\2\26\3\2\2\2\4\34\3\2\2\2\6\'\3\2\2\2\b+\3\2\2\2\n-\3\2\2\2"+
		"\f\64\3\2\2\2\16G\3\2\2\2\20T\3\2\2\2\22c\3\2\2\2\24e\3\2\2\2\26\27\5"+
		"\4\3\2\27\30\7\n\2\2\30\31\5\6\4\2\31\32\7\n\2\2\32\33\5\b\5\2\33\3\3"+
		"\2\2\2\34\35\t\2\2\2\35\5\3\2\2\2\36#\7\33\2\2\37 \7\5\2\2 \"\7\33\2\2"+
		"!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$(\3\2\2\2%#\3\2\2\2&(\7\21"+
		"\2\2\'\36\3\2\2\2\'&\3\2\2\2(\7\3\2\2\2),\5\16\b\2*,\7\21\2\2+)\3\2\2"+
		"\2+*\3\2\2\2,\t\3\2\2\2-.\7\4\2\2./\5\f\7\2/\60\7\3\2\2\60\61\5\f\7\2"+
		"\61\62\7\17\2\2\62\63\5\16\b\2\63\13\3\2\2\2\64\67\7\33\2\2\65\66\7\f"+
		"\2\2\668\7\33\2\2\67\65\3\2\2\2\678\3\2\2\28\r\3\2\2\29:\b\b\1\2:;\7\33"+
		"\2\2;<\t\3\2\2<H\5\22\n\2=>\7\33\2\2>?\7\6\2\2?@\7\13\2\2@A\5\20\t\2A"+
		"B\7\7\2\2BH\3\2\2\2CD\7\13\2\2DE\5\16\b\2EF\7\7\2\2FH\3\2\2\2G9\3\2\2"+
		"\2G=\3\2\2\2GC\3\2\2\2HQ\3\2\2\2IJ\f\5\2\2JK\7\16\2\2KP\5\16\b\6LM\f\4"+
		"\2\2MN\7\t\2\2NP\5\16\b\5OI\3\2\2\2OL\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3"+
		"\2\2\2R\17\3\2\2\2SQ\3\2\2\2TY\5\22\n\2UV\7\b\2\2VX\5\22\n\2WU\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\21\3\2\2\2[Y\3\2\2\2\\d\7\33\2\2]d\5\24"+
		"\13\2^d\7\34\2\2_d\7\36\2\2`d\7\35\2\2ad\t\4\2\2bd\7\r\2\2c\\\3\2\2\2"+
		"c]\3\2\2\2c^\3\2\2\2c_\3\2\2\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\23\3\2\2"+
		"\2ef\7\20\2\2fg\7\33\2\2g\25\3\2\2\2\13#\'+\67GOQYc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}