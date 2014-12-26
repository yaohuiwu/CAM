package org.cam.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.cam.core.FlowHandler;
import org.cam.core.action.Invokable;
import org.cam.core.exception.UserBehaviorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceAroundAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceAroundAspect.class);

    private FlowHandler flowHandler;

    public ServiceAroundAspect(FlowHandler flowHandler) {
        this.flowHandler = flowHandler;
    }

    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result = null;
        Invokable invokable = new AspectjInvokable(joinPoint);

        LOG.trace("Flow Control is handing over from Spring to CBAM system (FlowHandler).");
        try{
            result = flowHandler.handleFlow(invokable);
        }catch (UserBehaviorException e){
            LOG.warn("UserBehaviorException occurs. {}",e.getUserBehavior());
            return result;
        }
        LOG.trace("Flow Control return back to Spring. Everything is ok!");

        return result;
    }
}
