package org.cam.proxy.hibernate;

import org.cam.core.FactoryHelper;
import org.cam.core.domain.User;
import org.cam.core.mapping.EntityTableMapping;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.Map;

/**
 * Abstract
 *
 *
 */
public abstract class AbstractQueryFilter implements QueryFilter{

    @Override
    public String filterQueryString(Session session, String source) {
        return source;
    }

    /**
     * Replace entity of hql with security view.
     *
     * @param sourceHql original hql
     * @param replacements key is entities , value is security entities view.
     * @return
     */
    protected String replaceUnSecurityEntities(String sourceHql, Map<String,String> replacements){
        String tmp = sourceHql;
        if(replacements!=null){
            Iterator<Map.Entry<String,String>> it = replacements.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String,String> replaceItem = it.next();
                //TODO problem code
                tmp = tmp.replaceAll(replaceItem.getKey(), "("+replaceItem.getValue()+")");
            }
        }
        return tmp;
    }

    protected String getEntityNameByTable(String tableName){
        EntityTableMapping entityTableMapping = FactoryHelper.factory().getEntityTableMapping();
        return entityTableMapping.getEntityNameByTable(tableName);
    }

    protected User getCurrentUser(){
        return FactoryHelper.currentUser();
    }
}
