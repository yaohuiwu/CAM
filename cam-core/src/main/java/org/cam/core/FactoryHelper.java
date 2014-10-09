package org.cam.core;

import org.cam.core.action.Action;
import org.cam.core.action.Invokable;
import org.cam.core.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class FactoryHelper {

    private static final Logger LOG = LoggerFactory.getLogger(FactoryHelper.class);

    public volatile static CamFactory _factory;

    public static void register(CamFactory factory){
        _factory = factory;
        if(_factory!=null){
            LOG.info("CamFactory has been registered.");
        }
    }

    public static CamFactory factory(){
        return _factory;
    }

    public static User currentUser(){
        return factory().getCurrentUser();
    }

    public static FlowHandler flow(){
        return factory().getFlowHandler();
    }

    public static String getUserType(){
        return currentUser().getClass().getSimpleName();
    }

    public static UserBehavior currentBehavior(final Invokable invokable){
        return new UserBehavior(FactoryHelper.currentUser(), Action.toAction(invokable));
    }
}
