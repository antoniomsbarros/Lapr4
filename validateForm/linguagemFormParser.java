// Generated from C:/lei20_21_s4_2dg_04/grammar\linguagemForm.g4 by ANTLR 4.9.1
package eapli.validateForm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class linguagemFormParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IF=2, STR_STATE=3, SIZE=4, BETWEEN=5, SIDE_BAR=6, AND=7, IS=8, 
		END=9, COLON=10, POINT=11, QUOTE_MARKS=12, VERIFICATION_OP=13, LOGIC_OP=14, 
		BOOLEAN_OP=15, EQUAL_OR_NOT=16, CONDITION_OP=17, OPTION_TYPE=18, MATH_OP=19, 
		OBLIGATION=20, STRING=21, INTEGER=22, DATA=23, YEAR=24, MONTH=25, DAY=26;
	public static final int
		RULE_start = 0, RULE_statement_verification = 1, RULE_statement_configuration = 2, 
		RULE_if_func = 3, RULE_content = 4, RULE_gap = 5, RULE_config = 6, RULE_ctntconditions = 7, 
		RULE_conditions = 8, RULE_condition = 9, RULE_stringCondition = 10, RULE_intExpression = 11, 
		RULE_stringValue = 12, RULE_stringWithQuoteMarks = 13, RULE_intValue = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "statement_verification", "statement_configuration", "if_func", 
			"content", "gap", "config", "ctntconditions", "conditions", "condition", 
			"stringCondition", "intExpression", "stringValue", "stringWithQuoteMarks", 
			"intValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'then'", "'if'", null, null, null, null, null, null, "';'", "':'", 
			"'.'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "IF", "STR_STATE", "SIZE", "BETWEEN", "SIDE_BAR", "AND", 
			"IS", "END", "COLON", "POINT", "QUOTE_MARKS", "VERIFICATION_OP", "LOGIC_OP", 
			"BOOLEAN_OP", "EQUAL_OR_NOT", "CONDITION_OP", "OPTION_TYPE", "MATH_OP", 
			"OBLIGATION", "STRING", "INTEGER", "DATA", "YEAR", "MONTH", "DAY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "linguagemForm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public linguagemFormParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public Statement_verificationContext statement_verification() {
			return getRuleContext(Statement_verificationContext.class,0);
		}
		public Statement_configurationContext statement_configuration() {
			return getRuleContext(Statement_configurationContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		return start(0);
	}

	private StartContext start(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StartContext _localctx = new StartContext(_ctx, _parentState);
		StartContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_start, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(35);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						_localctx = new StartContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_start);
						setState(31);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(32);
						statement_verification();
						}
						break;
					case 2:
						{
						_localctx = new StartContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_start);
						setState(33);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(34);
						statement_configuration();
						}
						break;
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class Statement_verificationContext extends ParserRuleContext {
		public If_funcContext if_func() {
			return getRuleContext(If_funcContext.class,0);
		}
		public Statement_verificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_verification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterStatement_verification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitStatement_verification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitStatement_verification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_verificationContext statement_verification() throws RecognitionException {
		Statement_verificationContext _localctx = new Statement_verificationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement_verification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			if_func();
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

	public static class Statement_configurationContext extends ParserRuleContext {
		public ConfigContext config() {
			return getRuleContext(ConfigContext.class,0);
		}
		public Statement_configurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_configuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterStatement_configuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitStatement_configuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitStatement_configuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_configurationContext statement_configuration() throws RecognitionException {
		Statement_configurationContext _localctx = new Statement_configurationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement_configuration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			config();
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

	public static class If_funcContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(linguagemFormParser.IF, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode END() { return getToken(linguagemFormParser.END, 0); }
		public If_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterIf_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitIf_func(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitIf_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_funcContext if_func() throws RecognitionException {
		If_funcContext _localctx = new If_funcContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(IF);
			setState(45);
			conditions(0);
			setState(46);
			match(T__0);
			setState(47);
			content(0);
			setState(48);
			match(END);
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

	public static class ContentContext extends ParserRuleContext {
		public CtntconditionsContext ctntconditions() {
			return getRuleContext(CtntconditionsContext.class,0);
		}
		public ConfigContext config() {
			return getRuleContext(ConfigContext.class,0);
		}
		public If_funcContext if_func() {
			return getRuleContext(If_funcContext.class,0);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		return content(0);
	}

	private ContentContext content(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ContentContext _localctx = new ContentContext(_ctx, _parentState);
		ContentContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_content, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(51);
				ctntconditions();
				}
				break;
			case 2:
				{
				setState(52);
				config();
				}
				break;
			case 3:
				{
				setState(53);
				if_func();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(62);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ContentContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_content);
						setState(56);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(57);
						ctntconditions();
						}
						break;
					case 2:
						{
						_localctx = new ContentContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_content);
						setState(58);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(59);
						config();
						}
						break;
					case 3:
						{
						_localctx = new ContentContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_content);
						setState(60);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(61);
						if_func();
						}
						break;
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class GapContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(linguagemFormParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(linguagemFormParser.INTEGER, i);
		}
		public TerminalNode AND() { return getToken(linguagemFormParser.AND, 0); }
		public GapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterGap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitGap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitGap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GapContext gap() throws RecognitionException {
		GapContext _localctx = new GapContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_gap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(INTEGER);
			setState(68);
			match(AND);
			setState(69);
			match(INTEGER);
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

	public static class ConfigContext extends ParserRuleContext {
		public ConfigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_config; }
	 
		public ConfigContext() { }
		public void copyFrom(ConfigContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValBetweenContext extends ConfigContext {
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public TerminalNode BETWEEN() { return getToken(linguagemFormParser.BETWEEN, 0); }
		public GapContext gap() {
			return getRuleContext(GapContext.class,0);
		}
		public TerminalNode END() { return getToken(linguagemFormParser.END, 0); }
		public ValBetweenContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValBetween(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValBetween(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValBetween(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValObligatoryContext extends ConfigContext {
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public TerminalNode IS() { return getToken(linguagemFormParser.IS, 0); }
		public TerminalNode OBLIGATION() { return getToken(linguagemFormParser.OBLIGATION, 0); }
		public TerminalNode END() { return getToken(linguagemFormParser.END, 0); }
		public ValObligatoryContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValObligatory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValObligatory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValObligatory(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValSizeContext extends ConfigContext {
		public List<TerminalNode> INTEGER() { return getTokens(linguagemFormParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(linguagemFormParser.INTEGER, i);
		}
		public TerminalNode SIZE() { return getToken(linguagemFormParser.SIZE, 0); }
		public TerminalNode END() { return getToken(linguagemFormParser.END, 0); }
		public ValSizeContext(ConfigContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigContext config() throws RecognitionException {
		ConfigContext _localctx = new ConfigContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_config);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ValSizeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(INTEGER);
				setState(72);
				match(SIZE);
				setState(73);
				match(INTEGER);
				setState(74);
				match(END);
				}
				break;
			case 2:
				_localctx = new ValBetweenContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(INTEGER);
				setState(76);
				match(BETWEEN);
				setState(77);
				gap();
				setState(78);
				match(END);
				}
				break;
			case 3:
				_localctx = new ValObligatoryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(INTEGER);
				setState(81);
				match(IS);
				setState(82);
				match(OBLIGATION);
				setState(83);
				match(END);
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

	public static class CtntconditionsContext extends ParserRuleContext {
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public TerminalNode END() { return getToken(linguagemFormParser.END, 0); }
		public CtntconditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctntconditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterCtntconditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitCtntconditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitCtntconditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtntconditionsContext ctntconditions() throws RecognitionException {
		CtntconditionsContext _localctx = new CtntconditionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ctntconditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			conditions(0);
			setState(87);
			match(END);
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

	public static class ConditionsContext extends ParserRuleContext {
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
	 
		public ConditionsContext() { }
		public void copyFrom(ConditionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionsNoOpContext extends ConditionsContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionsNoOpContext(ConditionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterConditionsNoOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitConditionsNoOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitConditionsNoOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionsOpContext extends ConditionsContext {
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public TerminalNode CONDITION_OP() { return getToken(linguagemFormParser.CONDITION_OP, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode END() { return getToken(linguagemFormParser.END, 0); }
		public ConditionsOpContext(ConditionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterConditionsOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitConditionsOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitConditionsOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionsContext conditions() throws RecognitionException {
		return conditions(0);
	}

	private ConditionsContext conditions(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionsContext _localctx = new ConditionsContext(_ctx, _parentState);
		ConditionsContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_conditions, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ConditionsNoOpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(90);
			condition();
			}
			_ctx.stop = _input.LT(-1);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionsOpContext(new ConditionsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_conditions);
					setState(92);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(93);
					match(CONDITION_OP);
					setState(94);
					condition();
					setState(95);
					match(END);
					}
					} 
				}
				setState(101);
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
	public static class ValEqualStringContext extends ConditionContext {
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public TerminalNode EQUAL_OR_NOT() { return getToken(linguagemFormParser.EQUAL_OR_NOT, 0); }
		public StringConditionContext stringCondition() {
			return getRuleContext(StringConditionContext.class,0);
		}
		public ValEqualStringContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValEqualString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValEqualString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValEqualString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueVerifyVerifyOrEqualOrNotContext extends ConditionContext {
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public IntExpressionContext intExpression() {
			return getRuleContext(IntExpressionContext.class,0);
		}
		public TerminalNode VERIFICATION_OP() { return getToken(linguagemFormParser.VERIFICATION_OP, 0); }
		public TerminalNode EQUAL_OR_NOT() { return getToken(linguagemFormParser.EQUAL_OR_NOT, 0); }
		public ValueVerifyVerifyOrEqualOrNotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValueVerifyVerifyOrEqualOrNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValueVerifyVerifyOrEqualOrNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValueVerifyVerifyOrEqualOrNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValIsBooleanContext extends ConditionContext {
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public TerminalNode EQUAL_OR_NOT() { return getToken(linguagemFormParser.EQUAL_OR_NOT, 0); }
		public TerminalNode BOOLEAN_OP() { return getToken(linguagemFormParser.BOOLEAN_OP, 0); }
		public ValIsBooleanContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValIsBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValIsBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValIsBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValStateContext extends ConditionContext {
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public TerminalNode COLON() { return getToken(linguagemFormParser.COLON, 0); }
		public TerminalNode STR_STATE() { return getToken(linguagemFormParser.STR_STATE, 0); }
		public ValStateContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterValState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitValState(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitValState(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanIsValContext extends ConditionContext {
		public TerminalNode BOOLEAN_OP() { return getToken(linguagemFormParser.BOOLEAN_OP, 0); }
		public TerminalNode EQUAL_OR_NOT() { return getToken(linguagemFormParser.EQUAL_OR_NOT, 0); }
		public TerminalNode INTEGER() { return getToken(linguagemFormParser.INTEGER, 0); }
		public BooleanIsValContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterBooleanIsVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitBooleanIsVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitBooleanIsVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ValueVerifyVerifyOrEqualOrNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(INTEGER);
				setState(103);
				_la = _input.LA(1);
				if ( !(_la==VERIFICATION_OP || _la==EQUAL_OR_NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(104);
				intExpression(0);
				}
				break;
			case 2:
				_localctx = new ValStateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(INTEGER);
				setState(106);
				match(COLON);
				setState(107);
				match(STR_STATE);
				}
				break;
			case 3:
				_localctx = new ValEqualStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(INTEGER);
				setState(109);
				match(EQUAL_OR_NOT);
				setState(110);
				stringCondition();
				}
				break;
			case 4:
				_localctx = new ValIsBooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				match(INTEGER);
				setState(112);
				match(EQUAL_OR_NOT);
				setState(113);
				match(BOOLEAN_OP);
				}
				break;
			case 5:
				_localctx = new BooleanIsValContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				match(BOOLEAN_OP);
				setState(115);
				match(EQUAL_OR_NOT);
				setState(116);
				match(INTEGER);
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

	public static class StringConditionContext extends ParserRuleContext {
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public StringWithQuoteMarksContext stringWithQuoteMarks() {
			return getRuleContext(StringWithQuoteMarksContext.class,0);
		}
		public StringConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterStringCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitStringCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitStringCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConditionContext stringCondition() throws RecognitionException {
		StringConditionContext _localctx = new StringConditionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stringCondition);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				stringValue();
				}
				break;
			case QUOTE_MARKS:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				stringWithQuoteMarks();
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

	public static class IntExpressionContext extends ParserRuleContext {
		public IntValueContext intValue() {
			return getRuleContext(IntValueContext.class,0);
		}
		public IntExpressionContext intExpression() {
			return getRuleContext(IntExpressionContext.class,0);
		}
		public TerminalNode MATH_OP() { return getToken(linguagemFormParser.MATH_OP, 0); }
		public IntExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterIntExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitIntExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitIntExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntExpressionContext intExpression() throws RecognitionException {
		return intExpression(0);
	}

	private IntExpressionContext intExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntExpressionContext _localctx = new IntExpressionContext(_ctx, _parentState);
		IntExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_intExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(124);
			intValue();
			}
			_ctx.stop = _input.LT(-1);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IntExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_intExpression);
					setState(126);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(127);
					match(MATH_OP);
					setState(128);
					intValue();
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class StringValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(linguagemFormParser.STRING, 0); }
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public StringValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringValueContext stringValue() throws RecognitionException {
		StringValueContext _localctx = new StringValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stringValue);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(STRING);
				setState(136);
				stringValue();
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

	public static class StringWithQuoteMarksContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE_MARKS() { return getTokens(linguagemFormParser.QUOTE_MARKS); }
		public TerminalNode QUOTE_MARKS(int i) {
			return getToken(linguagemFormParser.QUOTE_MARKS, i);
		}
		public StringValueContext stringValue() {
			return getRuleContext(StringValueContext.class,0);
		}
		public StringWithQuoteMarksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringWithQuoteMarks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterStringWithQuoteMarks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitStringWithQuoteMarks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitStringWithQuoteMarks(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringWithQuoteMarksContext stringWithQuoteMarks() throws RecognitionException {
		StringWithQuoteMarksContext _localctx = new StringWithQuoteMarksContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stringWithQuoteMarks);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(QUOTE_MARKS);
			setState(140);
			stringValue();
			setState(141);
			match(QUOTE_MARKS);
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

	public static class IntValueContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(linguagemFormParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(linguagemFormParser.INTEGER, i);
		}
		public TerminalNode POINT() { return getToken(linguagemFormParser.POINT, 0); }
		public IntValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).enterIntValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemFormListener ) ((linguagemFormListener)listener).exitIntValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemFormVisitor ) return ((linguagemFormVisitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntValueContext intValue() throws RecognitionException {
		IntValueContext _localctx = new IntValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_intValue);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(INTEGER);
				{
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==POINT) {
					{
					setState(144);
					match(POINT);
					}
				}

				}
				setState(147);
				match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(INTEGER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return start_sempred((StartContext)_localctx, predIndex);
		case 4:
			return content_sempred((ContentContext)_localctx, predIndex);
		case 8:
			return conditions_sempred((ConditionsContext)_localctx, predIndex);
		case 11:
			return intExpression_sempred((IntExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean start_sempred(StartContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean content_sempred(ContentContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean conditions_sempred(ConditionsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean intExpression_sempred(IntExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u009a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\5\69\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6A\n\6\f\6\16\6D\13\6"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\bW\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nd\n\n\f\n\16\n"+
		"g\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13x\n\13\3\f\3\f\5\f|\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0084"+
		"\n\r\f\r\16\r\u0087\13\r\3\16\3\16\3\16\5\16\u008c\n\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\5\20\u0094\n\20\3\20\3\20\5\20\u0098\n\20\3\20\2\6\2\n"+
		"\22\30\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\4\2\17\17\22\22\2"+
		"\u009d\2 \3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n8\3\2\2\2\fE\3\2\2"+
		"\2\16V\3\2\2\2\20X\3\2\2\2\22[\3\2\2\2\24w\3\2\2\2\26{\3\2\2\2\30}\3\2"+
		"\2\2\32\u008b\3\2\2\2\34\u008d\3\2\2\2\36\u0097\3\2\2\2 \'\b\2\1\2!\""+
		"\f\4\2\2\"&\5\4\3\2#$\f\3\2\2$&\5\6\4\2%!\3\2\2\2%#\3\2\2\2&)\3\2\2\2"+
		"\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)\'\3\2\2\2*+\5\b\5\2+\5\3\2\2\2,-\5"+
		"\16\b\2-\7\3\2\2\2./\7\4\2\2/\60\5\22\n\2\60\61\7\3\2\2\61\62\5\n\6\2"+
		"\62\63\7\13\2\2\63\t\3\2\2\2\64\65\b\6\1\2\659\5\20\t\2\669\5\16\b\2\67"+
		"9\5\b\5\28\64\3\2\2\28\66\3\2\2\28\67\3\2\2\29B\3\2\2\2:;\f\b\2\2;A\5"+
		"\20\t\2<=\f\7\2\2=A\5\16\b\2>?\f\6\2\2?A\5\b\5\2@:\3\2\2\2@<\3\2\2\2@"+
		">\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DB\3\2\2\2EF\7\30\2"+
		"\2FG\7\t\2\2GH\7\30\2\2H\r\3\2\2\2IJ\7\30\2\2JK\7\6\2\2KL\7\30\2\2LW\7"+
		"\13\2\2MN\7\30\2\2NO\7\7\2\2OP\5\f\7\2PQ\7\13\2\2QW\3\2\2\2RS\7\30\2\2"+
		"ST\7\n\2\2TU\7\26\2\2UW\7\13\2\2VI\3\2\2\2VM\3\2\2\2VR\3\2\2\2W\17\3\2"+
		"\2\2XY\5\22\n\2YZ\7\13\2\2Z\21\3\2\2\2[\\\b\n\1\2\\]\5\24\13\2]e\3\2\2"+
		"\2^_\f\3\2\2_`\7\23\2\2`a\5\24\13\2ab\7\13\2\2bd\3\2\2\2c^\3\2\2\2dg\3"+
		"\2\2\2ec\3\2\2\2ef\3\2\2\2f\23\3\2\2\2ge\3\2\2\2hi\7\30\2\2ij\t\2\2\2"+
		"jx\5\30\r\2kl\7\30\2\2lm\7\f\2\2mx\7\5\2\2no\7\30\2\2op\7\22\2\2px\5\26"+
		"\f\2qr\7\30\2\2rs\7\22\2\2sx\7\21\2\2tu\7\21\2\2uv\7\22\2\2vx\7\30\2\2"+
		"wh\3\2\2\2wk\3\2\2\2wn\3\2\2\2wq\3\2\2\2wt\3\2\2\2x\25\3\2\2\2y|\5\32"+
		"\16\2z|\5\34\17\2{y\3\2\2\2{z\3\2\2\2|\27\3\2\2\2}~\b\r\1\2~\177\5\36"+
		"\20\2\177\u0085\3\2\2\2\u0080\u0081\f\3\2\2\u0081\u0082\7\25\2\2\u0082"+
		"\u0084\5\36\20\2\u0083\u0080\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\31\3\2\2\2\u0087\u0085\3\2\2\2\u0088"+
		"\u008c\7\27\2\2\u0089\u008a\7\27\2\2\u008a\u008c\5\32\16\2\u008b\u0088"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008c\33\3\2\2\2\u008d\u008e\7\16\2\2\u008e"+
		"\u008f\5\32\16\2\u008f\u0090\7\16\2\2\u0090\35\3\2\2\2\u0091\u0093\7\30"+
		"\2\2\u0092\u0094\7\r\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0098\7\30\2\2\u0096\u0098\7\30\2\2\u0097\u0091\3"+
		"\2\2\2\u0097\u0096\3\2\2\2\u0098\37\3\2\2\2\17%\'8@BVew{\u0085\u008b\u0093"+
		"\u0097";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}