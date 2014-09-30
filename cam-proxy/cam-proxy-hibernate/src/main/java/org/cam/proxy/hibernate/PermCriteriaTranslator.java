package org.cam.proxy.hibernate;

import com.google.common.collect.Lists;
import org.antlr.v4.runtime.misc.NotNull;
import org.cam.core.domain.Permission;
import org.cam.core.parser.AbstractPermissionEvaluator;
import org.cam.core.parser.AbstractPermissionVisitor;
import org.cam.core.parser.antlr.PermissionParser;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-27.
 */
public class PermCriteriaTranslator extends AbstractPermissionEvaluator{

    public List<Criterion> toCriterion(List<Permission> permissionList){
        List<Criterion> criterionList = Lists.newArrayList();
        for(Permission permission : permissionList){
            Criterion c = toCriterion(permission);
            if(c!=null){
                criterionList.add(c);
            }
        }
        return criterionList;
    }

    public Criterion toCriterion(Permission permission){
        CriterionVisitor visitor = new CriterionVisitor();
        return visitor.visit(createParseTree(permission.toString()));
    }

    public class CriterionVisitor extends AbstractPermissionVisitor<Criterion> {
        @Override
        public Criterion visitOrExpr(@NotNull PermissionParser.OrExprContext ctx) {
            Criterion left = visit(ctx.condition(0));
            Criterion right = visit(ctx.condition(1));
            return Restrictions.or(left,right);
        }

        @Override
        public Criterion visitCompExpr(@NotNull PermissionParser.CompExprContext ctx) {
            PermissionParser.ValueContext valCtx = ctx.value();
            String id = ctx.ID().getText();
            Criterion c = null;
            Object value = toValueObject(valCtx);

            switch (ctx.op.getType()){
                case PermissionParser.EQ :
                    c = Restrictions.eq(id,value);
                    break;
                case PermissionParser.NE :
                    c = Restrictions.ne(id,value);
                    break;
                case PermissionParser.GT:
                    c = Restrictions.gt(id,value);
                    break;
                case PermissionParser.GE:
                    c = Restrictions.ge(id,value);
                    break;
                case PermissionParser.LT:
                    c = Restrictions.lt(id,value);
                    break;
                case PermissionParser.LE:
                    c = Restrictions.le(id,value);
                    break;
                case PermissionParser.LIKE:
                    c = Restrictions.like(id,value);
                    break;

                default: break;
            }

            return c;
        }

        @Override
        public Criterion visitInExpr(@NotNull PermissionParser.InExprContext ctx) {
            List<Object> values = Lists.newArrayList();
            for(PermissionParser.ValueContext valueContext : ctx.value()){
                values.add(toValueObject(valueContext));
            }
            return Restrictions.in(ctx.ID().getText(), values);
        }

        @Override
        public Criterion visitObjectType(@NotNull PermissionParser.ObjectTypeContext ctx) {
            return super.visitObjectType(ctx);
        }

        @Override
        public Criterion visitParentExpr(@NotNull PermissionParser.ParentExprContext ctx) {
            Criterion criterion = visit(ctx.condition());
            return Restrictions.and(criterion);
        }

        @Override
        public Criterion visitPermission(@NotNull PermissionParser.PermissionContext ctx) {
            return super.visitPermission(ctx);
        }

        @Override
        public Criterion visitAction(@NotNull PermissionParser.ActionContext ctx) {
            return super.visitAction(ctx);
        }

        @Override
        public Criterion visitValue(@NotNull PermissionParser.ValueContext ctx) {
            return super.visitValue(ctx);
        }

        @Override
        public Criterion visitAndExpr(@NotNull PermissionParser.AndExprContext ctx) {
            Criterion left = visit(ctx.condition(0));
            Criterion right = visit(ctx.condition(1));
            return Restrictions.and(left, right);
        }

        @Override
        public Criterion visitCriteria(@NotNull PermissionParser.CriteriaContext ctx) {
            if(ctx.STAR()==null){
                return visit(ctx.condition());
            }else{
                return Restrictions.eq("1","1");
            }
        }
    }

}
