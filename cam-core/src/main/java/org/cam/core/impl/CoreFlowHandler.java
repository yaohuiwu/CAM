package org.cam.core.impl;

import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.core.FlowHandler;
import org.cam.core.UserBehavior;
import org.cam.core.UserContextProvider;
import org.cam.core.action.Invokable;
import org.cam.core.exception.UserBehaviorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Control flow of authorization.
 */
public class CoreFlowHandler implements FlowHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CoreFlowHandler.class);

    private CamService cbamService;

    public CoreFlowHandler(CamService cbamService, UserContextProvider userContextProvider){
        this.cbamService = cbamService;
    }

    @Override
    public Object handleFlow(Invokable invokable) throws Throwable{
        //UserBehavior userBehavior
        Object value = null;
        //translate proxy method name to standard name.

        UserBehavior userBehavior = FactoryHelper.currentBehavior(invokable);
        /**
         * Cancel execution by throws an ActionNotAllowedException if user behavior is nor allowed.
         */
        LOG.trace("before {}",userBehavior);
        try{
            before(userBehavior);
        }catch (UserBehaviorException e){
            if(LOG.isWarnEnabled()){
                LOG.warn("User behavior {} is not allowed.",e.getUserBehavior());
            }
            throw new UserBehaviorException(e.getUserBehavior(),e);
        }

        value = invokable.invoke();

        LOG.trace("After {} .. return {}",userBehavior,value);
        return after(userBehavior,value);
    }

    /**
     * Check if action is allowed.
     *
     * @param userBehavior
     */
    public void before(UserBehavior userBehavior){
        //before
    }

    /**
     * Check or rich return value.
     *
     * @param returnValue
     * @return
     */
    public Object after(UserBehavior userBehavior,Object returnValue){
        return returnValue;
    }

}
