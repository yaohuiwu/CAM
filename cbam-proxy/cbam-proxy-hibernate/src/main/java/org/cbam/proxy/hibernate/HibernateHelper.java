package org.cbam.proxy.hibernate;

import org.cbam.proxy.hibernate.exception.ConfigurationNotRegisterException;
import org.cbam.proxy.hibernate.handler.SessionInvocationHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Helper help to create proxied and normal session.
 *
 * <p>
 *     Using static or dynamic proxy in a jdk manner.
 * </p>
 */
public class HibernateHelper {

    private static Configuration configuration ;

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
        configuration = configuration;
    }

    public static Configuration getConfiguration(){
        if(configuration==null){
            throw new ConfigurationNotRegisterException();
        }
        return configuration;
    }

}
