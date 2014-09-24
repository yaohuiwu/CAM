package org.cbam.proxy.hibernate;

import org.cbam.proxy.hibernate.handler.SessionInvocationHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Helper help to create proxied and normal session.
 *
 * <p>
 *     Using static or dynamic proxy in a jdk manner.
 * </p>
 */
public class SessionHelper {

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

}
