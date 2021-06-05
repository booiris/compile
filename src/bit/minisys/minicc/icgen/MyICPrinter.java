package bit.minisys.minicc.icgen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import bit.minisys.minicc.parser.ast.ASTCharConstant;
import bit.minisys.minicc.parser.ast.ASTFloatConstant;
import bit.minisys.minicc.parser.ast.ASTIdentifier;
import bit.minisys.minicc.parser.ast.ASTIntegerConstant;
import bit.minisys.minicc.parser.ast.ASTNode;
import bit.minisys.minicc.parser.ast.ASTStringConstant;
import bit.minisys.minicc.parser.ast.ASTVariableDeclarator;

public class MyICPrinter {
	private List<Quat> quats;

	public MyICPrinter(List<Quat> quats) {
		this.quats = quats;
	}

	public void print(String filename) {
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (Quat quat : quats) {
			String op = quat.getOp();
			String res = astStr(quat.getRes());
			String opnd1 = astStr(quat.getOpnd1());
			String opnd2 = astStr(quat.getOpnd2());
			String num = String.format("%d", cnt);
			if (op == "enter")
				sb.append("\n");
			sb.append(num + " (" + op + "," + opnd1 + "," + opnd2 + "," + res + ")\n");
			cnt++;
		}
		// write
		try {
			FileWriter fileWriter = new FileWriter(new File(filename));
			fileWriter.write(sb.toString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String astStr(ASTNode node) {
		if (node == null) {
			return "_";
		} else if (node instanceof ASTIdentifier) {
			return ((ASTIdentifier) node).value;
		} else if (node instanceof ASTIntegerConstant) {
			return ((ASTIntegerConstant) node).value + "";
		} else if (node instanceof TemporaryValue) {
			return ((TemporaryValue) node).name();
		} else if (node instanceof ASTCharConstant) {
			return ((ASTCharConstant) node).value;
		} else if (node instanceof ASTStringConstant) {
			return ((ASTStringConstant) node).value;
		} else if (node instanceof ASTFloatConstant) {
			return ((ASTFloatConstant) node).value + "";
		} else if (node instanceof ASTVariableDeclarator) {
			return ((ASTVariableDeclarator) node).getName();
		} else {
			return "";
		}
	}
}
