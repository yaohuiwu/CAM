package org.cam.core.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.util.ObjectUtils;
import org.cam.core.parser.antlr.PermissionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by yaohui on 14-9-21.
 */
public class DefaultPermissionVisitor extends AbstractPermissionVisitor<Boolean> {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultPermissionVisitor.class);

    private static final String SINGLE_QUOTE = "'";

    private Object object ;

    public DefaultPermissionVisitor(Object object){
        this.object = object;
    }

    @Override
    public Boolean visitAndExpr(@NotNull PermissionParser.AndExprContext ctx) {
        boolean left = visit(ctx.condition(0));
        boolean right = visit(ctx.condition(1));

        LOG.debug("visit and ,left:{} , right:{}",left,right);
        return left && right;
    }

    @Override
    public Boolean visitValue(@NotNull PermissionParser.ValueContext ctx) {
        LOG.debug("value:{}",ctx.getText());
        return super.visitValue(ctx);
    }

    @Override
    public Boolean visitPermission(@NotNull PermissionParser.PermissionContext ctx) {
        LOG.trace("action :{} , objectType : {}",ctx.action().getText(),ctx.objectType().getText());
        return visit(ctx.criteria());
    }

    @Override
    public Boolean visitCriteria(@NotNull PermissionParser.CriteriaContext ctx) {
        if(ctx.STAR()==null){
            return visit(ctx.condition());
        }else{
            // always return true with a asterisk.
            return true;
        }
    }

    @Override
    public Boolean visitParentExpr(@NotNull PermissionParser.ParentExprContext ctx) {
        return visit(ctx.condition());
    }

    @Override
    public Boolean visitInExpr(@NotNull PermissionParser.InExprContext ctx) {
        boolean valueIn = false;
        String attrName = ctx.ID().getText();
        Object value = getFromObject(attrName);

        PermissionParser.ListContext listCtx = ctx.list();
        //literalList
        if(listCtx.literalList()!=null){
            List<PermissionParser.ValueContext> valCtxList = ctx.list().literalList().value();
            for(PermissionParser.ValueContext valCtx : valCtxList){
                if(isInt(valCtx)){
                    valueIn = Integer.valueOf(valCtx.getText()).equals((Integer)value);
                }else if(isFloat(valCtx)){
                    LOG.warn("Float value {} is not allow here",Float.valueOf(ctx.getText()));
                    //ignore
                }else if(isString(valCtx)){
                    String inStr= StringUtils.strip(valCtx.getText(),SINGLE_QUOTE);
                    valueIn = inStr.equals((String)value);
                }else if(isId(valCtx)){
                    //暂时不支持
                }else if(isScalarVar(valCtx)){
                    //从变量注册中心得到变量值
                }
                if(valueIn){
                    break;
                }
            }
        }else{
            //queryList
            //对表达式进行求值.
        }

        return valueIn;
    }

    @Override
    public Boolean visitCompExpr(@NotNull PermissionParser.CompExprContext ctx) {

        boolean r = false;

        String attrName = ctx.ID().getText();
        String attrValue = ctx.value().getText();

        PermissionParser.ValueContext valCtx = ctx.value();
        Object value = getFromObject(attrName);

        LOG.trace("operator {}, type {}", ctx.op.getText(), ctx.op.getType());
        switch (ctx.op.getType()){
            case PermissionParser.EQ :
                if(isInt(valCtx)){
                    r = Integer.valueOf(attrValue).equals((Integer)value);
                }
                if(isString(valCtx)){
                    attrValue = StringUtils.strip(attrValue,SINGLE_QUOTE);
                    r = attrValue.equals((String)value);
                }
                // Boolean
                if(isBoolean(valCtx)){
                    if(valCtx.boo.getType() == PermissionParser.TRUE){
                        r = Boolean.TRUE.equals((Boolean)value);
                    }else{
                        r = Boolean.FALSE.equals((Boolean)value);
                    }
                }

                break;
            case PermissionParser.NE :
                if(isInt(valCtx)){
                    r =  !Integer.valueOf(attrValue).equals((Integer)value);
                }
                if(isString(valCtx)){
                    attrValue = StringUtils.strip(attrValue,SINGLE_QUOTE);
                    r = !attrValue.equals((String)value);
                }
                // Boolean
                if(isBoolean(valCtx)){
                    if(valCtx.boo.getType() == PermissionParser.TRUE){
                        r = Boolean.FALSE.equals((Boolean)value);
                    }else{
                        r = Boolean.TRUE.equals((Boolean)value);
                    }
                }

                break;
            case PermissionParser.GT:
                if(isFloat(valCtx)){
                    r = (Float)value > Float.valueOf(attrValue);
                }
                if(isInt(valCtx)){
                    r = (Integer)value > Integer.valueOf(attrValue);
                }
                break;
            case PermissionParser.GE:
                if(isFloat(valCtx)){
                    r = (Float)value >= Float.valueOf(attrValue);
                }
                if(isInt(valCtx)){
                    r = (Integer)value >= Integer.valueOf(attrValue);
                }
                break;
            case PermissionParser.LT:
                if(isFloat(valCtx)){
                    r = (Float)value < Float.valueOf(attrValue);
                }
                if(isInt(valCtx)){
                    r = (Integer)value < Integer.valueOf(attrValue);
                }
                break;
            case PermissionParser.LE:
                if(isFloat(valCtx)){
                    r = (Float)value <= Float.valueOf(attrValue);
                }
                if(isInt(valCtx)){
                    r = (Integer)value <= Integer.valueOf(attrValue);
                }
                break;
            case PermissionParser.LIKE:
                if(isString(valCtx)){
                    r = ObjectUtils.likeMatches((String) value, attrValue);
                }
                break;

            default: break;
        }

        LOG.trace("attrValue {},value of {} is {} ",value,ctx.toStringTree(),r);
        return r;
    }

    @Override
    public Boolean visitOrExpr(@NotNull PermissionParser.OrExprContext ctx) {
        boolean left = visit(ctx.condition(0));
        boolean right = visit(ctx.condition(1));

        LOG.trace("visit or ,left:{} , right:{}",left,right);
        return left || right;
    }

    protected Object getFromObject(String attrName){
        // Maybe we can get field value from anywhere.
        return ObjectUtils.getter(object,attrName);
    }
}
