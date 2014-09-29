package org.cam.spring;

import org.cam.core.*;
import org.cam.core.dao.CamDao;
import org.cam.core.domain.User;
import org.cam.proxy.hibernate.HibernateHelper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class SpringCamFactory implements ApplicationContextAware,CamFactory{

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;

        FactoryHelper.register(this);


        LocalSessionFactoryBean configBean = (LocalSessionFactoryBean) (context.getBean("&sessionFactory"));
        HibernateHelper.registerConfiguration(configBean.getConfiguration());
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

    @SuppressWarnings("unchecked")
    private <T> T getBean(String beanId,Class<T> beanClass){
        Object bean = context.getBean(beanId);
        return bean !=null ? (T)bean : null;
    }

    @Override
    public CamService getService() {
        return getBean("camService",CamService.class);
    }
}
