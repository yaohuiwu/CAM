package org.cam.core.action;

import java.lang.reflect.Method;

/**
 * A contract between CBAM and other proxy implementation like aspectj and JDK (or cglib) proxy.
 *
 */
public interface Invokable {

    public Object invoke() throws Throwable;

    public Method getMethod();

    public Object getTarget();

    public Object[] getArguments();
}
