// Generated from /home/wuyaohui/code/github/learning-java/project/antlr/permission-parser-01/src/main/antlr4/Permission.g4 by ANTLR 4.4.1-dev
package org.cam.core.parser.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PermissionParser}.
 */
public interface PermissionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(@NotNull PermissionParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(@NotNull PermissionParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull PermissionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull PermissionParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(@NotNull PermissionParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(@NotNull PermissionParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#permission}.
	 * @param ctx the parse tree
	 */
	void enterPermission(@NotNull PermissionParser.PermissionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#permission}.
	 * @param ctx the parse tree
	 */
	void exitPermission(@NotNull PermissionParser.PermissionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterParentExpr(@NotNull PermissionParser.ParentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitParentExpr(@NotNull PermissionParser.ParentExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#objectType}.
	 * @param ctx the parse tree
	 */
	void enterObjectType(@NotNull PermissionParser.ObjectTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#objectType}.
	 * @param ctx the parse tree
	 */
	void exitObjectType(@NotNull PermissionParser.ObjectTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(@NotNull PermissionParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(@NotNull PermissionParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(@NotNull PermissionParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(@NotNull PermissionParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(@NotNull PermissionParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(@NotNull PermissionParser.OrExprContext ctx);
}