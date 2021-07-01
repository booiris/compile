package bit.minisys.minicc.ncgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;

import com.kenai.jffi.Array;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.icgen.internal.IRBuilder;
import bit.minisys.minicc.icgen.internal.MiniCCICGen;
import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.ncgen.IMiniCCCodeGen;

public class myCodeGen implements IMiniCCCodeGen {

	StringBuffer nc_code_string = new StringBuffer();
	List<String> nc_code = new ArrayList<String>();
	List<Quat> quat_list = new ArrayList<Quat>();
	int label_cnt = 0;
	int func_index = 0;

	public myCodeGen() {

	}

	void init() {
		nc_code.add(
				"__init:\nlui $sp, 0x8000\naddi $sp, $sp, 0x0000\nmove $fp, $sp\nadd $gp, $gp, 0x8000\njal main\nli $v0, 10\nsyscall\nMars_PrintInt:\nli $v0, 1\nsyscall\nli $v0, 4\nmove $v1, $a0\nla $a0, blank\nsyscall\nmove $a0, $v1\njr $ra\nMars_GetInt:\nli $v0, 5\nsyscall\njr $ra\nMars_PrintStr:\nli $v0, 4\nsyscall\njr $ra");
	}

	void gen_local_data() {

	}

	Map<String, Integer> sc = new HashMap<String, Integer>();
	Map<String, Integer> var_set = new HashMap<String, Integer>();
	Map<String, Integer> global_var_set = new HashMap<String, Integer>();

	void gen_global_data() {
		nc_code.add(0, ".data");
		nc_code.add(1, "blank : .asciiz \" \"");
		for (Map.Entry<String, Integer> x : sc.entrySet()) {
			String temp = "_" + x.getValue().toString() + "sc : .asciiz \"" + x.getKey() + "\"";
			nc_code.add(1, temp);
		}
		for (Map.Entry<String, Integer> x : global_var_set.entrySet()) {
			String temp = x.getKey() + " : .space " + String.valueOf(x.getValue());
			nc_code.add(1, temp);
		}
	}

	void ic_to_quat(String line) {
		if (line.length() == 0)
			return;
		int temp = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ') {
				temp = i;
				break;
			}
		}
		String temp_str = line.substring(temp + 1);
		String[] quat = temp_str.split(",");
		quat_list.add(new Quat(quat[0], quat[1], quat[2], quat[3]));
	}

	void quat_to_nc() {
		for (Quat x : quat_list) {
			String op = x.op;
			if (op.equals("jump") || op.equals("jump_true") || op.equals("jump_false") || op.equals("goto")) {
				int index = Integer.valueOf(x.res);
				if (quat_list.get(index).label == -1) {
					quat_list.get(index).label = index;
				}
			}
		}

		for (Quat x : quat_list) {
			gen_quat(x);
		}
	}

	int param_cnt = 0;

	int get_cnt = 0;

	int fun_temp_cnt;
	int max_data = 0;
	int func_cnt = 0;
	boolean is_in_func = false;

	void gen_quat(Quat now) {
		String op = now.op;
		if (now.label != -1) {
			nc_code.add("_temp_label_" + String.valueOf(now.label) + ":");
		}
		if (op.equals("enter")) {
			nc_code.add(now.res + ":");
			nc_code.add("subu $sp, $sp, 4");
			nc_code.add("sw $fp, ($sp)");
			nc_code.add("move $fp, $sp");
			fun_temp_cnt = Integer.valueOf(now.opnd1);
			nc_code.add("subu $sp, $sp, " + String.valueOf(fun_temp_cnt * 4));
			func_index = nc_code.size();
			var_set.clear();
			get_cnt = 0;
			max_data = fun_temp_cnt * 4;
			func_cnt++;
			is_in_func = true;
		} else if (op.equals("param")) {
			int temp_index = Integer.valueOf(now.res.substring(1));
			if (param_cnt == 0) {
				nc_code.add("lw $a0, -" + String.valueOf(temp_index * 4) + "($fp)");
			} else if (param_cnt == 1) {
				nc_code.add("lw $a1, -" + String.valueOf(temp_index * 4) + "($fp)");
			}
			param_cnt++;
		} else if (op.equals("Call")) {
			nc_code.add("subu $sp, $sp, 4");
			nc_code.add("sw $ra, ($sp)");
			nc_code.add("jal " + now.res);
		} else if (op.equals("get_return")) {
			int temp_index = Integer.valueOf(now.res.substring(1));
			nc_code.add("sw $v0, -" + String.valueOf(temp_index * 4) + "($fp)");
			param_cnt = 0;
			nc_code.add("lw $ra, ($sp)");
			nc_code.add("addu $sp, $sp, 4");
		} else if (op.equals("return")) {
			if (now.res.charAt(0) != '_') {
				int temp_index = Integer.valueOf(now.res.substring(1));
				nc_code.add("lw $v0, -" + String.valueOf(temp_index * 4) + "($fp)");
			}
		} else if (op.equals("leave")) {
			nc_code.add("j func_" + String.valueOf(func_cnt) + "_end");
		} else if (op.equals("jump") || op.equals("goto") || op.equals("break") || op.equals("continue")) {
			nc_code.add("j _temp_label_" + String.valueOf(now.res));
		} else if (op.equals("jump_true")) {
			if (now.opnd1.charAt(0) == '%') {
				int temp_index = Integer.valueOf(now.opnd1.substring(1));
				nc_code.add("lw $t0, -" + String.valueOf(temp_index * 4) + "($fp)");
				nc_code.add("bne $t0, $0, _temp_label_" + String.valueOf(now.res));
			}
		} else if (op.equals("jump_false")) {
			if (now.opnd1.charAt(0) == '%') {
				int temp_index = Integer.valueOf(now.opnd1.substring(1));
				nc_code.add("lw $t0, -" + String.valueOf(temp_index * 4) + "($fp)");
				nc_code.add("beq $t0, $0, _temp_label_" + String.valueOf(now.res));
			}
		} else if (op.equals("new")) {
			if (is_in_func) {
				max_data += Integer.valueOf(now.opnd1);
				var_set.put(now.res, max_data);
			} else {
				global_var_set.put(now.res, Integer.valueOf(now.opnd1) * 4);
			}
		} else if (op.equals("get_param")) {
			int data_index = var_set.get(now.res);
			String temp = "-" + String.valueOf(data_index) + "($fp)";
			if (get_cnt == 0) {
				nc_code.add("sw $a0, " + temp);
			} else if (get_cnt == 1) {
				nc_code.add("sw $a1, " + temp);
			}

		} else if (op.equals("end")) {
			int sum = 0;
			for (Map.Entry<String, Integer> x : var_set.entrySet()) {
				sum = sum > x.getValue() ? sum : x.getValue();
			}
			if (sum != 0)
				sum -= fun_temp_cnt * 4;
			nc_code.add(func_index, "subu $sp, $sp, " + String.valueOf(sum));
			nc_code.add("func_" + String.valueOf(func_cnt) + "_end:");
			nc_code.add("addu $sp, $sp, " + String.valueOf(sum));
			nc_code.add("addu $sp, $sp, " + String.valueOf(fun_temp_cnt * 4));
			nc_code.add("lw $fp, ($sp)");
			nc_code.add("addu $sp, $sp, 4");
			nc_code.add("jr $ra");
			is_in_func = false;
		} else {
			check_symbol(now);
		}
	}

	void reg(String var_name, String reg_name) {
		String name = "";
		String op = "lw";
		if (var_name.charAt(0) == '\"') {
			String temp = var_name.substring(1, var_name.length() - 1);
			if (!sc.containsKey(temp)) {
				sc.put(temp, sc.size());
			}
			op = "la";
			name = "_" + sc.get(temp) + "sc";
		} else if (var_name.charAt(0) >= '0' && var_name.charAt(0) <= '9') {
			name = var_name;
			op = "li";
		} else if (var_name.charAt(0) == '%') {
			int temp_index = Integer.valueOf(var_name.substring(1));
			name = "-" + String.valueOf(temp_index * 4) + "($fp)";
		} else if (var_set.containsKey(var_name)) {
			int data_index = var_set.get(var_name);
			nc_code.add("lw " + reg_name + ", -" + String.valueOf(data_index) + "($fp)");
			return;
		} else {
			name = var_name;
		}
		nc_code.add(op + " " + reg_name + ", " + name);
	}

	void save(String var_name, String reg_name) {
		if (var_name.charAt(0) == '%') {
			int temp_index = Integer.valueOf(var_name.substring(1));
			nc_code.add("sw " + reg_name + ", -" + String.valueOf(temp_index * 4) + "($fp)");
		} else if (var_set.containsKey(var_name)) {
			int data_index = var_set.get(var_name);
			nc_code.add("sw " + reg_name + ", -" + String.valueOf(data_index) + "($fp)");
			return;
		} else {
			nc_code.add("sw " + reg_name + ", " + var_name);
		}
	}

	int l_cnt = 0;

	void check_symbol(Quat now) {
		String op = now.op;
		if (op.equals("=")) {
			reg(now.opnd1, "$t0");
			save(now.res, "$t0");
		} else if (op.equals("+")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("add $t2, $t0, $t1");
			save(now.res, "$t2");
		} else if (op.equals("-")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("sub $t2, $t0, $t1");
			save(now.res, "$t2");
		} else if (op.equals("*")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("mult $t0, $t1");
			nc_code.add("mflo $t0");
			save(now.res, "$t0");
		} else if (op.equals("/")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("div $t0, $t1");
			nc_code.add("mflo $t0");
			save(now.res, "$t0");
		} else if (op.equals("%")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("div $t0, $t1");
			nc_code.add("mfhi $t0");
			save(now.res, "$t0");
		} else if (op.equals("++")) {
			reg(now.res, "$t0");
			nc_code.add("li $t1, 1");
			nc_code.add("add $t0, $t0, $t1");
			save(now.res, "$t0");
		} else if (op.equals("--")) {
			reg(now.res, "$t0");
			nc_code.add("li $t1, 1");
			nc_code.add("sub $t0, $t0, $t1");
			save(now.res, "$t0");
		} else if (op.equals(">")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("li $t3, 1");
			l_cnt++;
			nc_code.add("bgt $t0, $t1, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 0");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals(">=")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("li $t3, 1");
			l_cnt++;
			nc_code.add("bge $t0, $t1, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 0");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("<")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("li $t3, 1");
			l_cnt++;
			nc_code.add("blt $t0, $t1, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 0");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("<=")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("li $t3, 1");
			l_cnt++;
			nc_code.add("ble $t0, $t1, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 0");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("!=")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("li $t3, 1");
			l_cnt++;
			nc_code.add("bne $t0, $t1, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 0");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("==")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("li $t3, 1");
			l_cnt++;
			nc_code.add("beq $t0, $t1, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 0");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("&&")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("and $t0, $t0, $t1");
			nc_code.add("li $t3, 0");
			l_cnt++;
			nc_code.add("beq $t0, $0, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 1");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("||")) {
			reg(now.opnd1, "$t0");
			reg(now.opnd2, "$t1");
			nc_code.add("or $t0, $t0, $t1");
			nc_code.add("li $t3, 0");
			l_cnt++;
			nc_code.add("beq $t0, $0, jmp_" + String.valueOf(l_cnt));
			nc_code.add("li $t3, 1");
			nc_code.add("jmp_" + String.valueOf(l_cnt) + ":");
			save(now.res, "$t3");
		} else if (op.equals("=[]")) {
			String var_name = now.opnd1;
			if (var_set.containsKey(var_name)) {
				int data_index = var_set.get(var_name);
				nc_code.add("la $t5" + ", -" + String.valueOf(data_index) + "($fp)");
			} else {
				nc_code.add("la $t5" + ", " + var_name);
			}
			reg(now.opnd2, "$t6");
			nc_code.add("li $t7, 4");
			nc_code.add("mult $t6, $t7");
			nc_code.add("mflo $t6");
			nc_code.add("add $t5, $t5, $t6");
			nc_code.add("lw $t6, ($t5)");
			save(now.res, "$t6");
		} else if (op.equals("[]=")) {
			reg(now.res, "$t0");
			nc_code.add("sw $t0, ($t5)");
		}
	}

	void gen_code(String iFile) throws Exception {
		nc_code.add(".text");
		init();
		BufferedReader ic_code = new BufferedReader(new FileReader(iFile));
		String temp;
		while ((temp = ic_code.readLine()) != null) {
			ic_to_quat(temp.trim());
		}
		ic_code.close();
		quat_to_nc();
		gen_global_data();
	}

	@Override
	public String run(String iFile, MiniCCCfg cfg) throws Exception {
		String oFile = MiniCCUtil.remove2Ext(iFile) + MiniCCCfg.MINICC_CODEGEN_OUTPUT_EXT;

		if (cfg.target.equals("mips")) {
			gen_code(iFile);
			for (String temp : nc_code) {
				if (temp.charAt(temp.length() - 1) == ':' || temp.charAt(0) == '.')
					nc_code_string.append(temp + "\n");
				else
					nc_code_string.append("	" + temp + "\n");
			}
			nc_code_string.append("\n");
			FileWriter temp = new FileWriter(oFile);
			temp.write(nc_code_string.toString());
			temp.flush();
			temp.close();
		}

		System.out.println("7. Target code generation finished!");

		return oFile;
	}
}
