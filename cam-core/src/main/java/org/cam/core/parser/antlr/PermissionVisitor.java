// Generated from /home/wuyaohui/code/github/CBAM/cam-core/src/main/antlr/Permission.g4 by ANTLR 4.4.1-dev
package org.cam.core.parser.antlr;
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
	 * Visit a parse tree produced by {@link PermissionParser#criteria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCriteria(@NotNull PermissionParser.CriteriaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#innerObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerObject(@NotNull PermissionParser.InnerObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#permission}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPermission(@NotNull PermissionParser.PermissionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull PermissionParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#literalList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralList(@NotNull PermissionParser.LiteralListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentExpr(@NotNull PermissionParser.ParentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(@NotNull PermissionParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link PermissionParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(@NotNull PermissionParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#idAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAlias(@NotNull PermissionParser.IdAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#scalarVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarVariable(@NotNull PermissionParser.ScalarVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PermissionParser#queryList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryList(@NotNull PermissionParser.QueryListContext ctx);
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
}