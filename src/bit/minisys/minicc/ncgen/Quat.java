package bit.minisys.minicc.ncgen;

// ��Ԫʽ��ʽ���м����, �������ͷ���ֵ�Ľṹֱ��ʹ��AST�ڵ㣬Ҳ�����Զ���IR�ڵ�
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
