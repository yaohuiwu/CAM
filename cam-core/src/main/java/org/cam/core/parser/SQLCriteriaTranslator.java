package org.cam.core.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.cam.core.exception.ParserException;
import org.cam.core.parser.antlr.PermissionParser;

import java.util.Iterator;

/**
 * Created by wuyaohui on 14-9-27.
 */
public class SQLCriteriaTranslator extends AbstractPermissionVisitor<String> {

    public SQLCriteriaTranslator(){
    }

    @Override
    public String visitAndExpr(@NotNull PermissionParser.AndExprContext ctx) {
        String left = visit(ctx.condition(0));
        String right = visit(ctx.condition(1));

        StringBuilder s = new StringBuilder();

        s.append(left);
        s.append(" and ");
        s.append(right);

        return s.toString();
    }

    @Override
    public String visitValue(@NotNull PermissionParser.ValueContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitAction(@NotNull PermissionParser.ActionContext ctx) {
        return super.visitAction(ctx);
    }

    @Override
    public String visitCriteria(@NotNull PermissionParser.CriteriaContext ctx) {
        if(ctx.STAR()==null){
            return visit(ctx.condition());
        }else{
            return ctx.STAR().getText();
        }
    }

    @Override
    public String visitPermission(@NotNull PermissionParser.PermissionContext ctx) {
        return super.visitPermission(ctx);
    }

    @Override
    public String visitParentExpr(@NotNull PermissionParser.ParentExprContext ctx) {
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append(visit(ctx.condition()));
        s.append(")");
        return s.toString();
    }

    @Override
    public String visitObjectType(@NotNull PermissionParser.ObjectTypeContext ctx) {
        return super.visitObjectType(ctx);
    }

    @Override
    public String visitInExpr(@NotNull PermissionParser.InExprContext ctx) {
        StringBuilder s = new StringBuilder();
        String field = ctx.ID().getText();

        String column = getColumnByField(field);

        s.append(column);
        s.append(" in ");
        s.append("(");
        s.append(visit(ctx.list()));
        s.append(")");
        return s.toString();
    }

    @Override
    public String visitLiteralList(@NotNull PermissionParser.LiteralListContext ctx) {
        StringBuilder s = new StringBuilder();

        Iterator<PermissionParser.ValueContext>  it = ctx.value().iterator();
        while(it.hasNext()){
            PermissionParser.ValueContext valContext = it.next();
            if(isScalarVar(valContext)){
                s.append(visit(valContext.scalarVariable()));
            }else{
                s.append(valContext.getText());
            }
            if(it.hasNext()){
                s.append(",");
            }
        }
        return s.toString();
    }

    @Override
    public String visitQueryList(@NotNull PermissionParser.QueryListContext ctx) {
        StringBuilder s = new StringBuilder();
        s.append("select");
        s.append(" ");

        PermissionParser.IdAliasContext attrCtx = ctx.idAlias();
        String columnName = getColumnByField(attrCtx.ID(0).getText());
        s.append(columnName);
        if(attrCtx.ID(1)!=null){
            s.append(" as ");
            s.append(attrCtx.ID(1).getText());
        }
        s.append(" from ");

        s.append(getTableByEntity(ctx.entity().getText()));

        if(ctx.condition()!=null){
            s.append(" where ");
            s.append(visit(ctx.condition()));
        }
        return s.toString();
    }

    @Override
    public String visitCompExpr(@NotNull PermissionParser.CompExprContext ctx) {
        StringBuilder s = new StringBuilder();
        String field = ctx.ID().getText();
        String column = getColumnByField(field);

        s.append(column);
        s.append(" ");
        s.append(ctx.op.getText());
        s.append(" ");

        PermissionParser.ValueContext valCtx = ctx.value();

        if(isScalarVar(valCtx)){
            visit(valCtx.scalarVariable());
        }else{
            s.append(valCtx.getText());
        }

        return s.toString();
    }

    @Override
    public String visitScalarVariable(@NotNull PermissionParser.ScalarVariableContext ctx) {
        Object attrValue = getScalarValue(ctx);
        if(attrValue!=null){
            return toValueString(attrValue);
        }
        throw new ParserException("引用的对象变量"+ctx.getText()+"不能为空");
    }

    @Override
    public String visitOrExpr(@NotNull PermissionParser.OrExprContext ctx) {
        String left = visit(ctx.condition(0));
        String right = visit(ctx.condition(1));

        StringBuilder s = new StringBuilder();

        s.append(left);
        s.append(" or ");
        s.append(right);

        return s.toString();
    }
}
