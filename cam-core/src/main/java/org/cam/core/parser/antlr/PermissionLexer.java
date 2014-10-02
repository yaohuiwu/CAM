// Generated from /home/wuyaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, STAR=16, GT=17, 
		GE=18, EQ=19, NE=20, LT=21, LE=22, LIKE=23, TRUE=24, FALSE=25, NULL=26, 
		ID=27, STRING=28, FLOAT=29, INT=30, WS=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STAR", "GT", "GE", "EQ", 
		"NE", "LT", "LE", "LIKE", "TRUE", "FALSE", "NULL", "ID", "STRING", "FLOAT", 
		"INT", "DIGIT", "ID_LETTER", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\7\34\u00a2\n\34\f\34\16\34\u00a5\13\34\3\35\3\35\7"+
		"\35\u00a9\n\35\f\35\16\35\u00ac\13\35\3\35\3\35\3\36\6\36\u00b1\n\36\r"+
		"\36\16\36\u00b2\3\36\3\36\7\36\u00b7\n\36\f\36\16\36\u00ba\13\36\3\36"+
		"\3\36\6\36\u00be\n\36\r\36\16\36\u00bf\5\36\u00c2\n\36\3\37\6\37\u00c5"+
		"\n\37\r\37\16\37\u00c6\3 \3 \3!\3!\3\"\6\"\u00ce\n\"\r\"\16\"\u00cf\3"+
		"\"\3\"\3\u00aa\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?\2A\2C!\3\2\5\3\2\62;\5\2C\\aac|\3\2\"\"\u00d9\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5J\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13"+
		"Q\3\2\2\2\rX\3\2\2\2\17Z\3\2\2\2\21]\3\2\2\2\23_\3\2\2\2\25a\3\2\2\2\27"+
		"d\3\2\2\2\31i\3\2\2\2\33l\3\2\2\2\35p\3\2\2\2\37v\3\2\2\2!x\3\2\2\2#z"+
		"\3\2\2\2%|\3\2\2\2\'\177\3\2\2\2)\u0081\3\2\2\2+\u0084\3\2\2\2-\u0086"+
		"\3\2\2\2/\u0089\3\2\2\2\61\u008e\3\2\2\2\63\u0093\3\2\2\2\65\u0099\3\2"+
		"\2\2\67\u009e\3\2\2\29\u00a6\3\2\2\2;\u00c1\3\2\2\2=\u00c4\3\2\2\2?\u00c8"+
		"\3\2\2\2A\u00ca\3\2\2\2C\u00cd\3\2\2\2EF\7h\2\2FG\7t\2\2GH\7q\2\2HI\7"+
		"o\2\2I\4\3\2\2\2JK\7k\2\2KL\7p\2\2L\6\3\2\2\2MN\7\60\2\2N\b\3\2\2\2OP"+
		"\7+\2\2P\n\3\2\2\2QR\7u\2\2RS\7g\2\2ST\7n\2\2TU\7g\2\2UV\7e\2\2VW\7v\2"+
		"\2W\f\3\2\2\2XY\7.\2\2Y\16\3\2\2\2Z[\7q\2\2[\\\7t\2\2\\\20\3\2\2\2]^\7"+
		"*\2\2^\22\3\2\2\2_`\7<\2\2`\24\3\2\2\2ab\7&\2\2bc\7}\2\2c\26\3\2\2\2d"+
		"e\7w\2\2ef\7u\2\2fg\7g\2\2gh\7t\2\2h\30\3\2\2\2ij\7c\2\2jk\7u\2\2k\32"+
		"\3\2\2\2lm\7c\2\2mn\7p\2\2no\7f\2\2o\34\3\2\2\2pq\7y\2\2qr\7j\2\2rs\7"+
		"g\2\2st\7t\2\2tu\7g\2\2u\36\3\2\2\2vw\7\177\2\2w \3\2\2\2xy\7,\2\2y\""+
		"\3\2\2\2z{\7@\2\2{$\3\2\2\2|}\7@\2\2}~\7?\2\2~&\3\2\2\2\177\u0080\7?\2"+
		"\2\u0080(\3\2\2\2\u0081\u0082\7#\2\2\u0082\u0083\7?\2\2\u0083*\3\2\2\2"+
		"\u0084\u0085\7>\2\2\u0085,\3\2\2\2\u0086\u0087\7>\2\2\u0087\u0088\7?\2"+
		"\2\u0088.\3\2\2\2\u0089\u008a\7n\2\2\u008a\u008b\7k\2\2\u008b\u008c\7"+
		"m\2\2\u008c\u008d\7g\2\2\u008d\60\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090"+
		"\7t\2\2\u0090\u0091\7w\2\2\u0091\u0092\7g\2\2\u0092\62\3\2\2\2\u0093\u0094"+
		"\7h\2\2\u0094\u0095\7c\2\2\u0095\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097"+
		"\u0098\7g\2\2\u0098\64\3\2\2\2\u0099\u009a\7p\2\2\u009a\u009b\7w\2\2\u009b"+
		"\u009c\7n\2\2\u009c\u009d\7n\2\2\u009d\66\3\2\2\2\u009e\u00a3\5A!\2\u009f"+
		"\u00a2\5A!\2\u00a0\u00a2\5? \2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2"+
		"\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a48\3"+
		"\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00aa\7)\2\2\u00a7\u00a9\13\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7)\2\2\u00ae"+
		":\3\2\2\2\u00af\u00b1\5? \2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b8\7\60"+
		"\2\2\u00b5\u00b7\5? \2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00c2\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb"+
		"\u00bd\7\60\2\2\u00bc\u00be\5? \2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00b0\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c2<\3\2\2\2\u00c3\u00c5\5? \2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7>\3\2\2\2\u00c8\u00c9\t\2\2\2\u00c9@\3\2\2\2\u00ca\u00cb\t\3"+
		"\2\2\u00cbB\3\2\2\2\u00cc\u00ce\t\4\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\b\"\2\2\u00d2D\3\2\2\2\f\2\u00a1\u00a3\u00aa\u00b2\u00b8\u00bf"+
		"\u00c1\u00c6\u00cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}