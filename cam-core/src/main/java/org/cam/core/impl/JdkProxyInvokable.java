package org.cam.core.impl;

import org.cam.core.Invokable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class JdkProxyInvokable implements Invokable{

    private Method method;
    private Object target;
    private Object[] arguments;

    public JdkProxyInvokable(Method method, Object target, Object[] arguments) {
        this.method = method;
        this.target = target;
        this.arguments = arguments;
    }

    @Override
    public Object invoke(){
        Object value = null;
        try{
            value = method.invoke(target,arguments);
        }catch (IllegalAccessException e0) {
            e0.printStackTrace();
            return value;
        }catch (InvocationTargetException e1){
            e1.printStackTrace();
            return value;
        }
        return value;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object getTarget() {
        return this.target;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }
}
