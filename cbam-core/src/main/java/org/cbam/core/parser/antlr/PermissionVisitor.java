// Generated from /home/wuyaohui/code/github/learning-java/project/antlr/permission-parser-01/src/main/antlr4/Permission.g4 by ANTLR 4.4.1-dev
package org.cbam.core.parser.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PermissionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PermissionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(@NotNull PermissionParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull PermissionParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(@NotNull PermissionParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#permission}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPermission(@NotNull PermissionParser.PermissionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentExpr(@NotNull PermissionParser.ParentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#objectType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectType(@NotNull PermissionParser.ObjectTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(@NotNull PermissionParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull PermissionParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull PermissionParser.OrExprContext ctx);
}