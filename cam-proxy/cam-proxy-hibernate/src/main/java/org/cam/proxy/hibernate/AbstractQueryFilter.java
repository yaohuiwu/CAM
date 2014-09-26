package org.cam.proxy.hibernate;

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
}
