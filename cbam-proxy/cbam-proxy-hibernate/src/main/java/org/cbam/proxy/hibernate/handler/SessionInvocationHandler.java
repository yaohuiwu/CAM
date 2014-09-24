package org.cbam.proxy.hibernate.handler;

import org.cbam.core.Action;
import org.cbam.core.CBAMService;
import org.cbam.core.CoreFactory;
import org.cbam.core.UserBehavior;
import org.cbam.core.exception.ActionNotAllowedException;
import org.cbam.core.parser.PermissionEvaluator;
import org.cbam.proxy.hibernate.QueryFilter;
import org.cbam.proxy.hibernate.QueryFilterImpl;
import org.cbam.proxy.hibernate.QueryWrapper;
import org.cbam.proxy.hibernate.SQLQueryFilterImpl;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yaohui on 14-9-23.
 */
public class SessionInvocationHandler implements InvocationHandler{

    private static final Logger LOG = LoggerFactory.getLogger(SessionInvocationHandler.class);

    private Session session;

    private QueryFilter queryFilter;
    private QueryFilter sqlQueryFilter;

//    private PermissionEvaluator evaluator ;
    private CBAMService cbamService;


    public SessionInvocationHandler(){
        queryFilter = new QueryFilterImpl();
        sqlQueryFilter = new SQLQueryFilterImpl();
//        evaluator = CoreFactory.createPermissionEvaluator();
        cbamService = CoreFactory.createCBAMService();
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

        Object result=null;
        final String methodName = method.getName();
        //TODO Session related method like save,delete,update must be check before invoked.
        LOG.debug("Session方法 {} start, args {}",method.getName(),args);
        LOG.debug("Doing authorization checking...");

        //Session method to CBAM action
        Action action = new Action(methodName,args);
        UserBehavior userBehavior = new UserBehavior("user1",action);

        if(cbamService.isNotAllowed(userBehavior)){
            throw new ActionNotAllowedException("Action is not allowed",userBehavior);
        }
        //执行方法
        result=method.invoke(session, args);
        LOG.debug("Session方法 {} end",method.getName());

        if("createCriteria".equals(methodName)){
            if(args.length < 1){
                throw new IllegalStateException("Bad argument length of createCriteria -- at least one. " +
                        "Check method createCriteria in SharedSessionContract!");
            }
            //TODO create a entity name resolver for future using.
            // ====== start
            String entityName = null ;
            if(args[0] instanceof Class){
                entityName = ((Class)args[0]).getName();
            }else if(args[0] instanceof String){
                entityName = (String)args[0];
            }else{
                throw new IllegalStateException("Can't find entity name from method [createCriteria] " +
                        "from SharedSessionContract.Maybe your hibernate version is older than 4.3.5.Final!");
            }
            // ====== end
            /**
             * CriteriaProxy will take over control all methods of Criteria.
             */
            CriteriaInvocationHandler criteriaProxy = new CriteriaInvocationHandler(session,entityName);
            return criteriaProxy.bind((Criteria)result);
        }
        else if("createQuery".equals(methodName)){
            if(args.length < 1){
                throw new IllegalStateException("Bad argument length of createQuery -- must be one. " +
                        "Check method createQuery in SharedSessionContract!");
            }
            Query proxiedQuery = session.createQuery(queryFilter.filterQueryString(session,(String)args[0]));
            QueryWrapper wrapper = new QueryWrapper(proxiedQuery);
            /**
             * QueryWrapperInvocationHandler will take over control all methods of QueryWrapper.
             * Then, QueryWrapper will take care all methods of Query, implemented in static proxy manner.
              */
            QueryWrapperInvocationHandler queryProxy = new QueryWrapperInvocationHandler(session,(Query)result);
            return queryProxy.bind(wrapper);

        }
        else if("createSQLQuery".equals(methodName)){
            /**
             * SQLQueryInvocationHandler will take over control all methods of SQLQuery.
             */
            SQLQuery newSqlQuery = session.createSQLQuery(sqlQueryFilter.filterQueryString(session,(String)args[0]));
            SQLQueryInvocationHandler queryProxy = new SQLQueryInvocationHandler(session,(SQLQuery)result);
            return queryProxy.bind(newSqlQuery);
        }
        return result;
    }


}
