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
//    private SqlTableExtractor extractor;

    public SQLQueryFilterImpl() {
        evaluator = new DefaultPermissionEvaluator();
        camService = FactoryHelper.factory().getService();
//        extractor = new SqlTableExtractor();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String filterQueryString(Session session, String source) {

//        Set<TableSegment> tableSet = extractor.extractTableIdentities(source);
//        LOG.debug("Table {} found in sql [{}]",tableSet,source);
//        Iterator<TableSegment> it = tableSet.iterator();
//
//        String tmp = source;
//        while(it.hasNext()){
//            TableSegment table = it.next();
//            String entityName = getEntityNameByTable(table.getName());
//
//            List<Permission> permissions = camService.getPermissionOfUser(
//                    getCurrentUser(), ExecutableType.VIEW.toString(), entityName);
//            if(permissions.isEmpty()){
//                throw new ActionNotAllowedException("");
//            }
//            String sqlCriteria = evaluator.toSqlCriteria(permissions);
//            if(sqlCriteria==null){
//                throw new CamException("security criteria view can't be null");
//            }
//            if(!ParserUtil.isAll(sqlCriteria)){
//                //replace table name with sqlCriteria.
//                tmp = StringUtils.replacePattern(
//                        tmp,
//                        ObjectUtils.getWordRegex(table.getName()),
//                        toSecurityView(table,sqlCriteria));
//            }
//        }
//        LOG.debug("query with security view [{}]",tmp);
        return source;
    }

//    protected String toSecurityView(TableSegment table,String sqlCriteria){
//        StringBuilder s = new StringBuilder();
//        s.append("(");
//        s.append("select * from ");
//        s.append(table.getName());
//        if(sqlCriteria!=null&&sqlCriteria.length()>0){
//            s.append(" where ");
//            s.append(sqlCriteria);
//        }
//        s.append(")");
//
//        if(table.hasNoAlias()){
//            //give an alias for you
//            s.append(" ");
//            s.append(table.createDefaultAlias());
//        }
//        return s.toString();
//    }

}
