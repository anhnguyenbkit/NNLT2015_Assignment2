// Generated from BKOOL.g4 by ANTLR 4.4
package bkool.parser;

//package bkool.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BKOOLParser}.
 */
public interface BKOOLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull BKOOLParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull BKOOLParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(@NotNull BKOOLParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(@NotNull BKOOLParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull BKOOLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull BKOOLParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull BKOOLParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull BKOOLParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(@NotNull BKOOLParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(@NotNull BKOOLParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#moreterm}.
	 * @param ctx the parse tree
	 */
	void enterMoreterm(@NotNull BKOOLParser.MoretermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#moreterm}.
	 * @param ctx the parse tree
	 */
	void exitMoreterm(@NotNull BKOOLParser.MoretermContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#var_dl}.
	 * @param ctx the parse tree
	 */
	void enterVar_dl(@NotNull BKOOLParser.Var_dlContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#var_dl}.
	 * @param ctx the parse tree
	 */
	void exitVar_dl(@NotNull BKOOLParser.Var_dlContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull BKOOLParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull BKOOLParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(@NotNull BKOOLParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(@NotNull BKOOLParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(@NotNull BKOOLParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(@NotNull BKOOLParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull BKOOLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull BKOOLParser.TermContext ctx);
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
	 * Enter a parse tree produced by {@link BKOOLParser#parlist}.
	 * @param ctx the parse tree
	 */
	void enterParlist(@NotNull BKOOLParser.ParlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#parlist}.
	 * @param ctx the parse tree
	 */
	void exitParlist(@NotNull BKOOLParser.ParlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#mem}.
	 * @param ctx the parse tree
	 */
	void enterMem(@NotNull BKOOLParser.MemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#mem}.
	 * @param ctx the parse tree
	 */
	void exitMem(@NotNull BKOOLParser.MemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#morefact}.
	 * @param ctx the parse tree
	 */
	void enterMorefact(@NotNull BKOOLParser.MorefactContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#morefact}.
	 * @param ctx the parse tree
	 */
	void exitMorefact(@NotNull BKOOLParser.MorefactContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#idlist}.
	 * @param ctx the parse tree
	 */
	void enterIdlist(@NotNull BKOOLParser.IdlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#idlist}.
	 * @param ctx the parse tree
	 */
	void exitIdlist(@NotNull BKOOLParser.IdlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#mctype}.
	 * @param ctx the parse tree
	 */
	void enterMctype(@NotNull BKOOLParser.MctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#mctype}.
	 * @param ctx the parse tree
	 */
	void exitMctype(@NotNull BKOOLParser.MctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(@NotNull BKOOLParser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(@NotNull BKOOLParser.ExplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link BKOOLParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull BKOOLParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BKOOLParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull BKOOLParser.DeclContext ctx);
}