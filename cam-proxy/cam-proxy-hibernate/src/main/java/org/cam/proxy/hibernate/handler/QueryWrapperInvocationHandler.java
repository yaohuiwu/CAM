package org.cam.proxy.hibernate.handler;

import org.cam.core.util.Logs;
import org.cam.proxy.hibernate.QueryWrapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yaohui on 14-9-23.
 */
public class QueryWrapperInvocationHandler implements InvocationHandler{

    private static final Logger LOG = LoggerFactory.getLogger(QueryWrapperInvocationHandler.class);

    private final Query originalQuery;
    private final Session session;

    private QueryWrapper query;

    public QueryWrapperInvocationHandler(Session session,Query originalQuery){
        this.session = session;
        this.originalQuery = originalQuery;
    }
    /**
     * 绑定委托对象并返回一个代理类
     * @param query
     * @return
     */
    public Object bind(QueryWrapper query) {
        this.query = query;
        //取得代理对象
        return Proxy.newProxyInstance(query.getClass().getClassLoader(),
                query.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result=null;
        Logs.traceIfEnabled(LOG,"Query {} start", method.getName());
        //执行方法
        result=method.invoke(query, args);

        Logs.traceIfEnabled(LOG,"Query {} end", method.getName());
        return result;
    }
}
