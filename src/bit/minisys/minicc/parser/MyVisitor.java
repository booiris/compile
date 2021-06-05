package bit.minisys.minicc.parser;

import bit.minisys.minicc.parser.ast.*;

import java.util.*;

public class MyVisitor extends cBaseVisitor<ASTNode> {
    public Stack<List<ASTExpression>> sta = new Stack<>();
    public Stack<List<ASTToken>> token_sta = new Stack<>();
    public ASTCompilationUnit.Builder base_build = new ASTCompilationUnit.Builder();

    @Override
    public ASTNode visitCompilationUnit(cParser.CompilationUnitContext ctx) {
        if (ctx.compilationUnit() == null) {
            base_build.addNode((ASTNode) visit(ctx.externalDeclaration()));
            Collections.reverse(base_build.items);
            return base_build.build();
        } else {
            base_build.addNode((ASTNode) visit(ctx.externalDeclaration()));
            return (ASTNode) visit(ctx.compilationUnit());
        }
    }

    @Override
    public ASTNode visitExternalDeclaration(cParser.ExternalDeclarationContext ctx) {
        if (ctx.functionDefinition() != null) {
            return (ASTFunctionDefine) visit(ctx.functionDefinition());
        } else {
            return (ASTDeclaration) visit(ctx.declaration());
        }
    }

    @Override
    public ASTNode visitFunctionDefinition(cParser.FunctionDefinitionContext ctx) {
        token_sta.push(new ArrayList<>());
        visit(ctx.declaration_specifiers());
        List<ASTToken> token = token_sta.pop();
        ASTDeclarator declarator = (ASTDeclarator) visit(ctx.declarator());
        ASTCompoundStatement bodyStatement = (ASTCompoundStatement) visit(ctx.compound_statement());
        return new ASTFunctionDefine(token, declarator, bodyStatement);
    }

    @Override
    public ASTNode visitA0(cParser.A0Context ctx) {
        String id = ctx.Identifier().getText();
        int num = ctx.Identifier().getSymbol().getTokenIndex();
        return new ASTIdentifier(id, num);
    }

    @Override
    public ASTNode visitA1(cParser.A1Context ctx) {
        String temp = ctx.Constant().getText();
        int num = ctx.Constant().getSymbol().getTokenIndex();
        boolean flag = true;
        try {
            Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            flag = false;
        }
        if (flag)
            return new ASTIntegerConstant(Integer.parseInt(temp), num);
        flag = true;
        try {
            Float.parseFloat(temp);
        } catch (NumberFormatException e) {
            flag = false;
        }
        if (flag)
            return new ASTFloatConstant((double) Float.parseFloat(temp), num);
        else
            return new ASTCharConstant(temp, num);
    }

    @Override
    public ASTNode visitA2(cParser.A2Context ctx) {
        String v = ctx.StringLiteral().getText();
        int num = ctx.StringLiteral().getSymbol().getTokenIndex();
        return new ASTStringConstant(v, num);
    }

    @Override
    public ASTNode visitA3(cParser.A3Context ctx) {
        return (ASTExpression) visit(ctx.assignment_expression());
    }

    public Stack<ASTArrayAccess.Builder> arr_build = new Stack<>();

    Boolean flag = false;

    @Override
    public ASTNode visitA4(cParser.A4Context ctx) {
        ASTExpression exp = (ASTExpression) visit(ctx.primary_expression());
        return exp;
    }

    @Override
    public ASTNode visitA5(cParser.A5Context ctx) {
        ASTArrayAccess.Builder temp = new ASTArrayAccess.Builder();
        ASTExpression exp = (ASTExpression) visit(ctx.postfix_expression());
        temp.setArrayName(exp);

        sta.push(new ArrayList<>());

        visit(ctx.expression());

        List<ASTExpression> arr = sta.pop();
        temp.addElement(arr);
        return temp.build();
    }

    @Override
    public ASTNode visitA6(cParser.A6Context ctx) {
        ASTExpression master = (ASTExpression) visit(ctx.postfix_expression());
        String v = ctx.op.getText();
        int num = ctx.op.getTokenIndex();
        ASTToken op = new ASTToken(v, num);
        v = ctx.Identifier().getText();
        num = ctx.Identifier().getSymbol().getTokenIndex();
        ASTIdentifier member = new ASTIdentifier(v, num);
        return new ASTMemberAccess(master, op, member);
    }

    Stack<ASTFunctionCall.Builder> fc_builder = new Stack<>();

    @Override
    public ASTNode visitA7(cParser.A7Context ctx) {
        ASTExpression exp = (ASTExpression) visit(ctx.postfix_expression());
        String v = ctx.op.getText();
        int num = ctx.op.getTokenIndex();
        ASTToken op = new ASTToken(v, num);
        return new ASTPostfixExpression(exp, op);
    }

    @Override
    public ASTNode visitA13(cParser.A13Context ctx) {
        fc_builder.push(new ASTFunctionCall.Builder());
        ASTExpression name = (ASTExpression) visit(ctx.postfix_expression());
        if (ctx.argument_expression_list() != null)
            visit(ctx.argument_expression_list());
        ASTFunctionCall.Builder temp = fc_builder.pop();
        temp.setName(name);
        return temp.build();
    }

    @Override
    public ASTNode visitArgument_expression_list(cParser.Argument_expression_listContext ctx) {
        if (ctx.argument_expression_list() == null) {
            ASTExpression exp = (ASTExpression) visit(ctx.assignment_expression());
            ASTFunctionCall.Builder temp = fc_builder.pop();
            temp.addArg(exp);
            fc_builder.push(temp);
            return null;
        } else {
            visit(ctx.argument_expression_list());
            ASTExpression exp = (ASTExpression) visit(ctx.assignment_expression());
            ASTFunctionCall.Builder temp = fc_builder.pop();
            temp.addArg(exp);
            fc_builder.push(temp);
            return null;
        }
    }

    @Override
    public ASTNode visitA8(cParser.A8Context ctx) {
        return (ASTExpression) visit(ctx.postfix_expression());
    }

    @Override
    public ASTNode visitA9(cParser.A9Context ctx) {
        String v = ctx.op.getText();
        int num = ctx.op.getTokenIndex();
        ASTToken op = new ASTToken(v, num);
        ASTExpression expr;
        if (ctx.unary_expression() != null)
            expr = (ASTExpression) visit(ctx.unary_expression());
        else
            expr = (ASTExpression) visit(ctx.cast_expression());
        return new ASTUnaryExpression(op, expr);
    }

    @Override
    public ASTNode visitA10(cParser.A10Context ctx) {
        String v = ctx.Sizeof().getText();
        int num = ctx.Sizeof().getSymbol().getTokenIndex();
        ASTToken op = new ASTToken(v, num);
        ASTTypename typename = (ASTTypename) visit(ctx.type_name());
        return new ASTUnaryTypename(op, typename);
    }

    @Override
    public ASTNode visitCast_expression(cParser.Cast_expressionContext ctx) {
        if (ctx.unary_expression() != null) {
            return (ASTExpression) visit(ctx.unary_expression());
        } else {
            ASTTypename typename = (ASTTypename) visit(ctx.type_name());
            ;
            ASTExpression expr = (ASTExpression) visit(ctx.cast_expression());
            return new ASTCastExpression(typename, expr);
        }
    }

    @Override
    public ASTNode visitMultiplicative_expression(cParser.Multiplicative_expressionContext ctx) {
        if (ctx.multiplicative_expression() == null) {
            return (ASTExpression) visit(ctx.cast_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.multiplicative_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.cast_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitAdditive_expression(cParser.Additive_expressionContext ctx) {
        if (ctx.additive_expression() == null) {
            return (ASTExpression) visit(ctx.multiplicative_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.additive_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.multiplicative_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitShift_expression(cParser.Shift_expressionContext ctx) {
        if (ctx.shift_expression() == null) {
            return (ASTExpression) visit(ctx.additive_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.shift_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.additive_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitRelational_expression(cParser.Relational_expressionContext ctx) {
        if (ctx.relational_expression() == null) {
            return (ASTExpression) visit(ctx.shift_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.relational_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.shift_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitEquality_expression(cParser.Equality_expressionContext ctx) {
        if (ctx.equality_expression() == null) {
            return (ASTExpression) visit(ctx.relational_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.equality_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.relational_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitLogical_AND_expression(cParser.Logical_AND_expressionContext ctx) {
        if (ctx.logical_AND_expression() == null) {
            return (ASTExpression) visit(ctx.equality_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.logical_AND_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.equality_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitLogical_OR_expression(cParser.Logical_OR_expressionContext ctx) {
        if (ctx.logical_OR_expression() == null) {
            return (ASTExpression) visit(ctx.logical_AND_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.logical_OR_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.logical_AND_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitConditional_expression(cParser.Conditional_expressionContext ctx) {
        if (ctx.conditional_expression() == null) {
            return (ASTExpression) visit(ctx.logical_OR_expression());
        } else {
            ASTExpression cond = (ASTExpression) visit(ctx.logical_OR_expression());
            sta.push(new ArrayList<>());

            visit(ctx.expression());

            List<ASTExpression> arr = sta.pop();
            ASTExpression falseExpr = (ASTExpression) visit(ctx.conditional_expression());
            LinkedList<ASTExpression> linklist = new LinkedList<>();
            for (ASTExpression x : arr) {
                linklist.add(x);
            }
            return new ASTConditionExpression(cond, linklist, falseExpr);
        }
    }

    @Override
    public ASTNode visitAssignment_expression(cParser.Assignment_expressionContext ctx) {
        if (ctx.conditional_expression() != null) {
            return (ASTExpression) visit(ctx.conditional_expression());
        } else {
            ASTExpression expr1 = (ASTExpression) visit(ctx.unary_expression());
            String v = ctx.op.getText();
            int num = ctx.op.getTokenIndex();
            ASTToken op = new ASTToken(v, num);
            ASTExpression expr2 = (ASTExpression) visit(ctx.assignment_expression());
            return new ASTBinaryExpression(op, expr1, expr2);
        }
    }

    @Override
    public ASTNode visitExpression(cParser.ExpressionContext ctx) {
        if (ctx.expression() == null) {
            ASTExpression expr = (ASTExpression) visit(ctx.assignment_expression());
            if (!sta.empty()) {
                List<ASTExpression> arr = sta.pop();
                arr.add(expr);
                sta.push(arr);
            }
            return expr;
        } else {
            visit(ctx.expression());
            ASTExpression expr = (ASTExpression) visit(ctx.assignment_expression());
            if (!sta.empty()) {
                List<ASTExpression> arr = sta.pop();
                arr.add(expr);
                sta.push(arr);
            }
            return expr;
        }
    }

    @Override
    public ASTNode visitConstant_expression(cParser.Constant_expressionContext ctx) {
        return (ASTExpression) visit(ctx.conditional_expression());
    }

    Stack<ASTDeclaration.Builder> de_build = new Stack<>();

    @Override
    public ASTNode visitDeclaration(cParser.DeclarationContext ctx) {
        de_build.push(new ASTDeclaration.Builder());
        token_sta.push(new ArrayList<>());
        visit(ctx.declaration_specifiers());
        List<ASTToken> token = token_sta.pop();
        if (ctx.init_declaration_list() != null)
            visit(ctx.init_declaration_list());
        ASTDeclaration.Builder temp = de_build.pop();
        temp.addSpecfiers(token);
        Collections.reverse(temp.initLists);
        return temp.build();
    }

    @Override
    public ASTNode visitDeclaration_specifiers(cParser.Declaration_specifiersContext ctx) {
        if (ctx.storage_class_specifier() != null) {
            ASTToken op = (ASTToken) visit(ctx.storage_class_specifier());
            List<ASTToken> token = token_sta.pop();
            token.add(op);
            token_sta.push(token);
        } else {
            ASTToken op = (ASTToken) visit(ctx.type_specifier());
            List<ASTToken> token = token_sta.pop();
            token.add(op);
            token_sta.push(token);
        }
        if (ctx.declaration_specifiers() != null)
            visit(ctx.declaration_specifiers());
        return null;
    }

    @Override
    public ASTNode visitStorage_class_specifier(cParser.Storage_class_specifierContext ctx) {
        String v;
        int num;
        if (ctx.Typedef() != null) {
            v = ctx.Typedef().getText();
            num = ctx.Typedef().getSymbol().getTokenIndex();
        } else if (ctx.Extern() != null) {
            v = ctx.Extern().getText();
            num = ctx.Extern().getSymbol().getTokenIndex();
        } else if (ctx.Static() != null) {
            v = ctx.Static().getText();
            num = ctx.Static().getSymbol().getTokenIndex();
        } else if (ctx.Auto() != null) {
            v = ctx.Auto().getText();
            num = ctx.Auto().getSymbol().getTokenIndex();
        } else if (ctx.Register() != null) {
            v = ctx.Register().getText();
            num = ctx.Register().getSymbol().getTokenIndex();
        } else {
            return null;
        }
        return new ASTToken(v, num);
    }

    @Override
    public ASTNode visitType_specifier(cParser.Type_specifierContext ctx) {
        String v;
        int num;
        if (ctx.Void() != null) {
            v = ctx.Void().getText();
            num = ctx.Void().getSymbol().getTokenIndex();
        } else if (ctx.Char() != null) {
            v = ctx.Char().getText();
            num = ctx.Char().getSymbol().getTokenIndex();
        } else if (ctx.Short() != null) {
            v = ctx.Short().getText();
            num = ctx.Short().getSymbol().getTokenIndex();
        } else if (ctx.Int() != null) {
            v = ctx.Int().getText();
            num = ctx.Int().getSymbol().getTokenIndex();
        } else if (ctx.Long() != null) {
            v = ctx.Long().getText();
            num = ctx.Long().getSymbol().getTokenIndex();
        } else if (ctx.Float() != null) {
            v = ctx.Float().getText();
            num = ctx.Float().getSymbol().getTokenIndex();
        } else if (ctx.Double() != null) {
            v = ctx.Double().getText();
            num = ctx.Double().getSymbol().getTokenIndex();
        } else if (ctx.Signed() != null) {
            v = ctx.Signed().getText();
            num = ctx.Signed().getSymbol().getTokenIndex();
        } else if (ctx.Unsigned() != null) {
            v = ctx.Unsigned().getText();
            num = ctx.Unsigned().getSymbol().getTokenIndex();
        } else if (ctx.Identifier() != null) {
            v = ctx.Identifier().getText();
            num = ctx.Identifier().getSymbol().getTokenIndex();
        } else {
            return null;
        }
        return new ASTToken(v, num);
    }

    @Override
    public ASTNode visitInit_declaration_list(cParser.Init_declaration_listContext ctx) {
        if (ctx.init_declaration_list() == null) {
            ASTDeclaration.Builder temp = de_build.pop();
            temp.addInitList((ASTInitList) visit(ctx.init_declarator()));
            de_build.push(temp);
            return null;
        } else {
            ASTDeclaration.Builder temp = de_build.pop();
            temp.addInitList((ASTInitList) visit(ctx.init_declarator()));
            de_build.push(temp);
            visit(ctx.init_declaration_list());
        }
        return null;
    }

    Stack<ASTInitList.Builder> init_build = new Stack<>();

    @Override
    public ASTNode visitInit_declarator(cParser.Init_declaratorContext ctx) {
        if (ctx.initilizer() == null) {
            return new ASTInitList((ASTDeclarator) visit(ctx.declarator()), null);
        } else {
            sta.push(new ArrayList<>());
            init_build.push(new ASTInitList.Builder());
            visit(ctx.initilizer());
            ASTInitList.Builder temp = init_build.pop();
            temp.setDeclarator((ASTDeclarator) visit(ctx.declarator()));
            return temp.build();
        }
    }

    @Override
    public ASTNode visitInitilizer(cParser.InitilizerContext ctx) {
        if (ctx.assignment_expression() != null) {
            ASTExpression exp = (ASTExpression) visit(ctx.assignment_expression());
            ASTInitList.Builder temp = init_build.pop();
            temp.addInitialize(exp);
            init_build.push(temp);
            return null;
        } else {
            visit(ctx.initilizer_list());
            return null;
        }
    }

    @Override
    public ASTNode visitInitilizer_list(cParser.Initilizer_listContext ctx) {
        if (ctx.initilizer_list() == null) {
            visit(ctx.initilizer());
            return null;
        } else {
            visit(ctx.initilizer_list());
            visit(ctx.initilizer());
            return null;
        }
    }

    Stack<List<ASTParamsDeclarator>> fun_def = new Stack<>();

    @Override
    public ASTNode visitDeclarator(cParser.DeclaratorContext ctx) {
        if (ctx.Identifier() != null) {
            String v = ctx.Identifier().getText();
            int num = ctx.Identifier().getSymbol().getTokenIndex();
            ASTIdentifier id = new ASTIdentifier(v, num);
            return new ASTVariableDeclarator(id);
        } else if (ctx.LeftBracket() != null) {
            ASTDeclarator declarator = (ASTDeclarator) visit(ctx.declarator());
            ASTExpression expressions = null;
            if (ctx.assignment_expression() != null)
                expressions = (ASTExpression) visit(ctx.assignment_expression());
            return new ASTArrayDeclarator(declarator, expressions);
        } else {

            ASTDeclarator declarator = (ASTDeclarator) visit(ctx.declarator());
            fun_def.push(new ArrayList<>());
            if (ctx.parameter_list() != null)
                visit(ctx.parameter_list());
            List<ASTParamsDeclarator> temp = fun_def.pop();
            return new ASTFunctionDeclarator(declarator, temp);
        }
    }

    @Override
    public ASTNode visitParameter_list(cParser.Parameter_listContext ctx) {
        if (ctx.parameter_list() == null) {
            List<ASTParamsDeclarator> temp = fun_def.pop();
            temp.add((ASTParamsDeclarator) visit(ctx.parameter_declaration()));
            fun_def.push(temp);
            return null;
        } else {
            visit(ctx.parameter_list());
            List<ASTParamsDeclarator> temp = fun_def.pop();
            temp.add((ASTParamsDeclarator) visit(ctx.parameter_declaration()));
            fun_def.push(temp);
            return null;
        }
    }

    @Override
    public ASTNode visitParameter_declaration(cParser.Parameter_declarationContext ctx) {
        token_sta.push(new ArrayList<>());
        visit(ctx.declaration_specifiers());
        List<ASTToken> token = token_sta.pop();
        ASTDeclarator declarator = (ASTDeclarator) visit(ctx.declarator());
        return new ASTParamsDeclarator(token, declarator);
    }

    @Override
    public ASTNode visitType_name(cParser.Type_nameContext ctx) {
        token_sta.push(new ArrayList<>());
        visit(ctx.declaration_specifiers());
        List<ASTToken> token = token_sta.pop();
        return new ASTTypename(token, null);
    }

    @Override
    public ASTNode visitA20(cParser.A20Context ctx) {
        return (ASTCompoundStatement) visit(ctx.compound_statement());
    }

    @Override
    public ASTNode visitA21(cParser.A21Context ctx) {
        return (ASTExpressionStatement) visit(ctx.expression_statement());
    }

    @Override
    public ASTNode visitA22(cParser.A22Context ctx) {
        return (ASTSelectionStatement) visit(ctx.selection_statement());
    }

    @Override
    public ASTNode visitA23(cParser.A23Context ctx) {
        sta.push(new ArrayList<>());

        if (ctx.exp1 != null)
            visit(ctx.exp1);

        List<ASTExpression> arr = sta.pop();
        LinkedList<ASTExpression> lk1 = new LinkedList<>();
        for (ASTExpression x : arr) {
            lk1.add(x);
        }

        sta.push(new ArrayList<>());

        if (ctx.exp2 != null)
            visit(ctx.exp2);

        arr = sta.pop();
        LinkedList<ASTExpression> lk2 = new LinkedList<>();
        for (ASTExpression x : arr) {
            lk2.add(x);
        }

        sta.push(new ArrayList<>());

        if (ctx.exp3 != null)
            visit(ctx.exp3);

        arr = sta.pop();
        LinkedList<ASTExpression> lk3 = new LinkedList<>();
        for (ASTExpression x : arr) {
            lk3.add(x);
        }

        ASTStatement statment = (ASTStatement) visit(ctx.statement());

        return new ASTIterationStatement(lk1, lk2, lk3, statment);
    }

    @Override
    public ASTNode visitA24(cParser.A24Context ctx) {
        ASTDeclaration decl = (ASTDeclaration) visit(ctx.declaration());
        sta.push(new ArrayList<>());

        if (ctx.exp1 != null)
            visit(ctx.exp1);

        List<ASTExpression> arr = sta.pop();
        LinkedList<ASTExpression> lk1 = new LinkedList<>();
        for (ASTExpression x : arr) {
            lk1.add(x);
        }

        sta.push(new ArrayList<>());

        if (ctx.exp2 != null)
            visit(ctx.exp2);

        arr = sta.pop();
        LinkedList<ASTExpression> lk2 = new LinkedList<>();
        for (ASTExpression x : arr) {
            lk2.add(x);
        }
        ASTStatement statment = (ASTStatement) visit(ctx.statement());
        return new ASTIterationDeclaredStatement(decl, lk1, lk2, statment);
    }

    @Override
    public ASTNode visitA25(cParser.A25Context ctx) {
        return (ASTStatement) visit(ctx.jump_statement());
    }

    public ASTNode visitA26(cParser.A26Context ctx) {
        return (ASTLabeledStatement) visit(ctx.label_statement());
    }

    public ASTNode visitLabel_statement(cParser.Label_statementContext ctx) {
        String v = ctx.Identifier().getText();
        int num = ctx.Identifier().getSymbol().getTokenIndex();
        ASTIdentifier id = new ASTIdentifier(v, num);
        ASTStatement  state = (ASTStatement)visit(ctx.statement());
        return new ASTLabeledStatement(id,state);
    }

    Stack<List<ASTNode>> block_item = new Stack<>();

    @Override
    public ASTNode visitCompound_statement(cParser.Compound_statementContext ctx) {
        block_item.push(new ArrayList<>());
        if (ctx.block_item_list() != null)
            visit(ctx.block_item_list());
        List<ASTNode> temp = block_item.pop();
        return new ASTCompoundStatement(temp);
    }

    @Override
    public ASTNode visitBlock_item_list(cParser.Block_item_listContext ctx) {
        if (ctx.block_item_list() == null) {
            List<ASTNode> temp = block_item.pop();
            temp.add((ASTNode) visit(ctx.block_item()));
            block_item.push(temp);
            return null;
        } else {
            visit(ctx.block_item_list());
            List<ASTNode> temp = block_item.pop();
            temp.add((ASTNode) visit(ctx.block_item()));
            block_item.push(temp);
            return null;
        }
    }

    @Override
    public ASTNode visitBlock_item(cParser.Block_itemContext ctx) {
        if (ctx.declaration() != null) {
            return (ASTDeclaration) visit(ctx.declaration());
        } else {
            return (ASTStatement) visit(ctx.statement());
        }
    }

    @Override
    public ASTNode visitExpression_statement(cParser.Expression_statementContext ctx) {
        sta.push(new ArrayList<>());

        if (ctx.expression() != null)
            visit(ctx.expression());

        List<ASTExpression> arr = sta.pop();
        return new ASTExpressionStatement(arr);
    }

    @Override
    public ASTNode visitSelection_statement(cParser.Selection_statementContext ctx) {
        sta.push(new ArrayList<>());

        visit(ctx.expression());

        List<ASTExpression> arr = sta.pop();
        LinkedList<ASTExpression> linklist = new LinkedList<>();
        for (ASTExpression x : arr) {
            linklist.add(x);
        }
        ASTStatement then = (ASTStatement) visit(ctx.statement(0));
        ASTStatement Else = null;
        if (ctx.Else() != null) {
            Else = (ASTStatement) visit(ctx.statement(1));
        }
        return new ASTSelectionStatement(linklist, then, Else);
    }

    @Override
    public ASTNode visitJump_statement(cParser.Jump_statementContext ctx) {
        if (ctx.Continue() != null) {
            return new ASTContinueStatement();
        } else if (ctx.Break() != null) {
            return new ASTBreakStatement();
        } else if (ctx.Goto() != null) {
            String v = ctx.Identifier().getText();
            int num = ctx.Identifier().getSymbol().getTokenIndex();
            ASTIdentifier label = new ASTIdentifier(v, num);
            return new ASTGotoStatement(label);
        } else if (ctx.Return() != null) {
            sta.push(new ArrayList<>());

            if (ctx.expression() != null)
                visit(ctx.expression());

            List<ASTExpression> arr = sta.pop();
            LinkedList<ASTExpression> linklist = new LinkedList<>();
            for (ASTExpression x : arr) {
                linklist.add(x);
            }
            return new ASTReturnStatement(linklist);
        } else {
            return null;
        }
    }
}
