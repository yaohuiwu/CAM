// Generated from /home/wuyaohui/code/pekall/server/CBAM/cam-sql/src/main/antlr/SQLite.g4 by ANTLR 4.4.1-dev
package org.cam.sql.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLiteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLiteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#insert_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_stmt(@NotNull SQLiteParser.Insert_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#sql_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_stmt(@NotNull SQLiteParser.Sql_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#table_or_index_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_or_index_name(@NotNull SQLiteParser.Table_or_index_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#compound_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_operator(@NotNull SQLiteParser.Compound_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#indexed_column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexed_column(@NotNull SQLiteParser.Indexed_columnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#create_index_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_index_stmt(@NotNull SQLiteParser.Create_index_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#rollback_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollback_stmt(@NotNull SQLiteParser.Rollback_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name(@NotNull SQLiteParser.Column_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#qualified_table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualified_table_name(@NotNull SQLiteParser.Qualified_table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#savepoint_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepoint_name(@NotNull SQLiteParser.Savepoint_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#result_column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_column(@NotNull SQLiteParser.Result_columnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#error_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError_message(@NotNull SQLiteParser.Error_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#select_core}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_core(@NotNull SQLiteParser.Select_coreContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#create_trigger_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_trigger_stmt(@NotNull SQLiteParser.Create_trigger_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(@NotNull SQLiteParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_stmt_list(@NotNull SQLiteParser.Sql_stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#drop_table_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_table_stmt(@NotNull SQLiteParser.Drop_table_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#any_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_name(@NotNull SQLiteParser.Any_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#database_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatabase_name(@NotNull SQLiteParser.Database_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#module_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_argument(@NotNull SQLiteParser.Module_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#join_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_operator(@NotNull SQLiteParser.Join_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#vacuum_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVacuum_stmt(@NotNull SQLiteParser.Vacuum_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#factored_select_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactored_select_stmt(@NotNull SQLiteParser.Factored_select_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#transaction_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransaction_name(@NotNull SQLiteParser.Transaction_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#cte_table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCte_table_name(@NotNull SQLiteParser.Cte_table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(@NotNull SQLiteParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#common_table_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommon_table_expression(@NotNull SQLiteParser.Common_table_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#drop_trigger_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_trigger_stmt(@NotNull SQLiteParser.Drop_trigger_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#new_table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_table_name(@NotNull SQLiteParser.New_table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#type_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_name(@NotNull SQLiteParser.Type_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#table_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_alias(@NotNull SQLiteParser.Table_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#outer_join_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuter_join_type(@NotNull SQLiteParser.Outer_join_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#module_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_name(@NotNull SQLiteParser.Module_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#commit_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommit_stmt(@NotNull SQLiteParser.Commit_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#trigger_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrigger_name(@NotNull SQLiteParser.Trigger_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#create_table_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_table_stmt(@NotNull SQLiteParser.Create_table_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#pragma_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragma_value(@NotNull SQLiteParser.Pragma_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#column_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_constraint(@NotNull SQLiteParser.Column_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#savepoint_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSavepoint_stmt(@NotNull SQLiteParser.Savepoint_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#detach_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetach_stmt(@NotNull SQLiteParser.Detach_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#column_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_def(@NotNull SQLiteParser.Column_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#table_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_constraint(@NotNull SQLiteParser.Table_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#column_alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_alias(@NotNull SQLiteParser.Column_aliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#delete_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_stmt(@NotNull SQLiteParser.Delete_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#release_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelease_stmt(@NotNull SQLiteParser.Release_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#foreign_table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeign_table(@NotNull SQLiteParser.Foreign_tableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#create_view_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_view_stmt(@NotNull SQLiteParser.Create_view_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull SQLiteParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#signed_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigned_number(@NotNull SQLiteParser.Signed_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#delete_stmt_limited}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_stmt_limited(@NotNull SQLiteParser.Delete_stmt_limitedContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#index_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex_name(@NotNull SQLiteParser.Index_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#select_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_stmt(@NotNull SQLiteParser.Select_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#create_virtual_table_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_virtual_table_stmt(@NotNull SQLiteParser.Create_virtual_table_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#alter_table_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_table_stmt(@NotNull SQLiteParser.Alter_table_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#attach_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttach_stmt(@NotNull SQLiteParser.Attach_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#pragma_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragma_stmt(@NotNull SQLiteParser.Pragma_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(@NotNull SQLiteParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(@NotNull SQLiteParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#join_constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_constraint(@NotNull SQLiteParser.Join_constraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#reindex_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReindex_stmt(@NotNull SQLiteParser.Reindex_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(@NotNull SQLiteParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#begin_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_stmt(@NotNull SQLiteParser.Begin_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#table_or_subquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_or_subquery(@NotNull SQLiteParser.Table_or_subqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#error}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError(@NotNull SQLiteParser.ErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#ordering_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdering_term(@NotNull SQLiteParser.Ordering_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(@NotNull SQLiteParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#with_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_clause(@NotNull SQLiteParser.With_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#pragma_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragma_name(@NotNull SQLiteParser.Pragma_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#select_or_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_or_values(@NotNull SQLiteParser.Select_or_valuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#simple_select_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_select_stmt(@NotNull SQLiteParser.Simple_select_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#view_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitView_name(@NotNull SQLiteParser.View_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#join_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin_clause(@NotNull SQLiteParser.Join_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#foreign_key_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeign_key_clause(@NotNull SQLiteParser.Foreign_key_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#literal_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_value(@NotNull SQLiteParser.Literal_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#drop_index_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_index_stmt(@NotNull SQLiteParser.Drop_index_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#compound_select_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_select_stmt(@NotNull SQLiteParser.Compound_select_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#update_stmt_limited}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_stmt_limited(@NotNull SQLiteParser.Update_stmt_limitedContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#collation_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollation_name(@NotNull SQLiteParser.Collation_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#update_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_stmt(@NotNull SQLiteParser.Update_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#drop_view_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_view_stmt(@NotNull SQLiteParser.Drop_view_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#raise_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaise_function(@NotNull SQLiteParser.Raise_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#conflict_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConflict_clause(@NotNull SQLiteParser.Conflict_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLiteParser#analyze_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnalyze_stmt(@NotNull SQLiteParser.Analyze_stmtContext ctx);
}