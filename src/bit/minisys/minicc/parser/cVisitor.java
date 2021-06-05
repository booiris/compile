// Generated from c.g4 by ANTLR 4.8
package bit.minisys.minicc.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link cParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface cVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link cParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(cParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#externalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalDeclaration(cParser.ExternalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(cParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code a0}
	 * labeled alternative in {@link cParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA0(cParser.A0Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a1}
	 * labeled alternative in {@link cParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA1(cParser.A1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a2}
	 * labeled alternative in {@link cParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA2(cParser.A2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a3}
	 * labeled alternative in {@link cParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA3(cParser.A3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a13}
	 * labeled alternative in {@link cParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA13(cParser.A13Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a4}
	 * labeled alternative in {@link cParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA4(cParser.A4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a5}
	 * labeled alternative in {@link cParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA5(cParser.A5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a6}
	 * labeled alternative in {@link cParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA6(cParser.A6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a7}
	 * labeled alternative in {@link cParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA7(cParser.A7Context ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#argument_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_expression_list(cParser.Argument_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code a8}
	 * labeled alternative in {@link cParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA8(cParser.A8Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a9}
	 * labeled alternative in {@link cParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA9(cParser.A9Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a10}
	 * labeled alternative in {@link cParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA10(cParser.A10Context ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#cast_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast_expression(cParser.Cast_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(cParser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expression(cParser.Additive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expression(cParser.Shift_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(cParser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(cParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#logical_AND_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_AND_expression(cParser.Logical_AND_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#logical_OR_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_OR_expression(cParser.Logical_OR_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expression(cParser.Conditional_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expression(cParser.Assignment_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(cParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_expression(cParser.Constant_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(cParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#declaration_specifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_specifiers(cParser.Declaration_specifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#storage_class_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorage_class_specifier(cParser.Storage_class_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#type_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_specifier(cParser.Type_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#init_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declaration_list(cParser.Init_declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#init_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declarator(cParser.Init_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(cParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(cParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration(cParser.Parameter_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#type_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_name(cParser.Type_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#initilizer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitilizer(cParser.InitilizerContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#initilizer_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitilizer_list(cParser.Initilizer_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code a20}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA20(cParser.A20Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a21}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA21(cParser.A21Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a22}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA22(cParser.A22Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a23}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA23(cParser.A23Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a24}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA24(cParser.A24Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a25}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA25(cParser.A25Context ctx);
	/**
	 * Visit a parse tree produced by the {@code a26}
	 * labeled alternative in {@link cParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA26(cParser.A26Context ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#label_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel_statement(cParser.Label_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement(cParser.Compound_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#block_item_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item_list(cParser.Block_item_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#block_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item(cParser.Block_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(cParser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#selection_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_statement(cParser.Selection_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link cParser#jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement(cParser.Jump_statementContext ctx);
}