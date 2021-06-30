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
	Integer temp_cnt = 0;

	public myCodeGen() {

	}

	void init() {
		nc_code.add(
				"__init:\nlui $sp, 0x8000\naddi $sp, $sp, 0x0000\nmove $fp, $sp\nadd $gp, $gp, 0x8000\njal main\nli $v0, 10\nsyscall\nMars_PrintInt:\nli $v0, 1\nsyscall\nli $v0, 4\nmove $v1, $a0\nla $a0, blank\nsyscall\nmove $a0, $v1\njr $ra\nMars_GetInt:\nli $v0, 5\nsyscall\njr $ra\nMars_PrintStr:\nli $v0, 4\nsyscall\njr $ra");
	}

	Integer sc_cnt = 0;
	List<String> sc = new ArrayList<String>();

	void gen_global_data() {
		nc_code.add(0, ".data");
		nc_code.add(1, "blank : .asciiz \" \"");
		for (String x : sc) {
			String temp = "_" + sc_cnt.toString() + "sc : .asciiz \"" + x + "\"";
			nc_code.add(1, temp);
			sc_cnt++;
		}
	}

	void gen_func() {

	}

	void gen_code(String iFile) {
		nc_code.add(".text");
		init();
		BufferedReader ic_code = new BufferedReader(new FileReader(iFile));

		String temp;
		while ((temp = ic_code.readLine()) != null) {

		}
		gen_global_data();
	}

	@Override
	public String run(String iFile, MiniCCCfg cfg) throws Exception {
		String oFile = MiniCCUtil.remove2Ext(iFile) + MiniCCCfg.MINICC_CODEGEN_OUTPUT_EXT;

		if (cfg.target.equals("mips")) {
			gen_code(iFile);
			for (String temp : nc_code) {
				nc_code_string.append(temp + "\n");
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
