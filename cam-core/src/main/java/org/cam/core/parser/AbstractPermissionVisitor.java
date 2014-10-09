package org.cam.core.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.cam.core.FactoryHelper;
import org.cam.core.util.ObjectUtils;
import org.cam.core.exception.ParserException;
import org.cam.core.mapping.EntityMapping;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.parser.antlr.PermissionBaseVisitor;
import org.cam.core.parser.antlr.PermissionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-9-27.
 */
public abstract class AbstractPermissionVisitor<T>  extends PermissionBaseVisitor<T>{

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPermissionVisitor.class);

    protected static final String VAR_USER = "user";

    protected String objectType = null;

    protected EntityMapping currentEntityMapping;
//    protected EntityTableMapping entityTableMapping;

    protected void switchCurrentEntity(String entityName){
        EntityTableMapping entityTableMapping = FactoryHelper.factory().getEntityTableMapping();
        LOG.trace("Switch current entity to {}",entityName);
        currentEntityMapping = entityTableMapping.getEntity(entityName);
    }

    protected void switchBack(){
        if(objectType!=null){
            switchCurrentEntity(objectType);
        }
    }


    protected String getTableByEntity(String entityName){
        EntityTableMapping entityTableMapping = FactoryHelper.factory().getEntityTableMapping();
        return entityTableMapping.getTableNameByEntity(entityName);
    }

    /**
     * 根据属性名得到字段名
     * @param fieldName
     * @return
     */
    protected String getColumnByField(String fieldName){
        return currentEntityMapping.getFieldColumnMap().get(fieldName);
    }

    public String getId(PermissionParser.IdAliasContext idAliasCtx){
        if(idAliasCtx!=null){
            return idAliasCtx.ID(0).getText();
        }
        throw new ParserException("Bad queryListCtx");
    }

    /**
     * 获取用户变量的值。
     *
     * @param scalarVariableCtx
     * @return
     */
    protected Object getScalarValue(PermissionParser.ScalarVariableContext scalarVariableCtx){
        String innerObjectName = scalarVariableCtx.innerObject().getText();
        if(VAR_USER.equals(innerObjectName)){
            String innerAttrName = scalarVariableCtx.ID().getText();
            return getAttrValue(FactoryHelper.currentUser(), innerAttrName);
        }
        throw new ParserException("unknown variable ["+innerObjectName+"]");
    }

    protected Object getAttrValue(Object object,String attributeName){
        return ObjectUtils.getter(object,attributeName);
    }

    protected Object toValueObject(PermissionParser.ValueContext ctx){
        String text = ctx.getText();
        if(isInt(ctx)){
            return Integer.valueOf(text);
        }
        else if(isFloat(ctx)){
            return Double.valueOf(text);
        }
        else if(isBoolean(ctx)){
            return Boolean.valueOf(text);
        }
        else if(isString(ctx)) {
            return ObjectUtils.trimWith(text,"'");
        }
        else if(isScalarVar(ctx)){
            return getScalarValue(ctx.scalarVariable());
        }
        else{
            return text;
        }
    }

    protected String toValueString(Object value){
        if(value instanceof String){
            return ObjectUtils.toSqlString((String)value);
        }else{
            return value.toString();
        }
    }


    protected boolean isFloat(PermissionParser.ValueContext ctx){
        return ctx.FLOAT()!=null;
    }

    protected boolean isInt(PermissionParser.ValueContext ctx){
        return ctx.INT()!=null;
    }

    protected boolean isString(PermissionParser.ValueContext ctx){
        return ctx.STRING()!=null;
    }

    protected boolean isBoolean(PermissionParser.ValueContext ctx){
        return ctx.boo!=null;
    }

    protected boolean isId(PermissionParser.ValueContext ctx){
        return ctx.ID()!=null;
    }

    protected boolean isScalarVar(PermissionParser.ValueContext ctx){
        return ctx.scalarVariable()!=null;
    }

    protected boolean isNull(PermissionParser.ValueContext ctx){
        return ctx.NULL()!=null;
    }

    @Override
    public T visitObjectType(@NotNull PermissionParser.ObjectTypeContext ctx) {
        objectType = ctx.getText();
        EntityTableMapping entityTableMapping = FactoryHelper.factory().getEntityTableMapping();
        currentEntityMapping = entityTableMapping.getEntity(ctx.getText());
        if(currentEntityMapping==null){
            String objectType = ctx.getText() ;
            LOG.error("Can't find mapping info for objectType: {}",objectType);
            throw new ParserException("Can't find mapping info for objectType: "+objectType);
        }
        return super.visitObjectType(ctx);
    }
}
