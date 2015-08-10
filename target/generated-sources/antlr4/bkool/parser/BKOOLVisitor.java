// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//	package bkool.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BKOOLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BKOOLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#memberDeclartion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclartion(@NotNull BKOOLParser.MemberDeclartionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull BKOOLParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(@NotNull BKOOLParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BKOOLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull BKOOLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(@NotNull BKOOLParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(@NotNull BKOOLParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull BKOOLParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier(@NotNull BKOOLParser.VariableModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(@NotNull BKOOLParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BKOOLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull BKOOLParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#constantDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclarationStatement(@NotNull BKOOLParser.ConstantDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull BKOOLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(@NotNull BKOOLParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull BKOOLParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(@NotNull BKOOLParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull BKOOLParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(@NotNull BKOOLParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(@NotNull BKOOLParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(@NotNull BKOOLParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull BKOOLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(@NotNull BKOOLParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(@NotNull BKOOLParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(@NotNull BKOOLParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(@NotNull BKOOLParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#variableDeclarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarators(@NotNull BKOOLParser.VariableDeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#statemenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemenExpression(@NotNull BKOOLParser.StatemenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(@NotNull BKOOLParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull BKOOLParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(@NotNull BKOOLParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(@NotNull BKOOLParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull BKOOLParser.PrimaryContext ctx);
}