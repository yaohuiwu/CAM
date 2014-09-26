// Generated from /home/wuyaohui/code/github/learning-java/project/antlr/permission-parser-01/src/main/antlr4/Permission.g4 by ANTLR 4.4.1-dev
package org.cam.core.parser.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PermissionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		GT=10, GE=11, EQ=12, NE=13, LT=14, LE=15, LIKE=16, TRUE=17, FALSE=18, 
		ID=19, STRING=20, FLOAT=21, INT=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"GT", "GE", "EQ", "NE", "LT", "LE", "LIKE", "TRUE", "FALSE", "ID", "STRING", 
		"FLOAT", "INT", "DIGIT", "ID_LETTER", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\7\24q\n\24\f\24\16\24t\13\24\3\25\3\25\7\25x\n\25\f\25\16\25{\13\25\3"+
		"\25\3\25\3\26\6\26\u0080\n\26\r\26\16\26\u0081\3\26\3\26\7\26\u0086\n"+
		"\26\f\26\16\26\u0089\13\26\3\26\3\26\6\26\u008d\n\26\r\26\16\26\u008e"+
		"\5\26\u0091\n\26\3\27\6\27\u0094\n\27\r\27\16\27\u0095\3\30\3\30\3\31"+
		"\3\31\3\32\6\32\u009d\n\32\r\32\16\32\u009e\3\32\3\32\3y\2\33\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\2\61\2\63\31\3\2\5\3\2\62;\5\2C\\aac|\3\2\""+
		"\"\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2\63\3\2\2\2\3\65\3\2\2\2\58\3\2\2\2\7:\3\2\2\2\t<\3\2\2\2\13>\3\2\2"+
		"\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23J\3\2\2\2\25N\3\2\2\2\27P\3\2"+
		"\2\2\31S\3\2\2\2\33U\3\2\2\2\35X\3\2\2\2\37Z\3\2\2\2!]\3\2\2\2#b\3\2\2"+
		"\2%g\3\2\2\2\'m\3\2\2\2)u\3\2\2\2+\u0090\3\2\2\2-\u0093\3\2\2\2/\u0097"+
		"\3\2\2\2\61\u0099\3\2\2\2\63\u009c\3\2\2\2\65\66\7k\2\2\66\67\7p\2\2\67"+
		"\4\3\2\2\289\7\60\2\29\6\3\2\2\2:;\7+\2\2;\b\3\2\2\2<=\7.\2\2=\n\3\2\2"+
		"\2>?\7q\2\2?@\7t\2\2@\f\3\2\2\2AB\7*\2\2B\16\3\2\2\2CD\7<\2\2D\20\3\2"+
		"\2\2EF\7p\2\2FG\7w\2\2GH\7n\2\2HI\7n\2\2I\22\3\2\2\2JK\7c\2\2KL\7p\2\2"+
		"LM\7f\2\2M\24\3\2\2\2NO\7@\2\2O\26\3\2\2\2PQ\7@\2\2QR\7?\2\2R\30\3\2\2"+
		"\2ST\7?\2\2T\32\3\2\2\2UV\7#\2\2VW\7?\2\2W\34\3\2\2\2XY\7>\2\2Y\36\3\2"+
		"\2\2Z[\7>\2\2[\\\7?\2\2\\ \3\2\2\2]^\7n\2\2^_\7k\2\2_`\7m\2\2`a\7g\2\2"+
		"a\"\3\2\2\2bc\7v\2\2cd\7t\2\2de\7w\2\2ef\7g\2\2f$\3\2\2\2gh\7h\2\2hi\7"+
		"c\2\2ij\7n\2\2jk\7u\2\2kl\7g\2\2l&\3\2\2\2mr\5\61\31\2nq\5\61\31\2oq\5"+
		"/\30\2pn\3\2\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s(\3\2\2\2tr\3"+
		"\2\2\2uy\7)\2\2vx\13\2\2\2wv\3\2\2\2x{\3\2\2\2yz\3\2\2\2yw\3\2\2\2z|\3"+
		"\2\2\2{y\3\2\2\2|}\7)\2\2}*\3\2\2\2~\u0080\5/\30\2\177~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0087\7\60\2\2\u0084\u0086\5/\30\2\u0085\u0084\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0091\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008c\7\60\2\2\u008b\u008d\5/\30\2\u008c"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0091\3\2\2\2\u0090\177\3\2\2\2\u0090\u008a\3\2\2\2\u0091,"+
		"\3\2\2\2\u0092\u0094\5/\30\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096.\3\2\2\2\u0097\u0098\t\2\2\2"+
		"\u0098\60\3\2\2\2\u0099\u009a\t\3\2\2\u009a\62\3\2\2\2\u009b\u009d\t\4"+
		"\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\32\2\2\u00a1\64\3\2\2"+
		"\2\f\2pry\u0081\u0087\u008e\u0090\u0095\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}