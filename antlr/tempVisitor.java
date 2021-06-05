// Generated from temp.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tempParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tempVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tempParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(tempParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#externalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalDeclaration(tempParser.ExternalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#functionDeﬁnition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeﬁnition(tempParser.FunctionDeﬁnitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(tempParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#init_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declarator(tempParser.Init_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifiers(tempParser.DeclarationSpecifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(tempParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#parameter_type_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_type_list(tempParser.Parameter_type_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(tempParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration(tempParser.Parameter_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(tempParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#block_item_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item_list(tempParser.Block_item_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#block_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item(tempParser.Block_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#expressionStatament}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatament(tempParser.ExpressionStatamentContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(tempParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(tempParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(tempParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(tempParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(tempParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(tempParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#argument_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_expression_list(tempParser.Argument_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(tempParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#relationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpression(tempParser.RelationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(tempParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(tempParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link tempParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(tempParser.ExpressionContext ctx);
}