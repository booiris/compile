package bit.minisys.minicc.scanner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import org.python.antlr.PythonParser.else_clause_return;

import java.util.HashMap;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.pp.internal.C;
import mars.venus.editors.jeditsyntax.InputHandler.next_char;
import mars.venus.editors.jeditsyntax.InputHandler.next_word;

enum DFA_STATE {
	init, checking_variable, checking_symbol_1, checking_symbol_2, output_symbol, output_variable, start_check,
	get_white, end, checking_number, checking_decimal, checking_int, checking_hexadecimal_int,
	checking_hexadecimal_decimal, checking_int_suffix, checking_hexadecimal, checking_exp, checking_hexadecimal_exp,
	checking_decimal_suffix, output_int, output_decimal, checking_str, checking_char, output_str, checking_str_prefix,
	wrong
}

public class IMiniCCScanner {

	private int line_index = 0;
	private int col_index = 0;
	private int str_index = 0;
	private int iTknNum = 0;
	private String res = "";
	private String now_word = "";
	private char nxt_char = ' ';
	private boolean keep = false;
	private boolean wrap = false;

	private ArrayList<String> srcLines;

	private HashSet<String> keywordSet;

	private static String[] keyword_list = { "auto", "break", "case", "char", "const", "continue", "default", "do",
			"double", "else", "enum", "extern", "float", "for", "goto", "if", "inline", "int", "long", "register",
			"restrict", "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef", "union",
			"unsigned", "void", "volatile", "while" };

	private static String[] symbol_list = { ",", "[", "]", "+", "-", "*", "/", ">>", "<<", "%", ">", "<", "==", "!=",
			">=", "<=", "+=", "-=", "*=", "/=", ">>=", "<<=", "&&", "||", "|", "&", "^", "|=", "&=", "^=", "++", "--",
			"!", "~", "&", "^", "->", ".", "?", ":", "{", "}", ";", "(", ")", ":" };

	public IMiniCCScanner() {
		this.keywordSet = new HashSet<String>();
		for (String x : keyword_list) {
			this.keywordSet.add(x);
		}
	}

	private boolean find(char x, int index) {
		for (String i : symbol_list) {
			if (i.length() <= index)
				continue;
			if (x == i.charAt(index))
				return true;
		}
		return false;
	}

	private char getNextChar() {
		if (wrap) {
			line_index++;
			col_index = 0;
			wrap = false;
		}
		str_index++;
		char c = Character.MAX_VALUE;
		while (true) {
			if (line_index < srcLines.size()) {
				String line = srcLines.get(line_index);
				if (col_index < line.length()) {
					c = line.charAt(col_index);
					col_index++;
					break;
				} else {
					wrap = true;
					col_index++;
					c = '\n';
					break;
				}
			} else {
				break;
			}
		}
		if (c == '\u001a') {
			c = Character.MAX_VALUE;
		}
		return c;
	}

	private boolean isAlpha(char c) {
		return Character.isAlphabetic(c) | c == '_';
	}

	private boolean isDigit(char c) {
		return Character.isDigit(c);
	}

	private boolean ExisDigit(char c) {
		return Character.isDigit(c) || c == 'a' || c == 'A' || c == 'b' || c == 'B' || c == 'C' || c == 'c' || c == 'D'
				|| c == 'd' || c == 'e' || c == 'E' || c == 'f' || c == 'F';
	}

	private boolean isAlphaOrDigit(char c) {
		return Character.isLetterOrDigit(c) || c == '_';
	}

	private String genToken(int num, String lexme, String type) {
		return genToken(num, lexme, type, this.col_index - 1, this.line_index, str_index - 1);
	}

	private String genToken2(int num, String lexme, String type) {
		return genToken(num, lexme, type, this.col_index - 2, this.line_index, str_index - 2);
	}

	private String genToken(int num, String lexme, String type, int cIndex, int lIndex, int sIndex) {
		String strToken = "";
		if (lexme != "<EOF>")
			strToken += "[@" + num + "," + (sIndex - lexme.length() + 1) + ":" + (sIndex);
		else
			strToken += "[@" + num + "," + (sIndex + 1) + ":" + (sIndex);
		strToken += "='" + lexme + "',<" + type + ">," + (lIndex + 1) + ":" + (cIndex - lexme.length() + 1) + "]\n";
		iTknNum++;
		return strToken;
	}

	private void main_list(DFA_STATE now_state) {
		// System.out.println(now_word + " " + now_state.toString());
		switch (now_state) {
		case init:
			start_check();
			break;
		case get_white:
			get_white();
			break;
		case end:
			end();
			break;
		case checking_symbol_1:
			checking_symbol_1();
			break;
		case checking_symbol_2:
			checking_symbol_2();
			break;
		case output_symbol:
			output_symbol();
			break;
		case checking_variable:
			checking_variable();
			break;
		case output_variable:
			output_variable();
			break;
		case checking_number:
			checking_number();
			break;
		case output_int:
			output_int();
			break;
		case output_decimal:
			output_decimal();
			break;
		case checking_int:
			checking_int();
			break;
		case checking_decimal:
			checking_decimal();
			break;
		case checking_hexadecimal:
			checking_hexadecimal();
			break;
		case checking_hexadecimal_int:
			checking_hexadecimal_int();
			break;
		case checking_hexadecimal_decimal:
			checking_hexadecimal_decimal();
			break;
		case checking_decimal_suffix:
			checking_decimal_suffix();
			break;
		case checking_exp:
			checking_exp();
			break;
		case checking_hexadecimal_exp:
			checking_hexadecimal_exp();
			break;
		case checking_int_suffix:
			checking_int_suffix();
			break;
		case checking_str:
			checking_str();
			break;
		case checking_str_prefix:
			checking_str_prefix();
			break;
		case checking_char:
			checking_char();
			break;
		case output_str:
			output_str();
			break;
		case wrong:
			System.out.println("[ERROR]Scanner:line " + line_index + ", column=" + col_index + ", unreachable state!");
			System.out.println(iTknNum);
			main_list(DFA_STATE.init);
			break;
		default:
			System.out.println(now_state.toString() + " not include");
			break;
		}
	}

	private void start_check() {
		if (!keep)
			nxt_char = getNextChar();
		keep = false;
		now_word = "" + nxt_char;
		if (nxt_char == '\'')
			main_list(DFA_STATE.checking_char);
		else if (nxt_char == '\"')
			main_list(DFA_STATE.checking_str);
		else if (nxt_char == 'u' || nxt_char == 'L' || nxt_char == 'U')
			main_list(DFA_STATE.checking_str_prefix);
		else if (isAlpha(nxt_char))
			main_list(DFA_STATE.checking_variable);
		else if (Character.isWhitespace(nxt_char))
			main_list(DFA_STATE.get_white);
		else if (nxt_char == Character.MAX_VALUE)
			main_list(DFA_STATE.end);
		else if (nxt_char == '0')
			main_list(DFA_STATE.checking_number);
		else if (isDigit(nxt_char))
			main_list(DFA_STATE.checking_int);
		else if (find(nxt_char, 0))
			main_list(DFA_STATE.checking_symbol_1);
		else
			main_list(DFA_STATE.wrong);
	}

	private void get_white() {
		nxt_char = getNextChar();
		if (Character.isWhitespace(nxt_char))
			main_list(DFA_STATE.get_white);
		else {
			keep = true;
			main_list(DFA_STATE.init);
		}
	}

	private void checking_variable() {
		nxt_char = getNextChar();
		if (isAlphaOrDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_variable);
		} else {
			keep = true;
			main_list(DFA_STATE.output_variable);
		}
	}

	private void output_variable() {
		if (keywordSet.contains(now_word))
			res += genToken2(iTknNum, now_word, "'" + now_word + "'");
		else
			res += genToken2(iTknNum, now_word, "Identifier");
		main_list(DFA_STATE.init);
	}

	private void checking_symbol_1() {
		nxt_char = getNextChar();
		if (find(nxt_char, 1)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_symbol_2);
		} else {
			keep = true;
			main_list(DFA_STATE.output_symbol);
		}
	}

	private void checking_symbol_2() {
		nxt_char = getNextChar();
		if (find(nxt_char, 2))
			now_word = now_word + nxt_char;
		else
			keep = true;
		main_list(DFA_STATE.output_symbol);
	}

	private void output_symbol() {
		if (keep)
			res += genToken2(iTknNum, now_word, "'" + now_word + "'");
		else
			res += genToken(iTknNum, now_word, "'" + now_word + "'");
		main_list(DFA_STATE.init);
	}

	private void checking_int() {
		nxt_char = getNextChar();
		if (isDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_int);
		} else if (nxt_char == '.') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (isDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_decimal);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else if (nxt_char == 'e' || nxt_char == 'E') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (nxt_char == '+' || nxt_char == '-') {
				now_word = now_word + nxt_char;
				nxt_char = getNextChar();
				if (isDigit(nxt_char)) {
					now_word = now_word + nxt_char;
					main_list(DFA_STATE.checking_exp);
				} else {
					keep = true;
					main_list(DFA_STATE.wrong);
				}
			} else if (isDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_exp);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else if (nxt_char == 'u' || nxt_char == 'U' || nxt_char == 'l' || nxt_char == 'L') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_int_suffix);
		} else {
			keep = true;
			main_list(DFA_STATE.output_int);
		}
	}

	private void checking_decimal() {
		nxt_char = getNextChar();
		if (isDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_decimal);
		} else if (nxt_char == 'e' || nxt_char == 'E') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (nxt_char == '+' || nxt_char == '-') {
				now_word = now_word + nxt_char;
				nxt_char = getNextChar();
				if (isDigit(nxt_char)) {
					now_word = now_word + nxt_char;
					main_list(DFA_STATE.checking_exp);
				} else {
					keep = true;
					main_list(DFA_STATE.wrong);
				}
			} else if (isDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_exp);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else if (nxt_char == 'f' || nxt_char == 'l' || nxt_char == 'F' || nxt_char == 'L') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.output_decimal);
		} else {
			keep = true;
			main_list(DFA_STATE.output_decimal);
		}
	}

	private void checking_number() {
		nxt_char = getNextChar();
		if (isDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_int);
		} else if (nxt_char == 'x' || nxt_char == 'X') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_hexadecimal);
		} else if (nxt_char == '.') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (isDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_decimal);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else {
			keep = true;
			main_list(DFA_STATE.output_int);
		}
	}

	private void checking_hexadecimal() {
		nxt_char = getNextChar();
		if (ExisDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_hexadecimal_int);
		} else {
			keep = true;
			main_list(DFA_STATE.wrong);
		}
	}

	private void checking_hexadecimal_int() {
		nxt_char = getNextChar();
		if (ExisDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_hexadecimal_int);
		} else if (nxt_char == 'p' || nxt_char == 'P') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (nxt_char == '+' || nxt_char == '-') {
				now_word = now_word + nxt_char;
				nxt_char = getNextChar();
				if (ExisDigit(nxt_char)) {
					now_word = now_word + nxt_char;
					main_list(DFA_STATE.checking_hexadecimal_exp);
				} else {
					keep = true;
					main_list(DFA_STATE.wrong);
				}
			} else if (ExisDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_hexadecimal_exp);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else if (nxt_char == 'u' || nxt_char == 'U' || nxt_char == 'l' || nxt_char == 'L') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_int_suffix);
		} else if (nxt_char == '.') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (ExisDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_hexadecimal_decimal);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else {
			keep = true;
			main_list(DFA_STATE.output_int);
		}

	}

	private void checking_hexadecimal_decimal() {
		nxt_char = getNextChar();
		if (ExisDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_hexadecimal_decimal);
		} else if (nxt_char == 'p' || nxt_char == 'P') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (nxt_char == '+' || nxt_char == '-') {
				now_word = now_word + nxt_char;
				nxt_char = getNextChar();
				if (ExisDigit(nxt_char)) {
					now_word = now_word + nxt_char;
					main_list(DFA_STATE.checking_hexadecimal_exp);
				} else {
					keep = true;
					main_list(DFA_STATE.wrong);
				}
			} else if (ExisDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_hexadecimal_exp);
			} else {
				keep = true;
				main_list(DFA_STATE.wrong);
			}
		} else {
			keep = true;
			main_list(DFA_STATE.wrong);
		}
	}

	private void checking_exp() {
		nxt_char = getNextChar();
		if (isDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_exp);
		} else if (nxt_char == 'f' || nxt_char == 'l' || nxt_char == 'F' || nxt_char == 'L') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_decimal_suffix);
		} else {
			keep = true;
			main_list(DFA_STATE.output_decimal);
		}
	}

	private void checking_hexadecimal_exp() {
		nxt_char = getNextChar();
		if (ExisDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_exp);
		} else if (nxt_char == 'f' || nxt_char == 'l' || nxt_char == 'F' || nxt_char == 'L') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_decimal_suffix);
		} else {
			keep = true;
			main_list(DFA_STATE.output_decimal);
		}
	}

	private void checking_int_suffix() {
		nxt_char = getNextChar();
		if (nxt_char == 'u' || nxt_char == 'U' || nxt_char == 'l' || nxt_char == 'L') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_int_suffix);
		} else {
			keep = true;
			main_list(DFA_STATE.output_int);
		}
	}

	private void checking_decimal_suffix() {
		nxt_char = getNextChar();
		keep = true;
		main_list(DFA_STATE.output_decimal);
	}

	private void output_int() {
		res += genToken2(iTknNum, now_word, "IntegerConstant");
		main_list(DFA_STATE.init);
	}

	private void output_decimal() {
		res += genToken2(iTknNum, now_word, "FloatingConstant");
		main_list(DFA_STATE.init);
	}

	private void checking_str_prefix() {
		char temp = nxt_char;
		nxt_char = getNextChar();
		if (temp == 'u' && nxt_char == '8') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			if (nxt_char == '\"') {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_str);
			} else if (isAlphaOrDigit(nxt_char)) {
				now_word = now_word + nxt_char;
				main_list(DFA_STATE.checking_variable);
			} else {
				keep = true;
				main_list(DFA_STATE.output_variable);
			}
		} else if (nxt_char == '\'') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_char);
		} else if (nxt_char == '\"') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_str);
		} else if (isAlphaOrDigit(nxt_char)) {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_variable);
		} else {
			keep = true;
			main_list(DFA_STATE.output_variable);
		}
	}

	private void output_str() {
		if (now_word.charAt(now_word.length() - 1) == '\'')
			res += genToken(iTknNum, now_word, "CharacterConstant");
		else
			res += genToken(iTknNum, now_word, "StringLiteral");
		main_list(DFA_STATE.init);
	}

	private void checking_char() {
		nxt_char = getNextChar();
		if (nxt_char == '\\') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_char);
		} else if (nxt_char == '\'') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.output_str);
		} else {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_char);
		}
	}

	private void checking_str() {
		nxt_char = getNextChar();
		if (nxt_char == '\\') {
			now_word = now_word + nxt_char;
			nxt_char = getNextChar();
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_str);
		} else if (nxt_char == '\"') {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.output_str);
		} else {
			now_word = now_word + nxt_char;
			main_list(DFA_STATE.checking_str);
		}
	}

	private void end() {
		col_index = 5;
		res += genToken(iTknNum, "<EOF>", "EOF");
	}

	public String run(String iFile) throws Exception {
		System.out.println("Scanning...");

		this.srcLines = MiniCCUtil.readFile(iFile);

		main_list(DFA_STATE.init);

		String oFile = MiniCCUtil.removeAllExt(iFile) + MiniCCCfg.MINICC_SCANNER_OUTPUT_EXT;
		MiniCCUtil.createAndWriteFile(oFile, res);

		return null;
	}
}
