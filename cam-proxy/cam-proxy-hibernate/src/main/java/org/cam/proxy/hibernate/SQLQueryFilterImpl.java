package org.cam.proxy.hibernate;

import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.core.parser.DefaultPermissionEvaluator;
import org.cam.core.parser.PermissionEvaluator;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-9-24.
 */
@Deprecated
public class SQLQueryFilterImpl extends AbstractQueryFilter {

    private static final Logger LOG = LoggerFactory.getLogger(SQLQueryFilterImpl.class);

    private CamService camService ;
    private PermissionEvaluator evaluator;

    public SQLQueryFilterImpl() {
        evaluator = new DefaultPermissionEvaluator();
        camService = FactoryHelper.factory().getService();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String filterQueryString(Session session, String source) {
        return source;
    }


}
