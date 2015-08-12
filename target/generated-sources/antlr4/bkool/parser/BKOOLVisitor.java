// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//package bkool.parser;

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
	 * Visit a parse tree produced by {@link BKOOLParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(@NotNull BKOOLParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull BKOOLParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull BKOOLParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull BKOOLParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(@NotNull BKOOLParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#moreterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreterm(@NotNull BKOOLParser.MoretermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#var_dl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_dl(@NotNull BKOOLParser.Var_dlContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull BKOOLParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact(@NotNull BKOOLParser.FactContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#func_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_decl(@NotNull BKOOLParser.Func_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull BKOOLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BKOOLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#parlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParlist(@NotNull BKOOLParser.ParlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#mem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMem(@NotNull BKOOLParser.MemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#morefact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMorefact(@NotNull BKOOLParser.MorefactContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#idlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlist(@NotNull BKOOLParser.IdlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#mctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMctype(@NotNull BKOOLParser.MctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(@NotNull BKOOLParser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BKOOLParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull BKOOLParser.DeclContext ctx);
}