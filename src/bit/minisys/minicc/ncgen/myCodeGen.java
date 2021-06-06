package bit.minisys.minicc.ncgen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.icgen.internal.IRBuilder;
import bit.minisys.minicc.icgen.internal.MiniCCICGen;
import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.ncgen.IMiniCCCodeGen;

public class myCodeGen implements IMiniCCCodeGen {

	public myCodeGen() {

	}

	@Override
	public String run(String iFile, MiniCCCfg cfg) throws Exception {
		String oFile = MiniCCUtil.remove2Ext(iFile) + MiniCCCfg.MINICC_CODEGEN_OUTPUT_EXT;

		if (cfg.target.equals("mips")) {
			System.out.println("123");
			System.out.println("1231233333");
			System.out.println("123333");
			for (int x = 0; x < 10; x++) {
				
			}
		} else if (cfg.target.equals("riscv")) {
			// TODO:
		} else if (cfg.target.equals("x86")) {
			// TODO:
		}

		System.out.println("7. Target code generation finished!");

		return oFile;
	}
}
