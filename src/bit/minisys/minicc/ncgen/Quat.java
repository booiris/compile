package bit.minisys.minicc.ncgen;

// 四元式形式的中间代码, 操作数和返回值的结构直接使用AST节点，也可以自定义IR节点
public class Quat {
	public String op;
	public String res;
	public String opnd1;
	public String opnd2;
	public int label = -1;

	public Quat(String op, String opnd1, String opnd2, String res) {
		this.op = op;
		this.res = res;
		this.opnd1 = opnd1;
		this.opnd2 = opnd2;
	}

}
