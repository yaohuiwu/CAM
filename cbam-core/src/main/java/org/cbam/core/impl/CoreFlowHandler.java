package org.cbam.core.impl;

import org.cbam.core.*;
import org.cbam.core.exception.UserBehaviorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Control flow of authorization.
 */
public class CoreFlowHandler implements FlowHandler{

    private static final Logger LOG = LoggerFactory.getLogger(CoreFlowHandler.class);

    private CBAMService cbamService;

    public CoreFlowHandler(CBAMService cbamService, UserContextProvider userContextProvider){
        this.cbamService = cbamService;

        CoreFactory.registerUserContextProvider(userContextProvider);
        CoreFactory.registerFlowHandler(this);
    }

    @Override
    public Object handleFlow(Invokable invokable) {
        //UserBehavior userBehavior
        Object value = null;

        String actionName = invokable.getMethod().getName();
        Object[] args = invokable.getArguments();

        //translate proxy method name to standard name.

        UserBehavior userBehavior = CoreFactory.createUserBehavior(actionName,args);
        /**
         * Cancel execution by throws an ActionNotAllowedException if user behavior is nor allowed.
         */
        try{
            before(userBehavior);
        }catch (UserBehaviorException e){
            if(LOG.isWarnEnabled()){
                LOG.warn("User behavior {} is not allowed.",e.getUserBehavior());
            }
            throw new UserBehaviorException(e.getMessage(),e.getUserBehavior());
        }
        try{
            value = invokable.invoke();
        }catch (Throwable throwable){
            //Convert to a RuntimeException
            throwable.printStackTrace();
            throw new RuntimeException(throwable.getCause());
        }
        return after(value);
    }

    /**
     * Check if action is allowed.
     *
     * @param userBehavior
     */
    public void before(UserBehavior userBehavior){
//        if(cbamService.isNotAllowed(userBehavior)){
//            throw new ActionNotAllowedException("",userBehavior);
//        }
        Logs.traceIfEnabled(LOG,"before invoke..{}",userBehavior);
    }

    /**
     * Check or rich return value.
     *
     * @param returnValue
     * @return
     */
    public Object after(Object returnValue){

        Logs.traceIfEnabled(LOG,"After invoke..{}",returnValue);
        return returnValue;
    }
}
