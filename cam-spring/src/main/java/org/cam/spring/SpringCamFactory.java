package org.cam.spring;

import com.google.common.base.Preconditions;
import org.cam.core.*;
import org.cam.core.dao.CamDao;
import org.cam.core.dao.PersistentDao;
import org.cam.core.domain.User;
import org.cam.core.impl.CamFactoryAdapter;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.sql.SqlInterceptor;
import org.cam.proxy.hibernate.HibernateEntityTableMappingImpl;
import org.cam.proxy.hibernate.HibernateHelper;
import org.hibernate.cfg.Configuration;
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
public class SpringCamFactory extends CamFactoryAdapter implements ApplicationContextAware{

    private static final Logger LOG = LoggerFactory.getLogger(SpringCamFactory.class);

    private static ApplicationContext context;

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

    @Override
    public EntityTableMapping getEntityTableMapping() {
        return getBean("entityTableMapping",EntityTableMapping.class);
    }

    @Override
    public SqlInterceptor getSqlInterceptor() {
        return getBean("camSqlInterceptor",SqlInterceptor.class);
    }

    @Override
    public CamConfiguration getConfiguration() {
        return getBean("camConfiguration",CamConfiguration.class);
    }

    public Configuration getHibernateConfiguration(){
        Configuration configuration = null ;
        synchronized (this){
            if(context!=null){
                LocalSessionFactoryBean configBean = (LocalSessionFactoryBean) (context.getBean("&sessionFactory"));
                configuration = configBean.getConfiguration();
            }
        }
        if(configuration!=null){
            return configuration;
        }
        throw new IllegalStateException("SpringCamFactory is not initialized properly . context is null");
    }

    @Override
    public CamDao getCamDao() {
        return getBean("camDao",CamDao.class);
    }
}
