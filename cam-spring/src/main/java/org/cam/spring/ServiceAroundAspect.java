package org.cam.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.cam.core.FlowHandler;
import org.cam.core.action.Invokable;
import org.cam.core.util.Logs;
import org.cam.core.exception.UserBehaviorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceAroundAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceAroundAspect.class);

    private FlowHandler flowHandler;

    public ServiceAroundAspect(FlowHandler flowHandler) {
        this.flowHandler = flowHandler;
    }

    public Object invoke(ProceedingJoinPoint joinPoint){
        Object result = null;
        Invokable invokable = new AspectjInvokable(joinPoint);

        Logs.debugIfEnabled(LOG,"Flow Control is handing over from Spring to CBAM system (FlowHandler).");
        try{
            result = flowHandler.handleFlow(invokable);
        }catch (UserBehaviorException e){
            Logs.warnIfEnabled(LOG,"UserBehaviorException occurs. {}",e.getUserBehavior());
            return result;
        }
        Logs.debugIfEnabled(LOG,"Flow Control return back to Spring. Everything is ok!");
        return result;
    }
}
