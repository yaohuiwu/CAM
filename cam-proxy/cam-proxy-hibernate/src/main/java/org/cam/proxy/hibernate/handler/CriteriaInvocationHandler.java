package org.cam.proxy.hibernate.handler;

import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.proxy.hibernate.PermCriteriaTranslator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yaohui on 14-9-23.
 */
public class CriteriaInvocationHandler implements InvocationHandler{

    private static final Logger LOG = LoggerFactory.getLogger(CriteriaInvocationHandler.class);

    private Session session;
    private Criteria criteria;
    private String entityName;

    private PermCriteriaTranslator translator;

    private CamService service;

    public CriteriaInvocationHandler(Session session, String entityName){
        this.session = session;
        this.entityName = entityName;
        translator = new PermCriteriaTranslator();

        service = FactoryHelper.factory().getService();
    }

    /**
     * 绑定委托对象并返回一个代理类
     * @param criteria
     * @return
     */
    public Object bind(Criteria criteria) {
        this.criteria = criteria;
        //取得代理对象
        return Proxy.newProxyInstance(criteria.getClass().getClassLoader(),
                criteria.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;
        LOG.trace("Criteria {} start",method.getName());

        //执行方法
        result=method.invoke(criteria, args);

        LOG.trace("Criteria {} end", method.getName());
        return result;
    }

}
