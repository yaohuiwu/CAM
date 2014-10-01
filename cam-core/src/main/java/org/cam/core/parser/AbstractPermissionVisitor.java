package org.cam.core.parser;

import org.cam.core.ObjectUtils;
import org.cam.core.parser.antlr.PermissionBaseVisitor;
import org.cam.core.parser.antlr.PermissionParser;

/**
 * Created by wuyaohui on 14-9-27.
 */
public abstract class AbstractPermissionVisitor<T>  extends PermissionBaseVisitor<T>{

    /**
     * 获取变量的值。
     *
     * @param varName
     * @return
     */
    protected Variable getVarValue(String varName){

        return null;
    }

    protected Object toValueObject(PermissionParser.ValueContext ctx){
        String text = ctx.getText();
        if(isInt(ctx)){
            return Integer.valueOf(text);
        }
        else if(isFloat(ctx)){
            return Float.valueOf(text);
        }
        else if(isBoolean(ctx)){
            return Boolean.valueOf(text);
        }
        else if(isString(ctx)) {
            return ObjectUtils.trimWith(text,"'");
        }
        else{
            return text;
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
        return ctx.scalarVar()!=null;
    }

    protected boolean isNull(PermissionParser.ValueContext ctx){
        return ctx.scalarVar()!=null;
    }
}
