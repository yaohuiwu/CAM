package org.cam.spring;

import com.google.common.base.Preconditions;
import org.cam.core.*;
import org.cam.core.dao.CamDao;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.User;
import org.cam.proxy.hibernate.HibernateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class SpringCamFactory implements ApplicationContextAware,CamFactory{

    private static final Logger LOG = LoggerFactory.getLogger(SpringCamFactory.class);

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;

        //Check bean that must be provided
        if(!context.containsBean("dataSource")){
            throw new CamException("Bean with id 'dataSource' must be provided.");
        }
        if(!context.containsBean("userContextProvider")){
            throw new CamException("Bean with id 'userContextProvider' and type 'org.cam.core.UserContextProvider' must be provided.");
        }
        if(!context.containsBean("camProperties")){
            throw new CamException("Bean with id 'camProperties' and type 'util:properties' must be provided.");
        }

        LOG.debug("{}", context.getBean("camProperties"));

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

    @Override
    public PersistentDao getPersistentDao() {
        return getBean("persistentDao",PersistentDao.class);
    }
}
