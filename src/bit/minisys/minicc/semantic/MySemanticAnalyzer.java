package bit.minisys.minicc.semantic;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.parser.ast.ASTCompilationUnit;

public class MySemanticAnalyzer implements IMiniCCSemantic{

	@Override
	public String run(String iFile) throws Exception {
		// iFile is xx.ast.json
		// fetch AST Tree
		ObjectMapper mapper = new ObjectMapper();
		String temp = MiniCCUtil.removeAllExtNew(iFile) + MiniCCCfg.MINICC_PARSER_OUTPUT_EXT;
		String oFile = MiniCCUtil.removeAllExtNew(iFile) + MiniCCCfg.MINICC_PARSER_OUTPUT_EXT;

		ASTCompilationUnit program = (ASTCompilationUnit) mapper.readValue(new File(temp), ASTCompilationUnit.class);

		/*
		 * You should build SymbolTable here or get it from semantic analysis .. This ic
		 * generator skips this step because it only implements addition and subtraction
		 */

		// use visitor pattern to build IR
		semantic_builder seBuilder = new semantic_builder();
		program.accept(seBuilder);

		// oFile is xx.ir.txt
		// String oFile = MiniCCUtil.remove2Ext(iFile) + MiniCCCfg.MINICC_ICGEN_OUTPUT_EXT;
		// ExampleICPrinter icPrinter = new ExampleICPrinter(icBuilder.getQuats());
		// icPrinter.print(oFile);
		System.out.println("semantic finished!");
		return oFile;
	}

}
