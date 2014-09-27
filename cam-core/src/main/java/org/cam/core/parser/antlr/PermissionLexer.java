// Generated from /home/yaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
package org.cam.core.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PermissionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		STAR=10, GT=11, GE=12, EQ=13, NE=14, LT=15, LE=16, LIKE=17, TRUE=18, FALSE=19, 
		ID=20, STRING=21, FLOAT=22, INT=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"STAR", "GT", "GE", "EQ", "NE", "LT", "LE", "LIKE", "TRUE", "FALSE", "ID", 
		"STRING", "FLOAT", "INT", "DIGIT", "ID_LETTER", "WS"
	};


	public PermissionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Permission.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\7\25u\n\25\f\25\16\25x\13\25\3\26\3\26\7\26|\n\26"+
		"\f\26\16\26\177\13\26\3\26\3\26\3\27\6\27\u0084\n\27\r\27\16\27\u0085"+
		"\3\27\3\27\7\27\u008a\n\27\f\27\16\27\u008d\13\27\3\27\3\27\6\27\u0091"+
		"\n\27\r\27\16\27\u0092\5\27\u0095\n\27\3\30\6\30\u0098\n\30\r\30\16\30"+
		"\u0099\3\31\3\31\3\32\3\32\3\33\6\33\u00a1\n\33\r\33\16\33\u00a2\3\33"+
		"\3\33\3}\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\32\3"+
		"\2\5\3\2\62;\5\2C\\aac|\3\2\"\"\u00ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5:\3"+
		"\2\2\2\7<\3\2\2\2\t>\3\2\2\2\13@\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3"+
		"\2\2\2\23L\3\2\2\2\25P\3\2\2\2\27R\3\2\2\2\31T\3\2\2\2\33W\3\2\2\2\35"+
		"Y\3\2\2\2\37\\\3\2\2\2!^\3\2\2\2#a\3\2\2\2%f\3\2\2\2\'k\3\2\2\2)q\3\2"+
		"\2\2+y\3\2\2\2-\u0094\3\2\2\2/\u0097\3\2\2\2\61\u009b\3\2\2\2\63\u009d"+
		"\3\2\2\2\65\u00a0\3\2\2\2\678\7k\2\289\7p\2\29\4\3\2\2\2:;\7\60\2\2;\6"+
		"\3\2\2\2<=\7+\2\2=\b\3\2\2\2>?\7.\2\2?\n\3\2\2\2@A\7q\2\2AB\7t\2\2B\f"+
		"\3\2\2\2CD\7*\2\2D\16\3\2\2\2EF\7<\2\2F\20\3\2\2\2GH\7p\2\2HI\7w\2\2I"+
		"J\7n\2\2JK\7n\2\2K\22\3\2\2\2LM\7c\2\2MN\7p\2\2NO\7f\2\2O\24\3\2\2\2P"+
		"Q\7,\2\2Q\26\3\2\2\2RS\7@\2\2S\30\3\2\2\2TU\7@\2\2UV\7?\2\2V\32\3\2\2"+
		"\2WX\7?\2\2X\34\3\2\2\2YZ\7#\2\2Z[\7?\2\2[\36\3\2\2\2\\]\7>\2\2] \3\2"+
		"\2\2^_\7>\2\2_`\7?\2\2`\"\3\2\2\2ab\7n\2\2bc\7k\2\2cd\7m\2\2de\7g\2\2"+
		"e$\3\2\2\2fg\7v\2\2gh\7t\2\2hi\7w\2\2ij\7g\2\2j&\3\2\2\2kl\7h\2\2lm\7"+
		"c\2\2mn\7n\2\2no\7u\2\2op\7g\2\2p(\3\2\2\2qv\5\63\32\2ru\5\63\32\2su\5"+
		"\61\31\2tr\3\2\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w*\3\2\2\2x"+
		"v\3\2\2\2y}\7)\2\2z|\13\2\2\2{z\3\2\2\2|\177\3\2\2\2}~\3\2\2\2}{\3\2\2"+
		"\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7)\2\2\u0081,\3\2\2\2\u0082"+
		"\u0084\5\61\31\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008b\7\60\2\2\u0088"+
		"\u008a\5\61\31\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u0095\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u0090\7\60\2\2\u008f\u0091\5\61\31\2\u0090\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0083\3\2\2\2\u0094\u008e\3\2\2\2\u0095.\3\2\2\2\u0096\u0098\5\61\31"+
		"\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\60\3\2\2\2\u009b\u009c\t\2\2\2\u009c\62\3\2\2\2\u009d\u009e"+
		"\t\3\2\2\u009e\64\3\2\2\2\u009f\u00a1\t\4\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a5\b\33\2\2\u00a5\66\3\2\2\2\f\2tv}\u0085\u008b\u0092\u0094"+
		"\u0099\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}