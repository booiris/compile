package bit.minisys.minicc.parser;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import bit.minisys.minicc.MiniCCCfg;
import bit.minisys.minicc.internal.util.MiniCCUtil;
import bit.minisys.minicc.parser.ast.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MyIMiniCCParser implements IMiniCCParser {
	public String run(String iFile) throws Exception {
		System.out.println("Parsing...");

		String oFile = MiniCCUtil.removeAllExt(iFile) + MiniCCCfg.MINICC_PARSER_OUTPUT_EXT;
		String tFile = MiniCCUtil.removeAllExt(iFile) + MiniCCCfg.MINICC_PP_INPUT_EXT;

		InputStream is = new FileInputStream(tFile);
		ANTLRInputStream input = new ANTLRInputStream(is);
		cLexer lexer = new cLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		cParser parser = new cParser(tokens);
		ParseTree tree = parser.compilationUnit();

		MyVisitor eval = new MyVisitor();

		ASTNode ans = (ASTNode) eval.visit(tree);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ans);

		FileWriter writer;
		writer = new FileWriter(oFile);
        writer.write(json);
        writer.flush();
        writer.close();

		return oFile;
	}
}
