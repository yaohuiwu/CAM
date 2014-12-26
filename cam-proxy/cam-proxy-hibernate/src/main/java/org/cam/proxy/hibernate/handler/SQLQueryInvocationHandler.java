package org.cam.proxy.hibernate.handler;

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
public class SQLQueryInvocationHandler implements InvocationHandler{

    private static final Logger LOG = LoggerFactory.getLogger(SQLQueryInvocationHandler.class);

    private Session session;

    private SQLQuery originalSQLQuery;
    private SQLQuery proxiedSQLQuery;


    public SQLQueryInvocationHandler(Session session, SQLQuery originalSQLQuery){
        this.session = session;
        this.originalSQLQuery = originalSQLQuery;
    }
    /**
     * 绑定委托对象并返回一个代理类
     * @param sqlQuery
     * @return
     */
    public Object bind(SQLQuery sqlQuery) {
        this.proxiedSQLQuery = sqlQuery;
        //取得代理对象
        return Proxy.newProxyInstance(proxiedSQLQuery.getClass().getClassLoader(),
                proxiedSQLQuery.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;
        LOG.trace("SQLQuery {} start", method.getName());

        //执行方法
        result=method.invoke(proxiedSQLQuery, args);

        LOG.trace("SQLQuery {} end", method.getName());
        return result;
    }
}
