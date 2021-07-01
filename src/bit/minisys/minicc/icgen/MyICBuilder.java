package bit.minisys.minicc.icgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

import bit.minisys.minicc.internal.ir.x;
import bit.minisys.minicc.parser.ast.*;

public class MyICBuilder implements ASTVisitor {

	private Map<ASTNode, ASTNode> map; // 使用map存储子节点的返回值，key对应子节点，value对应返回值，value目前类别包括ASTIdentifier,ASTIntegerConstant,TemportaryValue...
	private List<Quat> quats; // 生成的四元式列表
	private Integer temp_id; // 临时变量编号
	private Map<String, Integer> label;
	Stack<List<String>> var_list = new Stack<List<String>>();

	public MyICBuilder() {
		map = new HashMap<ASTNode, ASTNode>();
		quats = new LinkedList<Quat>();
		label = new HashMap<String, Integer>();
		temp_id = 0;
	}

	public List<Quat> getQuats() {
		return quats;
	}

	@Override
	public void visit(ASTCompilationUnit program) throws Exception {
		var_list.add(new ArrayList<String>());
		for (ASTNode node : program.items) {
			if (node instanceof ASTFunctionDefine) {
				var_list.add(new ArrayList<String>());
				visit((ASTFunctionDefine) node);
				var_list.pop();
				temp_id = 0;
			}
			if (node instanceof ASTDeclaration)
				visit((ASTDeclaration) node);
		}
		for (int i = 0; i < quats.size(); i++) {
			Quat temp = quats.get(i);
			if (temp.op == "goto") {
				int id = label.get(((ASTIdentifier) temp.res).value);
				temp.res = new ASTIntegerConstant(id, null);
			}
		}
	}

	@Override
	public void visit(ASTDeclaration declaration) throws Exception {
		for (ASTInitList x : declaration.initLists)
			visit(x);
	}

	int arr_cnt = 1;

	@Override
	public void visit(ASTArrayDeclarator arrayDeclarator) throws Exception {
		int size = ((ASTIntegerConstant) arrayDeclarator.expr).value * 4;
		arr_cnt *= size;
		if (arrayDeclarator.declarator instanceof ASTVariableDeclarator) {
			String name = arrayDeclarator.declarator.getName();
			quats.add(new Quat("new", (ASTNode) new ASTIntegerConstant(arr_cnt, 1), null,
					(ASTNode) new ASTStringConstant(name, 1)));
			arr_cnt = 1;
		} else
			visit(arrayDeclarator.declarator);
	}

	@Override
	public void visit(ASTVariableDeclarator variableDeclarator) throws Exception {
		String name = variableDeclarator.getName();
		var_list.peek().add(name);
		quats.add(new Quat("new", (ASTNode) new ASTIntegerConstant(4, 1), null,
				(ASTNode) new ASTStringConstant(name, 1)));
	}

	@Override
	public void visit(ASTFunctionDeclarator functionDeclarator) throws Exception {
		for (ASTParamsDeclarator x : functionDeclarator.params)
			visit(x);
	}

	@Override
	public void visit(ASTParamsDeclarator paramsDeclarator) throws Exception {
		visit(paramsDeclarator.declarator);
		String name = paramsDeclarator.declarator.getName();
		quats.add(new Quat("get_param", null, null, new ASTStringConstant(name, 1)));
	}

	@Override
	public void visit(ASTArrayAccess arrayAccess) throws Exception {
		String name = ((ASTIdentifier) arrayAccess.arrayName).value;
		ASTNode temp = new TemporaryValue(++temp_id);
		visit(arrayAccess.elements.get(0));
		ASTNode a = (ASTNode) map.get(arrayAccess.elements.get(0));
		quats.add(new Quat("=[]", new ASTStringConstant(name, 1), a, temp));
		map.put(arrayAccess, temp);
	}

	@Override
	public void visit(ASTBinaryExpression binaryExpression) throws Exception {
		String op = binaryExpression.op.value;
		ASTNode res = null;
		ASTNode opnd1 = null;
		ASTNode opnd2 = null;
		boolean flag = false;

		if (op.equals("=")) {
			// 赋值操作
			// 获取被赋值的对象res
			flag = true;
			// 判断源操作数类型, 为了避免出现a = b + c; 生成两个四元式：tmp1 = b + c; a = tmp1;的情况。也可以用别的方法解决
			if (binaryExpression.expr2 instanceof ASTBinaryExpression) {
				ASTBinaryExpression value = (ASTBinaryExpression) binaryExpression.expr2;
				op = value.op.value;
				visit(value.expr2);
				opnd2 = map.get(value.expr2);
				visit(value.expr1);
				opnd1 = map.get(value.expr1);
			} else {
				visit(binaryExpression.expr2);
				opnd1 = map.get(binaryExpression.expr2);
			}

			visit(binaryExpression.expr1);
			res = map.get(binaryExpression.expr1);

		} else {
			visit(binaryExpression.expr2);
			opnd2 = map.get(binaryExpression.expr2);
			visit(binaryExpression.expr1);
			opnd1 = map.get(binaryExpression.expr1);
			if (op.equals(">") || op.equals(">=") || op.equals("<") || op.equals("<=")) {
				res = new TemporaryValue(++temp_id);
			} else if (op.contains("=") && !op.equals("==")) {
				flag = true;
				op = op.substring(0, op.length() - 1);
				res = opnd1;
			} else
				res = new TemporaryValue(++temp_id);
		}
		// build quat
		Quat quat = new Quat(op, opnd1, opnd2, res);
		quats.add(quat);
		map.put(binaryExpression, res);
		if (binaryExpression.expr1 instanceof ASTArrayAccess && flag) {
			op = "[]=";
			quats.add(new Quat(op, null, null, res));
		}
	}

	@Override
	public void visit(ASTBreakStatement breakStat) throws Exception {
		quats.add(new Quat("break", null, null, null));
	}

	@Override
	public void visit(ASTContinueStatement continueStatement) throws Exception {
		quats.add(new Quat("continue", null, null, null));
	}

	@Override
	public void visit(ASTCastExpression castExpression) throws Exception {
		visit(castExpression.typename);
		visit(castExpression.expr);

	}

	@Override
	public void visit(ASTCharConstant charConst) throws Exception {
		map.put(charConst, charConst);
	}

	@Override
	public void visit(ASTCompoundStatement compoundStat) throws Exception {
		for (ASTNode node : compoundStat.blockItems) {
			if (node instanceof ASTDeclaration) {
				visit((ASTDeclaration) node);
			} else if (node instanceof ASTStatement) {
				visit((ASTStatement) node);
			}
		}
	}

	@Override
	public void visit(ASTConditionExpression conditionExpression) throws Exception {
		visit(conditionExpression.condExpr);
		for (ASTExpression x : conditionExpression.trueExpr)
			visit(x);
		visit(conditionExpression.falseExpr);
	}

	@Override
	public void visit(ASTExpression expression) throws Exception {
		if (expression instanceof ASTArrayAccess) {
			visit((ASTArrayAccess) expression);
		} else if (expression instanceof ASTBinaryExpression) {
			visit((ASTBinaryExpression) expression);
		} else if (expression instanceof ASTCastExpression) {
			visit((ASTCastExpression) expression);
		} else if (expression instanceof ASTCharConstant) {
			visit((ASTCharConstant) expression);
		} else if (expression instanceof ASTConditionExpression) {
			visit((ASTConditionExpression) expression);
		} else if (expression instanceof ASTFloatConstant) {
			visit((ASTFloatConstant) expression);
		} else if (expression instanceof ASTFunctionCall) {
			visit((ASTFunctionCall) expression);
		} else if (expression instanceof ASTIdentifier) {
			visit((ASTIdentifier) expression);
		} else if (expression instanceof ASTIntegerConstant) {
			visit((ASTIntegerConstant) expression);
		} else if (expression instanceof ASTMemberAccess) {
			visit((ASTMemberAccess) expression);
		} else if (expression instanceof ASTPostfixExpression) {
			visit((ASTPostfixExpression) expression);
		} else if (expression instanceof ASTStringConstant) {
			visit((ASTStringConstant) expression);
		} else if (expression instanceof ASTUnaryExpression) {
			visit((ASTUnaryExpression) expression);
		} else if (expression instanceof ASTUnaryTypename) {
			visit((ASTUnaryTypename) expression);
		}
	}

	@Override
	public void visit(ASTExpressionStatement expressionStat) throws Exception {
		for (ASTExpression node : expressionStat.exprs) {
			visit((ASTExpression) node);
		}
	}

	@Override
	public void visit(ASTFloatConstant floatConst) throws Exception {
		map.put(floatConst, floatConst);
	}

	@Override
	public void visit(ASTFunctionCall funcCall) throws Exception {
		for (ASTExpression x : funcCall.argList) {
			visit(x);
			ASTNode node = map.get(x);
			ASTNode temp = new TemporaryValue(++temp_id);
			quats.add(new Quat("=", node, null, temp));
			quats.add(new Quat("param", null, null, temp));
		}
		visit(funcCall.funcname);
		ASTIdentifier name = (ASTIdentifier) funcCall.funcname;
		ASTNode temp = new TemporaryValue(++temp_id);
		quats.add(new Quat("Call", null, null, name));
		quats.add(new Quat("get_return", null, null, temp));
		map.put(funcCall, temp);
	}

	@Override
	public void visit(ASTGotoStatement gotoStat) throws Exception {
		String name = gotoStat.label.value;
		quats.add(new Quat("goto", null, null, new ASTIdentifier(name, null)));
	}

	@Override
	public void visit(ASTIdentifier identifier) throws Exception {
		map.put(identifier, identifier);
	}

	@Override
	public void visit(ASTInitList init_list) throws Exception {
		visit(init_list.declarator);
		if (init_list.exprs != null) {
			String op = "=";
			ASTNode res = (ASTNode) init_list.declarator;
			ASTNode opnd1 = null;
			ASTNode opnd2 = null;
			if (init_list.exprs.size() == 1) {
				ASTExpression temp = init_list.exprs.get(0);
				if (temp instanceof ASTBinaryExpression) {
					ASTBinaryExpression value = (ASTBinaryExpression) temp;
					op = value.op.value;
					visit(value.expr1);
					opnd1 = map.get(value.expr1);
					visit(value.expr2);
					opnd2 = map.get(value.expr2);
				} else {
					visit(temp);
					ASTNode a = map.get(temp);
					opnd1 = a;
				}
				Quat quat = new Quat(op, opnd1, opnd2, res);
				quats.add(quat);
			} else if (init_list.exprs.size() > 1)
				System.out.println("init_list exps length not 1");
		}
	}

	@Override
	public void visit(ASTIntegerConstant intConst) throws Exception {
		map.put(intConst, intConst);
	}

	@Override
	public void visit(ASTIterationDeclaredStatement iterationDeclaredStat) throws Exception {
		visit(iterationDeclaredStat.init);
		int true_index = -1, nxt_index = -1, false_index = -1;
		int index = quats.size();
		for (ASTExpression x : iterationDeclaredStat.cond) {
			visit(x);
			ASTNode temp = map.get(x);
			quats.add(new Quat("jump_true", temp, null, null));
			quats.add(new Quat("jump_false", temp, null, null));
		}
		nxt_index = quats.size();
		for (ASTExpression x : iterationDeclaredStat.step)
			visit(x);
		quats.add(new Quat("jump", null, null, new ASTIntegerConstant(index, null)));

		true_index = quats.size();
		visit(iterationDeclaredStat.stat);
		quats.add(new Quat("jump", null, null, new ASTIntegerConstant(nxt_index, null)));
		false_index = quats.size();

		for (int i = index; i < quats.size(); i++) {
			String temp = quats.get(i).op;
			if (temp == "jump_true" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(true_index, null);
			else if (temp == "jump_false" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(false_index, null);
			else if (temp == "continue" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(nxt_index, null);
			else if (temp == "break" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(false_index, null);
		}
	}

	@Override
	public void visit(ASTIterationStatement iterationStat) throws Exception {
		for (ASTExpression x : iterationStat.init)
			visit(x);
		int true_index = -1, nxt_index = -1, false_index = -1;
		int index = quats.size();
		for (ASTExpression x : iterationStat.cond) {
			visit(x);
			ASTNode temp = map.get(x);
			quats.add(new Quat("jump_true", temp, null, null));
			quats.add(new Quat("jump_false", temp, null, null));
		}
		nxt_index = quats.size();
		for (ASTExpression x : iterationStat.step)
			visit(x);
		quats.add(new Quat("jump", null, null, new ASTIntegerConstant(index, null)));

		true_index = quats.size();
		visit(iterationStat.stat);
		quats.add(new Quat("jump", null, null, new ASTIntegerConstant(nxt_index, null)));
		false_index = quats.size();

		for (int i = index; i < quats.size(); i++) {
			String temp = quats.get(i).op;
			if (temp == "jump_true" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(true_index, null);
			else if (temp == "jump_false" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(false_index, null);
			else if (temp == "continue" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(nxt_index, null);
			else if (temp == "break" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(false_index, null);
		}
	}

	@Override
	public void visit(ASTLabeledStatement labeledStat) throws Exception {
		String name = labeledStat.label.value;
		label.put(name, quats.size());
		visit(labeledStat.stat);
	}

	@Override
	public void visit(ASTMemberAccess memberAccess) throws Exception {

	}

	@Override
	public void visit(ASTPostfixExpression postfixExpression) throws Exception {
		String op = postfixExpression.op.value;
		visit(postfixExpression.expr);
		ASTNode opnd1 = map.get(postfixExpression.expr);
		ASTNode res = new TemporaryValue(++temp_id);
		quats.add(new Quat("=", opnd1, null, res));
		quats.add(new Quat(op, opnd1, null, opnd1));
		map.put(postfixExpression, res);
	}

	@Override
	public void visit(ASTReturnStatement returnStat) throws Exception {
		if (returnStat.expr != null) {
			String op = "return";
			ASTNode res = null;
			ASTNode opnd1 = null;
			ASTNode opnd2 = null;
			if (returnStat.expr.size() == 1) {
				ASTExpression temp = returnStat.expr.get(0);
				if (temp instanceof ASTBinaryExpression) {
					ASTBinaryExpression value = (ASTBinaryExpression) temp;
					op = value.op.value;
					visit(value.expr1);
					opnd1 = map.get(value.expr1);
					visit(value.expr2);
					opnd2 = map.get(value.expr2);
					res = new TemporaryValue(++temp_id);
					quats.add(new Quat(op, opnd1, opnd2, res));
					opnd1 = null;
					opnd2 = null;
					op = "return";
					quats.add(new Quat(op, opnd1, opnd2, res));
					quats.add(new Quat("leave", null, null, new ASTIntegerConstant(temp_id, 0)));
				} else {
					res = (ASTNode) temp;
					ASTNode t = new TemporaryValue(++temp_id);
					Quat quat = new Quat("=", res, opnd2, t);
					quats.add(quat);
					quat = new Quat(op, opnd1, opnd2, t);
					quats.add(quat);
					quats.add(new Quat("leave", null, null, new ASTIntegerConstant(temp_id, 0)));
				}
			} else {
				System.out.println("return exps length not 1");
			}

		} else {
			quats.add(new Quat("return", null, null, null));
			quats.add(new Quat("leave", null, null, new ASTIntegerConstant(temp_id, 0)));
		}

	}

	@Override
	public void visit(ASTSelectionStatement selectionStat) throws Exception {
		int true_index = -1, nxt_index = -1, false_index = -1;
		int index = quats.size();
		for (ASTExpression x : selectionStat.cond) {
			visit(x);
			ASTNode temp = map.get(x);
			quats.add(new Quat("jump_false", temp, null, null));
		}
		visit(selectionStat.then);
		false_index = quats.size();
		quats.add(new Quat("jump", null, null, null));
		if (selectionStat.otherwise != null) {
			false_index = quats.size();
			visit(selectionStat.otherwise);
		}
		nxt_index = quats.size();
		for (int i = index; i < quats.size(); i++) {
			String temp = quats.get(i).op;
			if (temp == "jump_true" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(true_index, null);
			else if (temp == "jump_false" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(false_index, null);
			else if (temp == "jump" && quats.get(i).res == null)
				quats.get(i).res = new ASTIntegerConstant(nxt_index, null);
		}
	}

	@Override
	public void visit(ASTStringConstant stringConst) throws Exception {
		map.put(stringConst, stringConst);
	}

	@Override
	public void visit(ASTTypename typename) throws Exception {
		visit(typename.declarator);
	}

	@Override
	public void visit(ASTUnaryExpression unaryExpression) throws Exception {
		String op = unaryExpression.op.value;
		if (op.equals("++") || op.equals("--")) {
			visit(unaryExpression.expr);
			ASTNode opnd1 = map.get(unaryExpression.expr);
			quats.add(new Quat(op, opnd1, null, opnd1));
			map.put(unaryExpression, opnd1);
		} else {
			ASTNode res = new TemporaryValue(++temp_id);
			visit(unaryExpression.expr);
			ASTNode opnd1 = map.get(unaryExpression.expr);
			quats.add(new Quat(op, opnd1, null, res));
			map.put(unaryExpression, res);
		}

	}

	@Override
	public void visit(ASTUnaryTypename unaryTypename) throws Exception {
		visit(unaryTypename.typename);
	}

	@Override
	public void visit(ASTFunctionDefine functionDefine) throws Exception {
		String name = functionDefine.declarator.getName();
		int now_index = quats.size();
		quats.add(new Quat("enter", null, null, new ASTIdentifier(name, null)));
		visit(functionDefine.declarator);
		visit(functionDefine.body);
		quats.get(now_index).opnd1 = new ASTIntegerConstant(temp_id, 1);
		quats.add(new Quat("end", null, null, null));
	}

	@Override
	public void visit(ASTDeclarator declarator) throws Exception {
		if (declarator instanceof ASTVariableDeclarator)
			visit((ASTVariableDeclarator) declarator);
		else if (declarator instanceof ASTArrayDeclarator)
			visit((ASTArrayDeclarator) declarator);
		else
			visit((ASTFunctionDeclarator) declarator);
	}

	@Override
	public void visit(ASTStatement statement) throws Exception {
		var_list.add(new ArrayList<String>());
		if (statement instanceof ASTIterationDeclaredStatement) {
			visit((ASTIterationDeclaredStatement) statement);
		} else if (statement instanceof ASTIterationStatement) {
			visit((ASTIterationStatement) statement);
		} else if (statement instanceof ASTCompoundStatement) {
			visit((ASTCompoundStatement) statement);
		} else if (statement instanceof ASTSelectionStatement) {
			visit((ASTSelectionStatement) statement);
		} else if (statement instanceof ASTExpressionStatement) {
			visit((ASTExpressionStatement) statement);
		} else if (statement instanceof ASTBreakStatement) {
			visit((ASTBreakStatement) statement);
		} else if (statement instanceof ASTContinueStatement) {
			visit((ASTContinueStatement) statement);
		} else if (statement instanceof ASTReturnStatement) {
			visit((ASTReturnStatement) statement);
		} else if (statement instanceof ASTGotoStatement) {
			visit((ASTGotoStatement) statement);
		} else if (statement instanceof ASTLabeledStatement) {
			visit((ASTLabeledStatement) statement);
		}
		var_list.pop();
	}

	@Override
	public void visit(ASTToken token) throws Exception {
		// TODO Auto-generated method stub

	}

}
