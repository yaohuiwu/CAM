package org.cbam.core.impl;

import org.cbam.core.Invokable;
import org.cbam.core.exception.ActionNotAllowedException;

import java.lang.reflect.Method;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class JdkProxyInvokable implements Invokable{

    private Method method;
    private Object target;
    private Object[] arguments;

    public JdkProxyInvokable() {
    }

    public JdkProxyInvokable(Method method, Object target, Object[] arguments) {
        this.method = method;
        this.target = target;
        this.arguments = arguments;
    }

    @Override
    public Object invoke() throws ActionNotAllowedException {
        return null;
    }

    @Override
    public Method getMethod() {
        return null;
    }

    @Override
    public Object getTarget() {
        return null;
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }
}
