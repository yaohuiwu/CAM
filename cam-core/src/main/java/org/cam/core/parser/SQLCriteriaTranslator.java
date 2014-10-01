package org.cam.core.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.cam.core.parser.antlr.PermissionBaseVisitor;
import org.cam.core.parser.antlr.PermissionParser;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by wuyaohui on 14-9-27.
 */
public class SQLCriteriaTranslator extends AbstractPermissionVisitor<String> {

    private Map<String,String> fieldColumnMap;

    public SQLCriteriaTranslator(final Map<String,String> fieldColumnMap){
        this.fieldColumnMap = fieldColumnMap;
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
        String column = fieldColumnMap.get(field);

        s.append(column);
        s.append(" in ");
        s.append("(");
        Iterator<PermissionParser.ValueContext>  it = ctx.list().value().iterator();
        while(it.hasNext()){
            PermissionParser.ValueContext valContext = it.next();
            s.append(valContext.getText());
            if(it.hasNext()){
                s.append(",");
            }
        }
        s.append(")");
        return s.toString();
    }

    @Override
    public String visitCompExpr(@NotNull PermissionParser.CompExprContext ctx) {
        StringBuilder s = new StringBuilder();
        String field = ctx.ID().getText();
        String column = fieldColumnMap.get(field);

        s.append(column);
        s.append(" ");
        s.append(ctx.op.getText());
        s.append(" ");
        s.append(ctx.value().getText());

        return s.toString();
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
