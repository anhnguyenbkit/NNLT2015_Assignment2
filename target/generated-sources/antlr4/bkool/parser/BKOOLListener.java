// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//	package bkool.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BKOOLParser}.
 */
public interface BKOOLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#memberDeclartion}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclartion(@NotNull BKOOLParser.MemberDeclartionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#memberDeclartion}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclartion(@NotNull BKOOLParser.MemberDeclartionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull BKOOLParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull BKOOLParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull BKOOLParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull BKOOLParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull BKOOLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull BKOOLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull BKOOLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull BKOOLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(@NotNull BKOOLParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(@NotNull BKOOLParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(@NotNull BKOOLParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(@NotNull BKOOLParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull BKOOLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull BKOOLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(@NotNull BKOOLParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(@NotNull BKOOLParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(@NotNull BKOOLParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(@NotNull BKOOLParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull BKOOLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull BKOOLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull BKOOLParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull BKOOLParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#constantDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarationStatement(@NotNull BKOOLParser.ConstantDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#constantDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarationStatement(@NotNull BKOOLParser.ConstantDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull BKOOLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull BKOOLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull BKOOLParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull BKOOLParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull BKOOLParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull BKOOLParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(@NotNull BKOOLParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(@NotNull BKOOLParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(@NotNull BKOOLParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(@NotNull BKOOLParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(@NotNull BKOOLParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(@NotNull BKOOLParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(@NotNull BKOOLParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(@NotNull BKOOLParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(@NotNull BKOOLParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(@NotNull BKOOLParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull BKOOLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull BKOOLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(@NotNull BKOOLParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(@NotNull BKOOLParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(@NotNull BKOOLParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(@NotNull BKOOLParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(@NotNull BKOOLParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(@NotNull BKOOLParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull BKOOLParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull BKOOLParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(@NotNull BKOOLParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(@NotNull BKOOLParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#statemenExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatemenExpression(@NotNull BKOOLParser.StatemenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#statemenExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatemenExpression(@NotNull BKOOLParser.StatemenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(@NotNull BKOOLParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(@NotNull BKOOLParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull BKOOLParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull BKOOLParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(@NotNull BKOOLParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(@NotNull BKOOLParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(@NotNull BKOOLParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(@NotNull BKOOLParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull BKOOLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull BKOOLParser.PrimaryContext ctx);
}