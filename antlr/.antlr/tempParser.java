// Generated from /home/booiris/work4/BIT-MiniCC-master/antlr/temp.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tempParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		ID=25, INT=26, STRING=27, CHAR=28;
	public static final int
		RULE_translationUnit = 0, RULE_externalDeclaration = 1, RULE_functionDeﬁnition = 2, 
		RULE_declaration = 3, RULE_init_declarator = 4, RULE_declarationSpecifiers = 5, 
		RULE_declarator = 6, RULE_parameter_type_list = 7, RULE_parameter_list = 8, 
		RULE_parameter_declaration = 9, RULE_compoundStatement = 10, RULE_block_item_list = 11, 
		RULE_block_item = 12, RULE_expressionStatament = 13, RULE_iterationStatement = 14, 
		RULE_jumpStatement = 15, RULE_selectionStatement = 16, RULE_statement = 17, 
		RULE_primaryExpression = 18, RULE_postfixExpression = 19, RULE_argument_expression_list = 20, 
		RULE_additiveExpression = 21, RULE_relationExpression = 22, RULE_assignmentExpression = 23, 
		RULE_assignmentOperator = 24, RULE_expression = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "externalDeclaration", "functionDeﬁnition", "declaration", 
			"init_declarator", "declarationSpecifiers", "declarator", "parameter_type_list", 
			"parameter_list", "parameter_declaration", "compoundStatement", "block_item_list", 
			"block_item", "expressionStatament", "iterationStatement", "jumpStatement", 
			"selectionStatement", "statement", "primaryExpression", "postfixExpression", 
			"argument_expression_list", "additiveExpression", "relationExpression", 
			"assignmentExpression", "assignmentOperator", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'int'", "'['", "']'", "'('", "')'", "','", "'...'", 
			"'{'", "'}'", "'for'", "'continue'", "'break'", "'return'", "'if'", "'else'", 
			"'++'", "'+'", "'-'", "'<'", "'<='", "'>'", "'>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "INT", "STRING", "CHAR"
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
	public String getGrammarFileName() { return "temp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tempParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationUnitContext extends ParserRuleContext {
		public ExternalDeclarationContext externalDeclaration() {
			return getRuleContext(ExternalDeclarationContext.class,0);
		}
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		return translationUnit(0);
	}

	private TranslationUnitContext translationUnit(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, _parentState);
		TranslationUnitContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_translationUnit, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(53);
			externalDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TranslationUnitContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_translationUnit);
					setState(55);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(56);
					externalDeclaration();
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class ExternalDeclarationContext extends ParserRuleContext {
		public FunctionDeﬁnitionContext functionDeﬁnition() {
			return getRuleContext(FunctionDeﬁnitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_externalDeclaration);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				functionDeﬁnition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				declaration();
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

	public static class FunctionDeﬁnitionContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public FunctionDeﬁnitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeﬁnition; }
	}

	public final FunctionDeﬁnitionContext functionDeﬁnition() throws RecognitionException {
		FunctionDeﬁnitionContext _localctx = new FunctionDeﬁnitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeﬁnition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			declarationSpecifiers();
			setState(67);
			declarator(0);
			setState(68);
			compoundStatement();
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public Init_declaratorContext init_declarator() {
			return getRuleContext(Init_declaratorContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			declarationSpecifiers();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(71);
				init_declarator();
				}
			}

			setState(74);
			match(T__0);
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

	public static class Init_declaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public Init_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator; }
	}

	public final Init_declaratorContext init_declarator() throws RecognitionException {
		Init_declaratorContext _localctx = new Init_declaratorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_init_declarator);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				declarator(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				declarator(0);
				setState(78);
				match(T__1);
				setState(79);
				assignmentExpression();
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

	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declarationSpecifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__2);
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

	public static class DeclaratorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tempParser.ID, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public Parameter_type_listContext parameter_type_list() {
			return getRuleContext(Parameter_type_listContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		return declarator(0);
	}

	private DeclaratorContext declarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, _parentState);
		DeclaratorContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_declarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(86);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new DeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_declarator);
						setState(88);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(89);
						match(T__3);
						setState(91);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
							{
							setState(90);
							assignmentExpression();
							}
						}

						setState(93);
						match(T__4);
						}
						break;
					case 2:
						{
						_localctx = new DeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_declarator);
						setState(94);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(95);
						match(T__5);
						setState(97);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__2) {
							{
							setState(96);
							parameter_type_list();
							}
						}

						setState(99);
						match(T__6);
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class Parameter_type_listContext extends ParserRuleContext {
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Parameter_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_type_list; }
	}

	public final Parameter_type_listContext parameter_type_list() throws RecognitionException {
		Parameter_type_listContext _localctx = new Parameter_type_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter_type_list);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				parameter_list(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				parameter_list(0);
				setState(107);
				match(T__7);
				setState(108);
				match(T__8);
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

	public static class Parameter_listContext extends ParserRuleContext {
		public Parameter_declarationContext parameter_declaration() {
			return getRuleContext(Parameter_declarationContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(113);
			parameter_declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Parameter_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
					setState(115);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(116);
					match(T__7);
					setState(117);
					parameter_declaration();
					}
					} 
				}
				setState(122);
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

	public static class Parameter_declarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Parameter_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration; }
	}

	public final Parameter_declarationContext parameter_declaration() throws RecognitionException {
		Parameter_declarationContext _localctx = new Parameter_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			declarationSpecifiers();
			setState(124);
			declarator(0);
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

	public static class CompoundStatementContext extends ParserRuleContext {
		public Block_item_listContext block_item_list() {
			return getRuleContext(Block_item_listContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__9);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
				{
				setState(127);
				block_item_list(0);
				}
			}

			setState(130);
			match(T__10);
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

	public static class Block_item_listContext extends ParserRuleContext {
		public Block_itemContext block_item() {
			return getRuleContext(Block_itemContext.class,0);
		}
		public Block_item_listContext block_item_list() {
			return getRuleContext(Block_item_listContext.class,0);
		}
		public Block_item_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_item_list; }
	}

	public final Block_item_listContext block_item_list() throws RecognitionException {
		return block_item_list(0);
	}

	private Block_item_listContext block_item_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Block_item_listContext _localctx = new Block_item_listContext(_ctx, _parentState);
		Block_item_listContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_block_item_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(133);
			block_item();
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Block_item_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_block_item_list);
					setState(135);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(136);
					block_item();
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Block_itemContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Block_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_item; }
	}

	public final Block_itemContext block_item() throws RecognitionException {
		Block_itemContext _localctx = new Block_itemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block_item);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				declaration();
				}
				break;
			case T__5:
			case T__9:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case ID:
			case INT:
			case STRING:
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				statement();
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

	public static class ExpressionStatamentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatamentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatament; }
	}

	public final ExpressionStatamentContext expressionStatament() throws RecognitionException {
		ExpressionStatamentContext _localctx = new ExpressionStatamentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionStatament);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			expression(0);
			setState(147);
			match(T__0);
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

	public static class IterationStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_iterationStatement);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(T__11);
				setState(150);
				match(T__5);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(151);
					expression(0);
					}
				}

				setState(154);
				match(T__0);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(155);
					expression(0);
					}
				}

				setState(158);
				match(T__0);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(159);
					expression(0);
					}
				}

				setState(162);
				match(T__6);
				setState(163);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(T__11);
				setState(165);
				match(T__5);
				setState(166);
				declaration();
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(167);
					expression(0);
					}
				}

				setState(170);
				match(T__0);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
					{
					setState(171);
					expression(0);
					}
				}

				setState(174);
				match(T__6);
				setState(175);
				statement();
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

	public static class JumpStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jumpStatement);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__12);
				setState(180);
				match(T__0);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(T__13);
				setState(182);
				match(T__0);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(T__14);
				setState(185);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(184);
					expression(0);
					}
					break;
				}
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

	public static class SelectionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__15);
			setState(190);
			match(T__5);
			setState(191);
			expression(0);
			setState(192);
			match(T__6);
			setState(193);
			statement();
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(194);
				match(T__16);
				setState(195);
				statement();
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatamentContext expressionStatament() {
			return getRuleContext(ExpressionStatamentContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				selectionStatement();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				compoundStatement();
				}
				break;
			case T__5:
			case ID:
			case INT:
			case STRING:
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				expressionStatament();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				iterationStatement();
				}
				break;
			case T__12:
			case T__13:
			case T__14:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				jumpStatement();
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tempParser.ID, 0); }
		public TerminalNode INT() { return getToken(tempParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(tempParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(tempParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_primaryExpression);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(INT);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(CHAR);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				match(STRING);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				match(T__5);
				setState(210);
				expression(0);
				setState(211);
				match(T__6);
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

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Argument_expression_listContext argument_expression_list() {
			return getRuleContext(Argument_expression_listContext.class,0);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(216);
			primaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(218);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(219);
						match(T__3);
						setState(220);
						expression(0);
						setState(221);
						match(T__4);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(223);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(224);
						match(T__5);
						setState(226);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << ID) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) {
							{
							setState(225);
							argument_expression_list(0);
							}
						}

						setState(228);
						match(T__6);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(229);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(230);
						match(T__17);
						}
						break;
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class Argument_expression_listContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public Argument_expression_listContext argument_expression_list() {
			return getRuleContext(Argument_expression_listContext.class,0);
		}
		public Argument_expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_expression_list; }
	}

	public final Argument_expression_listContext argument_expression_list() throws RecognitionException {
		return argument_expression_list(0);
	}

	private Argument_expression_listContext argument_expression_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Argument_expression_listContext _localctx = new Argument_expression_listContext(_ctx, _parentState);
		Argument_expression_listContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_argument_expression_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(237);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Argument_expression_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argument_expression_list);
					setState(239);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(240);
					match(T__7);
					setState(241);
					assignmentExpression();
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(248);
			postfixExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(250);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(251);
						match(T__18);
						setState(252);
						postfixExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(253);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(254);
						match(T__19);
						setState(255);
						postfixExpression(0);
						}
						break;
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class RelationExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public RelationExpressionContext relationExpression() {
			return getRuleContext(RelationExpressionContext.class,0);
		}
		public RelationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationExpression; }
	}

	public final RelationExpressionContext relationExpression() throws RecognitionException {
		return relationExpression(0);
	}

	private RelationExpressionContext relationExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationExpressionContext _localctx = new RelationExpressionContext(_ctx, _parentState);
		RelationExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_relationExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(276);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new RelationExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpression);
						setState(264);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(265);
						match(T__20);
						setState(266);
						additiveExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpression);
						setState(267);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(268);
						match(T__21);
						setState(269);
						additiveExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpression);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						match(T__22);
						setState(272);
						additiveExpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationExpression);
						setState(273);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(274);
						match(T__23);
						setState(275);
						additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public RelationExpressionContext relationExpression() {
			return getRuleContext(RelationExpressionContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assignmentExpression);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				relationExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				postfixExpression(0);
				setState(283);
				assignmentOperator();
				setState(284);
				assignmentExpression();
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(291);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(293);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(294);
					match(T__7);
					setState(295);
					assignmentExpression();
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return translationUnit_sempred((TranslationUnitContext)_localctx, predIndex);
		case 6:
			return declarator_sempred((DeclaratorContext)_localctx, predIndex);
		case 8:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 11:
			return block_item_list_sempred((Block_item_listContext)_localctx, predIndex);
		case 19:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 20:
			return argument_expression_list_sempred((Argument_expression_listContext)_localctx, predIndex);
		case 21:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 22:
			return relationExpression_sempred((RelationExpressionContext)_localctx, predIndex);
		case 25:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean translationUnit_sempred(TranslationUnitContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean declarator_sempred(DeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean block_item_list_sempred(Block_item_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argument_expression_list_sempred(Argument_expression_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationExpression_sempred(RelationExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u0130\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\3\3"+
		"\3\5\3C\n\3\3\4\3\4\3\4\3\4\3\5\3\5\5\5K\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\5\6T\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b^\n\b\3\b\3\b\3\b\3\b\5"+
		"\bd\n\b\3\b\7\bg\n\b\f\b\16\bj\13\b\3\t\3\t\3\t\3\t\3\t\5\tq\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\13\3\13\3\13\3\f\3\f\5\f"+
		"\u0083\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u008c\n\r\f\r\16\r\u008f\13"+
		"\r\3\16\3\16\5\16\u0093\n\16\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u009b"+
		"\n\20\3\20\3\20\5\20\u009f\n\20\3\20\3\20\5\20\u00a3\n\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00ab\n\20\3\20\3\20\5\20\u00af\n\20\3\20\3\20"+
		"\3\20\5\20\u00b4\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00bc\n\21\5"+
		"\21\u00be\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00c7\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00ce\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00d8\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u00e5\n\25\3\25\3\25\3\25\7\25\u00ea\n\25\f\25\16\25\u00ed"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00f5\n\26\f\26\16\26\u00f8"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0103\n\27\f"+
		"\27\16\27\u0106\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u0117\n\30\f\30\16\30\u011a\13\30\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0121\n\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u012b\n\33\f\33\16\33\u012e\13\33\3\33\2\13\2\16\22\30(*,."+
		"\64\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\2\2"+
		"\u0141\2\66\3\2\2\2\4B\3\2\2\2\6D\3\2\2\2\bH\3\2\2\2\nS\3\2\2\2\fU\3\2"+
		"\2\2\16W\3\2\2\2\20p\3\2\2\2\22r\3\2\2\2\24}\3\2\2\2\26\u0080\3\2\2\2"+
		"\30\u0086\3\2\2\2\32\u0092\3\2\2\2\34\u0094\3\2\2\2\36\u00b3\3\2\2\2 "+
		"\u00bd\3\2\2\2\"\u00bf\3\2\2\2$\u00cd\3\2\2\2&\u00d7\3\2\2\2(\u00d9\3"+
		"\2\2\2*\u00ee\3\2\2\2,\u00f9\3\2\2\2.\u0107\3\2\2\2\60\u0120\3\2\2\2\62"+
		"\u0122\3\2\2\2\64\u0124\3\2\2\2\66\67\b\2\1\2\678\5\4\3\28=\3\2\2\29:"+
		"\f\3\2\2:<\5\4\3\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\3\3\2\2\2"+
		"?=\3\2\2\2@C\5\6\4\2AC\5\b\5\2B@\3\2\2\2BA\3\2\2\2C\5\3\2\2\2DE\5\f\7"+
		"\2EF\5\16\b\2FG\5\26\f\2G\7\3\2\2\2HJ\5\f\7\2IK\5\n\6\2JI\3\2\2\2JK\3"+
		"\2\2\2KL\3\2\2\2LM\7\3\2\2M\t\3\2\2\2NT\5\16\b\2OP\5\16\b\2PQ\7\4\2\2"+
		"QR\5\60\31\2RT\3\2\2\2SN\3\2\2\2SO\3\2\2\2T\13\3\2\2\2UV\7\5\2\2V\r\3"+
		"\2\2\2WX\b\b\1\2XY\7\33\2\2Yh\3\2\2\2Z[\f\4\2\2[]\7\6\2\2\\^\5\60\31\2"+
		"]\\\3\2\2\2]^\3\2\2\2^_\3\2\2\2_g\7\7\2\2`a\f\3\2\2ac\7\b\2\2bd\5\20\t"+
		"\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\7\t\2\2fZ\3\2\2\2f`\3\2\2\2gj\3\2\2"+
		"\2hf\3\2\2\2hi\3\2\2\2i\17\3\2\2\2jh\3\2\2\2kq\5\22\n\2lm\5\22\n\2mn\7"+
		"\n\2\2no\7\13\2\2oq\3\2\2\2pk\3\2\2\2pl\3\2\2\2q\21\3\2\2\2rs\b\n\1\2"+
		"st\5\24\13\2tz\3\2\2\2uv\f\3\2\2vw\7\n\2\2wy\5\24\13\2xu\3\2\2\2y|\3\2"+
		"\2\2zx\3\2\2\2z{\3\2\2\2{\23\3\2\2\2|z\3\2\2\2}~\5\f\7\2~\177\5\16\b\2"+
		"\177\25\3\2\2\2\u0080\u0082\7\f\2\2\u0081\u0083\5\30\r\2\u0082\u0081\3"+
		"\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\r\2\2\u0085"+
		"\27\3\2\2\2\u0086\u0087\b\r\1\2\u0087\u0088\5\32\16\2\u0088\u008d\3\2"+
		"\2\2\u0089\u008a\f\3\2\2\u008a\u008c\5\32\16\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\31\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u0090\u0093\5\b\5\2\u0091\u0093\5$\23\2\u0092\u0090"+
		"\3\2\2\2\u0092\u0091\3\2\2\2\u0093\33\3\2\2\2\u0094\u0095\5\64\33\2\u0095"+
		"\u0096\7\3\2\2\u0096\35\3\2\2\2\u0097\u0098\7\16\2\2\u0098\u009a\7\b\2"+
		"\2\u0099\u009b\5\64\33\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009e\7\3\2\2\u009d\u009f\5\64\33\2\u009e\u009d\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\7\3\2\2\u00a1"+
		"\u00a3\5\64\33\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3"+
		"\2\2\2\u00a4\u00a5\7\t\2\2\u00a5\u00b4\5$\23\2\u00a6\u00a7\7\16\2\2\u00a7"+
		"\u00a8\7\b\2\2\u00a8\u00aa\5\b\5\2\u00a9\u00ab\5\64\33\2\u00aa\u00a9\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\7\3\2\2\u00ad"+
		"\u00af\5\64\33\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00b1\7\t\2\2\u00b1\u00b2\5$\23\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u0097\3\2\2\2\u00b3\u00a6\3\2\2\2\u00b4\37\3\2\2\2\u00b5\u00b6\7\17\2"+
		"\2\u00b6\u00be\7\3\2\2\u00b7\u00b8\7\20\2\2\u00b8\u00be\7\3\2\2\u00b9"+
		"\u00bb\7\21\2\2\u00ba\u00bc\5\64\33\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd"+
		"\u00b9\3\2\2\2\u00be!\3\2\2\2\u00bf\u00c0\7\22\2\2\u00c0\u00c1\7\b\2\2"+
		"\u00c1\u00c2\5\64\33\2\u00c2\u00c3\7\t\2\2\u00c3\u00c6\5$\23\2\u00c4\u00c5"+
		"\7\23\2\2\u00c5\u00c7\5$\23\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2"+
		"\u00c7#\3\2\2\2\u00c8\u00ce\5\"\22\2\u00c9\u00ce\5\26\f\2\u00ca\u00ce"+
		"\5\34\17\2\u00cb\u00ce\5\36\20\2\u00cc\u00ce\5 \21\2\u00cd\u00c8\3\2\2"+
		"\2\u00cd\u00c9\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc"+
		"\3\2\2\2\u00ce%\3\2\2\2\u00cf\u00d8\7\33\2\2\u00d0\u00d8\7\34\2\2\u00d1"+
		"\u00d8\7\36\2\2\u00d2\u00d8\7\35\2\2\u00d3\u00d4\7\b\2\2\u00d4\u00d5\5"+
		"\64\33\2\u00d5\u00d6\7\t\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7"+
		"\u00d0\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7\u00d2\3\2\2\2\u00d7\u00d3\3\2"+
		"\2\2\u00d8\'\3\2\2\2\u00d9\u00da\b\25\1\2\u00da\u00db\5&\24\2\u00db\u00eb"+
		"\3\2\2\2\u00dc\u00dd\f\5\2\2\u00dd\u00de\7\6\2\2\u00de\u00df\5\64\33\2"+
		"\u00df\u00e0\7\7\2\2\u00e0\u00ea\3\2\2\2\u00e1\u00e2\f\4\2\2\u00e2\u00e4"+
		"\7\b\2\2\u00e3\u00e5\5*\26\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00ea\7\t\2\2\u00e7\u00e8\f\3\2\2\u00e8\u00ea\7\24"+
		"\2\2\u00e9\u00dc\3\2\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec)\3\2\2\2"+
		"\u00ed\u00eb\3\2\2\2\u00ee\u00ef\b\26\1\2\u00ef\u00f0\5\60\31\2\u00f0"+
		"\u00f6\3\2\2\2\u00f1\u00f2\f\3\2\2\u00f2\u00f3\7\n\2\2\u00f3\u00f5\5\60"+
		"\31\2\u00f4\u00f1\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7+\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\b\27\1\2"+
		"\u00fa\u00fb\5(\25\2\u00fb\u0104\3\2\2\2\u00fc\u00fd\f\4\2\2\u00fd\u00fe"+
		"\7\25\2\2\u00fe\u0103\5(\25\2\u00ff\u0100\f\3\2\2\u0100\u0101\7\26\2\2"+
		"\u0101\u0103\5(\25\2\u0102\u00fc\3\2\2\2\u0102\u00ff\3\2\2\2\u0103\u0106"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105-\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0108\b\30\1\2\u0108\u0109\5,\27\2\u0109\u0118\3"+
		"\2\2\2\u010a\u010b\f\6\2\2\u010b\u010c\7\27\2\2\u010c\u0117\5,\27\2\u010d"+
		"\u010e\f\5\2\2\u010e\u010f\7\30\2\2\u010f\u0117\5,\27\2\u0110\u0111\f"+
		"\4\2\2\u0111\u0112\7\31\2\2\u0112\u0117\5,\27\2\u0113\u0114\f\3\2\2\u0114"+
		"\u0115\7\32\2\2\u0115\u0117\5,\27\2\u0116\u010a\3\2\2\2\u0116\u010d\3"+
		"\2\2\2\u0116\u0110\3\2\2\2\u0116\u0113\3\2\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119/\3\2\2\2\u011a\u0118\3\2\2\2"+
		"\u011b\u0121\5.\30\2\u011c\u011d\5(\25\2\u011d\u011e\5\62\32\2\u011e\u011f"+
		"\5\60\31\2\u011f\u0121\3\2\2\2\u0120\u011b\3\2\2\2\u0120\u011c\3\2\2\2"+
		"\u0121\61\3\2\2\2\u0122\u0123\7\4\2\2\u0123\63\3\2\2\2\u0124\u0125\b\33"+
		"\1\2\u0125\u0126\5\60\31\2\u0126\u012c\3\2\2\2\u0127\u0128\f\3\2\2\u0128"+
		"\u0129\7\n\2\2\u0129\u012b\5\60\31\2\u012a\u0127\3\2\2\2\u012b\u012e\3"+
		"\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\65\3\2\2\2\u012e"+
		"\u012c\3\2\2\2$=BJS]cfhpz\u0082\u008d\u0092\u009a\u009e\u00a2\u00aa\u00ae"+
		"\u00b3\u00bb\u00bd\u00c6\u00cd\u00d7\u00e4\u00e9\u00eb\u00f6\u0102\u0104"+
		"\u0116\u0118\u0120\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}