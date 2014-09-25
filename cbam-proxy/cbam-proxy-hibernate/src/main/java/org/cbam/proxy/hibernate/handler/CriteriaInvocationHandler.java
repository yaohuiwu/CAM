package org.cbam.proxy.hibernate.handler;

import org.cbam.core.Logs;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaohui on 14-9-23.
 */
public class CriteriaInvocationHandler implements InvocationHandler{

    private static final Logger LOG = LoggerFactory.getLogger(CriteriaInvocationHandler.class);

    private Session session;
    private Criteria criteria;
    private String entityName;

    public CriteriaInvocationHandler(Session session, String entityName){
        this.session = session;
        this.entityName = entityName;
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

        Object result=null;
        Logs.traceIfEnabled(LOG,"Criteria {} start, entity name : {}", method.getName(),entityName);

        List<String> mdToAuthorize = new ArrayList<String>();
        mdToAuthorize.add("list");
        mdToAuthorize.add("uniqueResult");

//        if(mdToAuthorize.contains(method.getName())){
//            addAuthorizationCriteria();
//        }

        //执行方法
        result=method.invoke(criteria, args);

        Logs.traceIfEnabled(LOG, "Criteria {} end", method.getName());
        return result;
    }

    /**
     * Authorization plugin in here.
     */
    private void addAuthorizationCriteria(){
        Logs.traceIfEnabled(LOG,"查询对象 {} ", criteria.toString());

//        if(Company.class.getName().equals(entityName)){
//
//            String namePropertyOfUser = "companyName";
//            String nameValueOfUser = "%tom_at%";
//            Criterion nameCriterion = Restrictions.like(namePropertyOfUser,nameValueOfUser);
//
//            criteria.add(nameCriterion);
//        }
    }
}
