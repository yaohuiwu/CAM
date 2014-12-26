package org.cam.proxy.hibernate;

import org.hibernate.Session;

public abstract class AbstractQueryFilter implements QueryFilter{

    @Override
    public String filterQueryString(Session session, String source) {
        return source;
    }

}
