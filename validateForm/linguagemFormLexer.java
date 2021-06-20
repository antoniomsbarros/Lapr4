// Generated from C:/lei20_21_s4_2dg_04/grammar\linguagemForm.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class linguagemFormLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IF=2, STR_STATE=3, SIZE=4, BETWEEN=5, SIDE_BAR=6, AND=7, IS=8, 
		END=9, COLON=10, POINT=11, QUOTE_MARKS=12, VERIFICATION_OP=13, LOGIC_OP=14, 
		BOOLEAN_OP=15, EQUAL_OR_NOT=16, CONDITION_OP=17, OPTION_TYPE=18, MATH_OP=19, 
		OBLIGATION=20, STRING=21, INTEGER=22, DATA=23, YEAR=24, MONTH=25, DAY=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "IF", "STR_STATE", "SIZE", "BETWEEN", "SIDE_BAR", "AND", "IS", 
			"END", "COLON", "POINT", "QUOTE_MARKS", "VERIFICATION_OP", "LOGIC_OP", 
			"BOOLEAN_OP", "EQUAL_OR_NOT", "CONDITION_OP", "OPTION_TYPE", "MATH_OP", 
			"OBLIGATION", "STRING", "INTEGER", "DATA", "YEAR", "MONTH", "DAY"
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


	public linguagemFormLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "linguagemForm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u016a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4a\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5q\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0087\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0091\n\b\3\t\3\t\3\t\3"+
		"\t\5\t\u0097\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00a6\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00c5\n\20\3\21\3\21\3\21\3\21\5\21\u00cb"+
		"\n\21\3\22\3\22\3\22\3\22\5\22\u00d1\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u00e8\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0142\n\25\3\26\6\26\u0145"+
		"\n\26\r\26\16\26\u0146\3\27\6\27\u014a\n\27\r\27\16\27\u014b\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\5\32"+
		"\u015d\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0169"+
		"\n\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\3\2\20\4\2>>@@\6\2((``~~\u0080\u0080\6\2\'\',-//\61\61\4\2C\\c|\3\2\62"+
		";\3\2\64\64\3\2\62\62\3\2\63;\3\2\63\63\3\2\62\64\3\2\62:\3\2;;\3\2\65"+
		"\65\3\2\62\63\2\u018b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3"+
		"\2\2\2\5<\3\2\2\2\7`\3\2\2\2\tp\3\2\2\2\13\u0086\3\2\2\2\r\u0088\3\2\2"+
		"\2\17\u0090\3\2\2\2\21\u0096\3\2\2\2\23\u0098\3\2\2\2\25\u009a\3\2\2\2"+
		"\27\u009c\3\2\2\2\31\u009e\3\2\2\2\33\u00a5\3\2\2\2\35\u00a7\3\2\2\2\37"+
		"\u00c4\3\2\2\2!\u00ca\3\2\2\2#\u00d0\3\2\2\2%\u00e7\3\2\2\2\'\u00e9\3"+
		"\2\2\2)\u0141\3\2\2\2+\u0144\3\2\2\2-\u0149\3\2\2\2/\u014d\3\2\2\2\61"+
		"\u0153\3\2\2\2\63\u015c\3\2\2\2\65\u0168\3\2\2\2\678\7v\2\289\7j\2\29"+
		":\7g\2\2:;\7p\2\2;\4\3\2\2\2<=\7k\2\2=>\7h\2\2>\6\3\2\2\2?@\7g\2\2@A\7"+
		"o\2\2AB\7r\2\2BC\7v\2\2Ca\7{\2\2DE\7G\2\2EF\7o\2\2FG\7r\2\2GH\7v\2\2H"+
		"a\7{\2\2IJ\7G\2\2JK\7O\2\2KL\7R\2\2LM\7V\2\2Ma\7[\2\2NO\7h\2\2OP\7k\2"+
		"\2PQ\7n\2\2QR\7n\2\2RS\7g\2\2Sa\7f\2\2TU\7H\2\2UV\7k\2\2VW\7n\2\2WX\7"+
		"n\2\2XY\7g\2\2Ya\7f\2\2Z[\7H\2\2[\\\7K\2\2\\]\7N\2\2]^\7N\2\2^_\7G\2\2"+
		"_a\7F\2\2`?\3\2\2\2`D\3\2\2\2`I\3\2\2\2`N\3\2\2\2`T\3\2\2\2`Z\3\2\2\2"+
		"a\b\3\2\2\2bc\7u\2\2cd\7k\2\2de\7|\2\2ef\7g\2\2fg\7\"\2\2gh\7k\2\2hq\7"+
		"u\2\2ij\7U\2\2jk\7K\2\2kl\7\\\2\2lm\7G\2\2mn\7\"\2\2no\7K\2\2oq\7U\2\2"+
		"pb\3\2\2\2pi\3\2\2\2q\n\3\2\2\2rs\7k\2\2st\7u\2\2tu\7\"\2\2uv\7d\2\2v"+
		"w\7g\2\2wx\7v\2\2xy\7y\2\2yz\7g\2\2z{\7g\2\2{\u0087\7p\2\2|}\7K\2\2}~"+
		"\7U\2\2~\177\7\"\2\2\177\u0080\7D\2\2\u0080\u0081\7G\2\2\u0081\u0082\7"+
		"V\2\2\u0082\u0083\7Y\2\2\u0083\u0084\7G\2\2\u0084\u0085\7G\2\2\u0085\u0087"+
		"\7P\2\2\u0086r\3\2\2\2\u0086|\3\2\2\2\u0087\f\3\2\2\2\u0088\u0089\7\61"+
		"\2\2\u0089\16\3\2\2\2\u008a\u008b\7C\2\2\u008b\u008c\7P\2\2\u008c\u0091"+
		"\7F\2\2\u008d\u008e\7c\2\2\u008e\u008f\7p\2\2\u008f\u0091\7f\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u008d\3\2\2\2\u0091\20\3\2\2\2\u0092\u0093\7K\2\2"+
		"\u0093\u0097\7U\2\2\u0094\u0095\7k\2\2\u0095\u0097\7u\2\2\u0096\u0092"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\22\3\2\2\2\u0098\u0099\7=\2\2\u0099"+
		"\24\3\2\2\2\u009a\u009b\7<\2\2\u009b\26\3\2\2\2\u009c\u009d\7\60\2\2\u009d"+
		"\30\3\2\2\2\u009e\u009f\7$\2\2\u009f\32\3\2\2\2\u00a0\u00a6\t\2\2\2\u00a1"+
		"\u00a2\7>\2\2\u00a2\u00a6\7?\2\2\u00a3\u00a4\7@\2\2\u00a4\u00a6\7?\2\2"+
		"\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\34"+
		"\3\2\2\2\u00a7\u00a8\t\3\2\2\u00a8\36\3\2\2\2\u00a9\u00aa\7v\2\2\u00aa"+
		"\u00ab\7t\2\2\u00ab\u00ac\7w\2\2\u00ac\u00c5\7g\2\2\u00ad\u00ae\7V\2\2"+
		"\u00ae\u00af\7t\2\2\u00af\u00b0\7w\2\2\u00b0\u00c5\7g\2\2\u00b1\u00b2"+
		"\7V\2\2\u00b2\u00b3\7T\2\2\u00b3\u00b4\7W\2\2\u00b4\u00c5\7G\2\2\u00b5"+
		"\u00b6\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7u\2\2"+
		"\u00b9\u00c5\7g\2\2\u00ba\u00bb\7H\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd"+
		"\7n\2\2\u00bd\u00be\7u\2\2\u00be\u00c5\7g\2\2\u00bf\u00c0\7H\2\2\u00c0"+
		"\u00c1\7C\2\2\u00c1\u00c2\7N\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c5\7G\2\2"+
		"\u00c4\u00a9\3\2\2\2\u00c4\u00ad\3\2\2\2\u00c4\u00b1\3\2\2\2\u00c4\u00b5"+
		"\3\2\2\2\u00c4\u00ba\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c5 \3\2\2\2\u00c6"+
		"\u00c7\7?\2\2\u00c7\u00cb\7?\2\2\u00c8\u00c9\7#\2\2\u00c9\u00cb\7?\2\2"+
		"\u00ca\u00c6\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\"\3\2\2\2\u00cc\u00cd\7"+
		"(\2\2\u00cd\u00d1\7(\2\2\u00ce\u00cf\7~\2\2\u00cf\u00d1\7~\2\2\u00d0\u00cc"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1$\3\2\2\2\u00d2\u00d3\7K\2\2\u00d3\u00d4"+
		"\7P\2\2\u00d4\u00d5\7V\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d7\7I\2\2\u00d7"+
		"\u00d8\7G\2\2\u00d8\u00e8\7T\2\2\u00d9\u00da\7U\2\2\u00da\u00db\7v\2\2"+
		"\u00db\u00dc\7t\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de\u00e8"+
		"\7i\2\2\u00df\u00e0\7D\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7q\2\2\u00e2"+
		"\u00e8\7n\2\2\u00e3\u00e4\7F\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7v\2\2"+
		"\u00e6\u00e8\7c\2\2\u00e7\u00d2\3\2\2\2\u00e7\u00d9\3\2\2\2\u00e7\u00df"+
		"\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8&\3\2\2\2\u00e9\u00ea\t\4\2\2\u00ea"+
		"(\3\2\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7d\2\2\u00ed\u00ee\7n\2\2\u00ee"+
		"\u00ef\7k\2\2\u00ef\u00f0\7i\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7v\2\2"+
		"\u00f2\u00f3\7q\2\2\u00f3\u00f4\7t\2\2\u00f4\u0142\7{\2\2\u00f5\u00f6"+
		"\7Q\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7k\2\2\u00f9"+
		"\u00fa\7i\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7q\2\2"+
		"\u00fd\u00fe\7t\2\2\u00fe\u0142\7{\2\2\u00ff\u0100\7Q\2\2\u0100\u0101"+
		"\7D\2\2\u0101\u0102\7N\2\2\u0102\u0103\7K\2\2\u0103\u0104\7I\2\2\u0104"+
		"\u0105\7C\2\2\u0105\u0106\7V\2\2\u0106\u0107\7Q\2\2\u0107\u0108\7T\2\2"+
		"\u0108\u0142\7[\2\2\u0109\u010a\7p\2\2\u010a\u010b\7q\2\2\u010b\u010c"+
		"\7v\2\2\u010c\u010d\7\"\2\2\u010d\u010e\7q\2\2\u010e\u010f\7d\2\2\u010f"+
		"\u0110\7n\2\2\u0110\u0111\7k\2\2\u0111\u0112\7i\2\2\u0112\u0113\7c\2\2"+
		"\u0113\u0114\7v\2\2\u0114\u0115\7q\2\2\u0115\u0116\7t\2\2\u0116\u0142"+
		"\7{\2\2\u0117\u0118\7P\2\2\u0118\u0119\7q\2\2\u0119\u011a\7v\2\2\u011a"+
		"\u011b\7\"\2\2\u011b\u011c\7Q\2\2\u011c\u011d\7d\2\2\u011d\u011e\7n\2"+
		"\2\u011e\u011f\7k\2\2\u011f\u0120\7i\2\2\u0120\u0121\7c\2\2\u0121\u0122"+
		"\7v\2\2\u0122\u0123\7q\2\2\u0123\u0124\7t\2\2\u0124\u0142\7{\2\2\u0125"+
		"\u0126\7P\2\2\u0126\u0127\7Q\2\2\u0127\u0128\7V\2\2\u0128\u0129\7\"\2"+
		"\2\u0129\u012a\7Q\2\2\u012a\u012b\7D\2\2\u012b\u012c\7N\2\2\u012c\u012d"+
		"\7K\2\2\u012d\u012e\7I\2\2\u012e\u012f\7C\2\2\u012f\u0130\7V\2\2\u0130"+
		"\u0131\7Q\2\2\u0131\u0132\7T\2\2\u0132\u0142\7[\2\2\u0133\u0134\7P\2\2"+
		"\u0134\u0135\7q\2\2\u0135\u0136\7v\2\2\u0136\u0137\7\"\2\2\u0137\u0138"+
		"\7q\2\2\u0138\u0139\7d\2\2\u0139\u013a\7n\2\2\u013a\u013b\7k\2\2\u013b"+
		"\u013c\7i\2\2\u013c\u013d\7c\2\2\u013d\u013e\7v\2\2\u013e\u013f\7q\2\2"+
		"\u013f\u0140\7t\2\2\u0140\u0142\7{\2\2\u0141\u00eb\3\2\2\2\u0141\u00f5"+
		"\3\2\2\2\u0141\u00ff\3\2\2\2\u0141\u0109\3\2\2\2\u0141\u0117\3\2\2\2\u0141"+
		"\u0125\3\2\2\2\u0141\u0133\3\2\2\2\u0142*\3\2\2\2\u0143\u0145\t\5\2\2"+
		"\u0144\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147,\3\2\2\2\u0148\u014a\t\6\2\2\u0149\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c.\3\2\2\2"+
		"\u014d\u014e\5\65\33\2\u014e\u014f\5\r\7\2\u014f\u0150\5\63\32\2\u0150"+
		"\u0151\5\r\7\2\u0151\u0152\5\61\31\2\u0152\60\3\2\2\2\u0153\u0154\t\7"+
		"\2\2\u0154\u0155\t\b\2\2\u0155\u0156\t\6\2\2\u0156\u0157\t\6\2\2\u0157"+
		"\62\3\2\2\2\u0158\u0159\t\b\2\2\u0159\u015d\t\t\2\2\u015a\u015b\t\n\2"+
		"\2\u015b\u015d\t\13\2\2\u015c\u0158\3\2\2\2\u015c\u015a\3\2\2\2\u015d"+
		"\64\3\2\2\2\u015e\u015f\t\b\2\2\u015f\u0169\t\t\2\2\u0160\u0161\t\n\2"+
		"\2\u0161\u0169\t\6\2\2\u0162\u0163\t\7\2\2\u0163\u0169\t\f\2\2\u0164\u0165"+
		"\t\7\2\2\u0165\u0169\t\r\2\2\u0166\u0167\t\16\2\2\u0167\u0169\t\17\2\2"+
		"\u0168\u015e\3\2\2\2\u0168\u0160\3\2\2\2\u0168\u0162\3\2\2\2\u0168\u0164"+
		"\3\2\2\2\u0168\u0166\3\2\2\2\u0169\66\3\2\2\2\22\2`p\u0086\u0090\u0096"+
		"\u00a5\u00c4\u00ca\u00d0\u00e7\u0141\u0146\u014b\u015c\u0168\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}