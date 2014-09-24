package org.cbam.proxy.hibernate.handler;

import org.cbam.proxy.hibernate.HibernateHelper;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
                proxiedSQLQuery.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result=null;
        LOG.debug("SQLQuery {} start", method.getName());

//        List<String> tables = Collections.EMPTY_LIST;
//        Map<String,ClassMetadata> classMetadatas = session.getSessionFactory().getAllClassMetadata();
//        Iterator<Map.Entry<String,ClassMetadata>> it = classMetadatas.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry<String,ClassMetadata> meta = it.next();
//            ClassMetadata classMetadata = meta.getValue();
//        }
//
//        Configuration cfg = HibernateHelper.getConfiguration();
//        PersistentClass persistentClass = cfg.getClassMapping("");
//
//        Table tb = persistentClass.getTable();
//
//        tb.getName();

        //执行方法
        result=method.invoke(proxiedSQLQuery, args);

        LOG.debug("SQLQuery {} end", method.getName());
        return result;
    }
}
