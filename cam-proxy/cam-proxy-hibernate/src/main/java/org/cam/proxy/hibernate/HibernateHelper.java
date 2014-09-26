package org.cam.proxy.hibernate;

import org.cam.proxy.hibernate.exception.ConfigurationNotRegisterException;
import org.cam.proxy.hibernate.handler.SessionInvocationHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper help to create proxied and normal session.
 *
 * <p>
 *     Using static or dynamic proxy in a jdk manner.
 * </p>
 */
public class HibernateHelper {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateHelper.class);

    private volatile static Configuration _configuration ;

    /**
     * Create normal session.
     *
     * @param sessionFactory
     * @return
     */
    public static Session getSession(SessionFactory sessionFactory){
        return getSession(sessionFactory,false);
    }

    /**
     * Create proxied session , which will be under control by CBAM system.
     *
     * @param sessionFactory
     * @return proxied session
     */
    public static Session getProxiedSession(SessionFactory sessionFactory){
        return getSession(sessionFactory,true);
    }

    public static Session getSession(SessionFactory sessionFactory,boolean proxied){
        Session session = sessionFactory.getCurrentSession();
        if(session==null){
            session = sessionFactory.openSession();
        }
        if(proxied){
            SessionInvocationHandler proxy = new SessionInvocationHandler();
            return proxy.bind(session);
        }else{
            return session;
        }
    }

    public static void registerConfiguration(Configuration configuration){
        _configuration = configuration;
        if(_configuration!=null){
            LOG.info("Hibernate Configuration has been registered.");
        }
    }

    public static Configuration getConfiguration(){
        if(_configuration==null){
            throw new ConfigurationNotRegisterException();
        }
        return _configuration;
    }

}
