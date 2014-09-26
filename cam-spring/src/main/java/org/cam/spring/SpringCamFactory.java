package org.cam.spring;

import org.cam.core.*;
import org.cam.core.meta.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class SpringCamFactory implements ApplicationContextAware,CamFactory{

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;

        FactoryHelper.register(this);
    }

    @Override
    public FlowHandler getFlowHandler() {
        FlowHandler flowHandler = (FlowHandler)context.getBean("camFlowHandler");
        if(flowHandler==null){
            throw new CamException("bean 'camFlowHandler' is not initialized properly.");
        }
        return flowHandler;
    }

    @Override
    public User getCurrentUser() {
        UserContextProvider provider = (UserContextProvider)context.getBean("userContextProvider");
        if(provider==null){
            throw new CamException("Bean 'userContextProvider' is not initialized properly.");
        }
        return provider.getCurrentUser();
    }
}
