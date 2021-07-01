package bit.minisys.minicc.semantic;

import java.beans.Expression;
import java.util.*;

import bit.minisys.minicc.internal.ir.v;
import bit.minisys.minicc.internal.ir.x;
import bit.minisys.minicc.parser.ast.*;

public class semantic_builder implements ASTVisitor {

    private Map<ASTNode, ASTNode> map = new HashMap<ASTNode, ASTNode>(); // 使用map存储子节点的返回值，key对应子节点，value对应返回值，value目前类别包括ASTIdentifier,ASTIntegerConstant,TemportaryValue...

    private int level = 0;

    private List<Map<String, symbol>> symbol_list = new ArrayList<Map<String, symbol>>();
    private Map<String, symbol> func_list = new HashMap<String, symbol>();
    boolean is_defining = false, is_defined = false;
    String all_spec = "", now_func_name = "";

    private Stack<Boolean> while_list = new Stack<Boolean>();
    private Stack<Boolean> declare = new Stack<Boolean>();

    @Override
    public void visit(ASTCompilationUnit program) throws Exception {
        symbol_list.add(new HashMap<String, symbol>());
        for (ASTNode node : program.items) {
            // System.out.println(node.getType());
            if (node instanceof ASTFunctionDefine)
                visit((ASTFunctionDefine) node);
            else if (node instanceof ASTDeclaration)
                visit((ASTDeclaration) node);
        }
    }

    @Override
    public void visit(ASTDeclaration declaration) throws Exception {
        all_spec = "";
        for (ASTToken x : declaration.specifiers) {
            all_spec = all_spec + x.value + ' ';
        }
        all_spec = all_spec.substring(0, all_spec.length() - 1);
        for (ASTInitList x : declaration.initLists) {
            visit(x);
            ASTInitList init = (ASTInitList) map.get(x);
            ASTDeclarator key = init.declarator;
            String type = key.getType();
            String name = key.getName();
            if (type == "VariableDeclarator") {
                if (symbol_list.get(level).containsKey(name)) {
                    System.out.println("ES2 >> Variable: " + name + " is declared.");
                } else {
                    symbol temp = new symbol(all_spec, type);
                    symbol_list.get(level).put(name, temp);
                }
            } else if (type == "ArrayDeclarator") {
                if (symbol_list.get(level).containsKey(name)) {
                    System.out.println("ES2 >> Array: " + name + " is declared.");
                } else {
                    symbol temp = new symbol(all_spec, type);
                    ASTDeclarator now = key;
                    Stack<Integer> sta = new Stack<Integer>();
                    while (now.getType() != "VariableDeclarator") {
                        sta.push(((ASTIntegerConstant) ((ASTArrayDeclarator) now).expr).value);
                        now = ((ASTArrayDeclarator) now).declarator;
                    }
                    while (!sta.empty())
                        temp.value.add(sta.pop());
                    symbol_list.get(level).put(name, temp);
                }
            } else {
                visit((ASTFunctionDeclarator) key);
            }
        }
    }

    @Override
    public void visit(ASTArrayDeclarator arrayDeclarator) throws Exception {
        visit(arrayDeclarator.declarator);
        visit(arrayDeclarator.expr);
    }

    @Override
    public void visit(ASTVariableDeclarator variableDeclarator) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void visit(ASTFunctionDeclarator functionDeclarator) throws Exception {
        String name = functionDeclarator.getName();
        if (func_list.containsKey(name)) {
            if (!is_defining)
                System.out.println("ES2 >> Function: " + name + " is declared.");
        } else {
            symbol temp = new symbol(all_spec, "FunctionDeclarator");
            List<ASTParamsDeclarator> pram_list = functionDeclarator.params;
            for (ASTParamsDeclarator y : pram_list) {
                String temp_spec = "";
                for (ASTToken z : y.specfiers)
                    temp_spec = temp_spec + z.value + ' ';
                temp_spec = temp_spec.substring(0, temp_spec.length() - 1);
                temp.parm.add(temp_spec);
                String var_name = ((ASTVariableDeclarator) y.declarator).getName();
                symbol var_temp = new symbol(temp_spec, "VariableDeclarator");
                symbol_list.get(level).put(var_name, var_temp);
            }
            func_list.put(name, temp);
        }
    }

    @Override
    public void visit(ASTParamsDeclarator paramsDeclarator) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(ASTArrayAccess arrayAccess) throws Exception {
        visit(arrayAccess.arrayName);
        for (ASTExpression x : arrayAccess.elements)
            visit(x);
    }

    @Override
    public void visit(ASTBinaryExpression binaryExpression) throws Exception {
        visit(binaryExpression.expr1);
        visit(binaryExpression.expr2);
    }

    @Override
    public void visit(ASTBreakStatement breakStat) throws Exception {
        if (while_list.empty())
            System.out.println("ES3 >> break not in loop");
    }

    @Override
    public void visit(ASTContinueStatement continueStatement) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(ASTCastExpression castExpression) throws Exception {
        visit(castExpression.typename);
        visit(castExpression.expr);
    }

    @Override
    public void visit(ASTCharConstant charConst) throws Exception {
        // TODO Auto-generated method stub

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
        declare.add(false);
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
        declare.pop();
    }

    @Override
    public void visit(ASTExpressionStatement expressionStat) throws Exception {
        for (ASTExpression node : expressionStat.exprs) {
            visit((ASTExpression) node);
        }
    }

    @Override
    public void visit(ASTFloatConstant floatConst) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(ASTFunctionCall funcCall) throws Exception {
        String name = ((ASTIdentifier) funcCall.funcname).value;
        if (!func_list.containsKey(name))
            System.out.println("ES1 >> func: " + name + " not defined.");
        for (ASTExpression x : funcCall.argList)
            visit(x);
    }

    @Override
    public void visit(ASTGotoStatement gotoStat) throws Exception {
        // TODO Auto-generated method stub

    }

    private boolean is_in_list(String name) {
        for (int i = level; i >= 0; i--) {
            if (symbol_list.get(i).containsKey(name))
                return true;
        }
        return false;
    }

    @Override
    public void visit(ASTIdentifier identifier) throws Exception {
        if (!declare.peek() && !is_in_list(identifier.value)) {
            is_defined = false;
            System.out.println("ES1 >> var: " + identifier.value + " not defined.");
        }
    }

    @Override
    public void visit(ASTInitList initList) throws Exception {
        if (initList.exprs != null)
            for (ASTExpression x : initList.exprs)
                visit(x);
        map.put(initList, initList);
    }

    @Override
    public void visit(ASTIntegerConstant intConst) throws Exception {
        map.put(intConst, intConst);
    }

    @Override
    public void visit(ASTIterationDeclaredStatement iterationDeclaredStat) throws Exception {
        visit(iterationDeclaredStat.init);
        for (ASTExpression x : iterationDeclaredStat.cond)
            visit(x);
        for (ASTExpression x : iterationDeclaredStat.step)
            visit(x);
        visit(iterationDeclaredStat.stat);
    }

    @Override
    public void visit(ASTIterationStatement iterationStat) throws Exception {
        for (ASTExpression x : iterationStat.init)
            visit(x);
        for (ASTExpression x : iterationStat.cond)
            visit(x);
        for (ASTExpression x : iterationStat.step)
            visit(x);
        visit(iterationStat.stat);
    }

    @Override
    public void visit(ASTLabeledStatement labeledStat) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void visit(ASTMemberAccess memberAccess) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(ASTPostfixExpression postfixExpression) throws Exception {
        visit(postfixExpression.expr);
    }

    @Override
    public void visit(ASTReturnStatement returnStat) throws Exception {
        func_list.get(now_func_name).is_return = true;
        if (returnStat.expr != null)
            for (ASTExpression x : returnStat.expr)
                visit(x);
    }

    @Override
    public void visit(ASTSelectionStatement selectionStat) throws Exception {
        for (ASTExpression x : selectionStat.cond)
            visit(x);
        visit(selectionStat.then);
        visit(selectionStat.otherwise);
    }

    @Override
    public void visit(ASTStringConstant stringConst) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void visit(ASTTypename typename) throws Exception {
        visit(typename.declarator);
    }

    @Override
    public void visit(ASTUnaryExpression unaryExpression) throws Exception {
        visit(unaryExpression.expr);
    }

    @Override
    public void visit(ASTUnaryTypename unaryTypename) throws Exception {
        visit(unaryTypename.typename);
    }

    @Override
    public void visit(ASTFunctionDefine functionDefine) throws Exception {
        is_defining = true;
        visit((ASTFunctionDeclarator) functionDefine.declarator);
        is_defining = false;
        String name = functionDefine.declarator.getName();
        if (func_list.get(name).is_define) {
            System.out.println("ES2 >> Function: " + name + " is defined.");
        } else {
            func_list.get(name).is_define = true;
        }
        now_func_name = name;
        level++;
        symbol_list.add(new HashMap<String, symbol>());
        visit(functionDefine.body);
        symbol_list.remove(level);
        level--;

        if (!func_list.get(name).is_return)
            System.out.println("ES8 >> Function:" + name + " lack of return");
    }

    @Override
    public void visit(ASTDeclarator declarator) throws Exception {
        declare.add(true);
        if (declarator instanceof ASTVariableDeclarator)
            visit((ASTVariableDeclarator) declarator);
        else if (declarator instanceof ASTArrayDeclarator)
            visit((ASTArrayDeclarator) declarator);
        declare.pop();
    }

    @Override
    public void visit(ASTStatement statement) throws Exception {
        level++;
        symbol_list.add(new HashMap<String, symbol>());
        if (statement instanceof ASTIterationDeclaredStatement) {
            while_list.add(true);
            visit((ASTIterationDeclaredStatement) statement);
            while_list.pop();
        } else if (statement instanceof ASTIterationStatement) {
            while_list.add(true);
            visit((ASTIterationStatement) statement);
            while_list.pop();
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
        symbol_list.remove(level);
        level--;
    }

    @Override
    public void visit(ASTToken token) throws Exception {
        map.put(token, token);
    }

}
