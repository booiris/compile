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

	String nc_code = "";

	public myCodeGen() {

	}

	@Override
	public String run(String iFile, MiniCCCfg cfg) throws Exception {
		String oFile = MiniCCUtil.remove2Ext(iFile) + MiniCCCfg.MINICC_CODEGEN_OUTPUT_EXT;

		if (cfg.target.equals("mips")) {
			System.out.println(oFile);
			nc_code = nc_code + "\n";
			FileWriter temp = new FileWriter(oFile);
			temp.write(nc_code);
			temp.flush();
			temp.close();git
		}

		System.out.println("7. Target code generation finished!");

		return oFile;
	}
}
