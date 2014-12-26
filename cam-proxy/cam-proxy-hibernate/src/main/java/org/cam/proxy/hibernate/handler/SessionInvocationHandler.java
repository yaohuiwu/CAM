package org.cam.proxy.hibernate.handler;

import org.cam.core.FactoryHelper;
import org.cam.core.UserBehavior;
import org.cam.core.action.Invokable;
import org.cam.core.exception.UserBehaviorException;
import org.cam.core.impl.JdkProxyInvokable;
import org.cam.proxy.hibernate.QueryFilter;
import org.cam.proxy.hibernate.QueryFilterImpl;
import org.cam.proxy.hibernate.QueryWrapper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class SessionInvocationHandler implements InvocationHandler{

    private static final Logger LOG = LoggerFactory.getLogger(SessionInvocationHandler.class);

    private Session session;

    private QueryFilter queryFilter;

    public SessionInvocationHandler(){
        queryFilter = new QueryFilterImpl();
    }

    /**
     * 绑定委托对象并返回一个代理类
     * @param session
     * @return
     */
    public Session bind(Session session) {
        this.session = session;
        //取得代理对象
        return (Session)Proxy.newProxyInstance(session.getClass().getClassLoader(),
                session.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        Invokable invokable = new JdkProxyInvokable(method,session,args);

        result = invokable.invoke();

        //query flow
        try{
            if("createCriteria".equals(method.getName())){
                if(args.length < 1){
                    throw new IllegalStateException("Bad argument length of createCriteria -- at least one. ");
                }
                // ====== start
                String entityName = null ;
                if(args[0] instanceof Class){
                    entityName = ((Class)args[0]).getName();
                }else if(args[0] instanceof String){
                    entityName = (String)args[0];
                }else{
                    throw new IllegalStateException("Can't find entity name from method [createCriteria] ");
                }
                // ====== end
                CriteriaInvocationHandler criteriaProxy = new CriteriaInvocationHandler(session,entityName);
                return criteriaProxy.bind((Criteria)result);
            }
            else if("createQuery".equals(method.getName())){
                if(args.length < 1){
                    throw new IllegalStateException("Bad argument length of createQuery -- must be one. ");
                }
                Query proxiedQuery = session.createQuery((String)args[0]);
                QueryWrapper wrapper = new QueryWrapper(proxiedQuery);
                QueryWrapperInvocationHandler queryProxy = new QueryWrapperInvocationHandler(session,(Query)result);
                return queryProxy.bind(wrapper);
            }
            else if("createSQLQuery".equals(method.getName())){
                SQLQuery newSqlQuery = session.createSQLQuery((String)args[0]);
                SQLQueryInvocationHandler queryProxy = new SQLQueryInvocationHandler(session,(SQLQuery)result);
                return queryProxy.bind(newSqlQuery);
            }
        }catch (UserBehaviorException e){

            UserBehavior currentUserBehavior  = FactoryHelper.currentBehavior(invokable);
            LOG.warn("{} not allowed.",currentUserBehavior);
            throw new UserBehaviorException("当前用户没有权限",currentUserBehavior);
        }

        return result;
    }

}
