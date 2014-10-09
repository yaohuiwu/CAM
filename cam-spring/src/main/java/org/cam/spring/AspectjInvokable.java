package org.cam.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.cam.core.action.Invokable;

import java.lang.reflect.Method;

public class AspectjInvokable implements Invokable{

    private ProceedingJoinPoint proJoinPoint;

    public AspectjInvokable(ProceedingJoinPoint proJoinPoint) {
        this.proJoinPoint = proJoinPoint;
    }

    @Override
    public Object invoke() throws Throwable {
        return proJoinPoint.proceed();
    }

    @Override
    public Method getMethod() {
        Signature signature = proJoinPoint.getSignature();
        if(signature instanceof MethodSignature){
            return ((MethodSignature)signature).getMethod();
        }
        throw new IllegalStateException("JoinPoint should not go here except method join point.");
    }

    @Override
    public Object getTarget() {
        return proJoinPoint.getTarget();
    }

    @Override
    public Object[] getArguments() {
        return proJoinPoint.getArgs();
    }
}
