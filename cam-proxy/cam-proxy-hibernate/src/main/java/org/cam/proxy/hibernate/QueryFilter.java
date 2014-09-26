package org.cam.proxy.hibernate;

import org.hibernate.Session;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface QueryFilter {

    public String filterQueryString(final Session session, String source);
}
