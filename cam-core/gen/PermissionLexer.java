// Generated from /home/wuyaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, STAR=15, GT=16, GE=17, EQ=18, 
		NE=19, LT=20, LE=21, LIKE=22, TRUE=23, FALSE=24, ID=25, STRING=26, FLOAT=27, 
		INT=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'"
	};
	public static final String[] ruleNames = {
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "STAR", "GT", "GE", "EQ", "NE", 
		"LT", "LE", "LIKE", "TRUE", "FALSE", "ID", "STRING", "FLOAT", "INT", "DIGIT", 
		"ID_LETTER", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00c7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u0096\n\32\f\32\16\32\u0099\13"+
		"\32\3\33\3\33\7\33\u009d\n\33\f\33\16\33\u00a0\13\33\3\33\3\33\3\34\6"+
		"\34\u00a5\n\34\r\34\16\34\u00a6\3\34\3\34\7\34\u00ab\n\34\f\34\16\34\u00ae"+
		"\13\34\3\34\3\34\6\34\u00b2\n\34\r\34\16\34\u00b3\5\34\u00b6\n\34\3\35"+
		"\6\35\u00b9\n\35\r\35\16\35\u00ba\3\36\3\36\3\37\3\37\3 \6 \u00c2\n \r"+
		" \16 \u00c3\3 \3 \3\u009e\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\2=\2?\37\3\2\5\3\2\62;\5\2C\\aac|\3\2\"\"\u00cd"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2?\3"+
		"\2\2\2\3A\3\2\2\2\5F\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13R\3\2\2\2\rT\3\2"+
		"\2\2\17V\3\2\2\2\21Y\3\2\2\2\23[\3\2\2\2\25]\3\2\2\2\27`\3\2\2\2\31e\3"+
		"\2\2\2\33i\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!s\3\2\2\2#u\3\2\2\2%x\3\2\2"+
		"\2\'z\3\2\2\2)}\3\2\2\2+\177\3\2\2\2-\u0082\3\2\2\2/\u0087\3\2\2\2\61"+
		"\u008c\3\2\2\2\63\u0092\3\2\2\2\65\u009a\3\2\2\2\67\u00b5\3\2\2\29\u00b8"+
		"\3\2\2\2;\u00bc\3\2\2\2=\u00be\3\2\2\2?\u00c1\3\2\2\2AB\7h\2\2BC\7t\2"+
		"\2CD\7q\2\2DE\7o\2\2E\4\3\2\2\2FG\7u\2\2GH\7g\2\2HI\7n\2\2IJ\7g\2\2JK"+
		"\7e\2\2KL\7v\2\2L\6\3\2\2\2MN\7\60\2\2N\b\3\2\2\2OP\7k\2\2PQ\7p\2\2Q\n"+
		"\3\2\2\2RS\7+\2\2S\f\3\2\2\2TU\7.\2\2U\16\3\2\2\2VW\7q\2\2WX\7t\2\2X\20"+
		"\3\2\2\2YZ\7<\2\2Z\22\3\2\2\2[\\\7*\2\2\\\24\3\2\2\2]^\7c\2\2^_\7u\2\2"+
		"_\26\3\2\2\2`a\7p\2\2ab\7w\2\2bc\7n\2\2cd\7n\2\2d\30\3\2\2\2ef\7c\2\2"+
		"fg\7p\2\2gh\7f\2\2h\32\3\2\2\2ij\7y\2\2jk\7j\2\2kl\7g\2\2lm\7t\2\2mn\7"+
		"g\2\2n\34\3\2\2\2op\7&\2\2p\36\3\2\2\2qr\7,\2\2r \3\2\2\2st\7@\2\2t\""+
		"\3\2\2\2uv\7@\2\2vw\7?\2\2w$\3\2\2\2xy\7?\2\2y&\3\2\2\2z{\7#\2\2{|\7?"+
		"\2\2|(\3\2\2\2}~\7>\2\2~*\3\2\2\2\177\u0080\7>\2\2\u0080\u0081\7?\2\2"+
		"\u0081,\3\2\2\2\u0082\u0083\7n\2\2\u0083\u0084\7k\2\2\u0084\u0085\7m\2"+
		"\2\u0085\u0086\7g\2\2\u0086.\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089\7"+
		"t\2\2\u0089\u008a\7w\2\2\u008a\u008b\7g\2\2\u008b\60\3\2\2\2\u008c\u008d"+
		"\7h\2\2\u008d\u008e\7c\2\2\u008e\u008f\7n\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7g\2\2\u0091\62\3\2\2\2\u0092\u0097\5=\37\2\u0093\u0096\5=\37\2"+
		"\u0094\u0096\5;\36\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\64\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009e\7)\2\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2"+
		"\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7)\2\2\u00a2\66\3\2\2\2"+
		"\u00a3\u00a5\5;\36\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ac\7\60\2\2"+
		"\u00a9\u00ab\5;\36\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b6\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b1\7\60\2\2\u00b0\u00b2\5;\36\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00a4\3\2\2\2\u00b5\u00af\3\2\2\2\u00b68\3\2\2\2\u00b7\u00b9\5;\36\2"+
		"\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb:\3\2\2\2\u00bc\u00bd\t\2\2\2\u00bd<\3\2\2\2\u00be\u00bf"+
		"\t\3\2\2\u00bf>\3\2\2\2\u00c0\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c6\b \2\2\u00c6@\3\2\2\2\f\2\u0095\u0097\u009e\u00a6\u00ac"+
		"\u00b3\u00b5\u00ba\u00c3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}