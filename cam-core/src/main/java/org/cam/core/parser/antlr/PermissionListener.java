// Generated from /home/wuyaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
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
	 * Enter a parse tree produced by {@link PermissionParser#criteria}.
	 * @param ctx the parse tree
	 */
	void enterCriteria(@NotNull PermissionParser.CriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#criteria}.
	 * @param ctx the parse tree
	 */
	void exitCriteria(@NotNull PermissionParser.CriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(@NotNull PermissionParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(@NotNull PermissionParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#innerObject}.
	 * @param ctx the parse tree
	 */
	void enterInnerObject(@NotNull PermissionParser.InnerObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#innerObject}.
	 * @param ctx the parse tree
	 */
	void exitInnerObject(@NotNull PermissionParser.InnerObjectContext ctx);
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
	 * Enter a parse tree produced by {@link PermissionParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull PermissionParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull PermissionParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#literalList}.
	 * @param ctx the parse tree
	 */
	void enterLiteralList(@NotNull PermissionParser.LiteralListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#literalList}.
	 * @param ctx the parse tree
	 */
	void exitLiteralList(@NotNull PermissionParser.LiteralListContext ctx);
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
	 * Enter a parse tree produced by {@link PermissionParser#idAlias}.
	 * @param ctx the parse tree
	 */
	void enterIdAlias(@NotNull PermissionParser.IdAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#idAlias}.
	 * @param ctx the parse tree
	 */
	void exitIdAlias(@NotNull PermissionParser.IdAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#scalarVariable}.
	 * @param ctx the parse tree
	 */
	void enterScalarVariable(@NotNull PermissionParser.ScalarVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#scalarVariable}.
	 * @param ctx the parse tree
	 */
	void exitScalarVariable(@NotNull PermissionParser.ScalarVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PermissionParser#queryList}.
	 * @param ctx the parse tree
	 */
	void enterQueryList(@NotNull PermissionParser.QueryListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PermissionParser#queryList}.
	 * @param ctx the parse tree
	 */
	void exitQueryList(@NotNull PermissionParser.QueryListContext ctx);
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
}