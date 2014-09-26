package org.cam.proxy.hibernate;

import org.hibernate.Session;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class SQLQueryFilterImpl extends AbstractQueryFilter {

    @Override
    public String filterQueryString(Session session, String source) {

        return source;
    }
}
