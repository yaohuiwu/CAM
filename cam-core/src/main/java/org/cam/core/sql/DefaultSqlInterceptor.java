package org.cam.core.sql;

import org.cam.core.CamException;
import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.cam.core.exception.ActionNotAllowedException;
import org.cam.core.mapping.EntityTableMapping;
import org.cam.core.parser.DefaultPermissionEvaluator;
import org.cam.core.parser.PermissionEvaluator;
import org.cam.core.util.SqlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DefaultSqlInterceptor implements SqlInterceptor{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSqlInterceptor.class);
    private SqlTableRefRecognizer tableRefRecognizer ;
    private CamService camService ;
    private PermissionEvaluator evaluator;

    public DefaultSqlInterceptor(CamService camService) {
        this.camService = camService;
        evaluator = new DefaultPermissionEvaluator();
        tableRefRecognizer = new SqlTableRefRecognizer();
    }

    @Override
    public String intercept(String originalSql) {
        if(!tableRefRecognizer.isSelect(originalSql)){
            return originalSql;
        }

        SqlBuilder sqlBuilder = new SqlBuilder();
        EntityTableMapping entityTableMapping = FactoryHelper.factory().getEntityTableMapping();

        List<SqlSegment> sqlSegments = tableRefRecognizer.analyze(originalSql);

        org.cam.core.CamConfiguration camConfiguration = FactoryHelper.configuration();

        for(SqlSegment sqlSegment : sqlSegments){
            if(sqlSegment instanceof TableRefsSegment){
                TableRefsSegment tableRefsSegment = (TableRefsSegment)sqlSegment;
                List<TableRef> tableRefs = tableRefsSegment.getTableRefList();
                if(tableRefs != null){
                    for(TableRef ref : tableRefs){
                        String entityName = entityTableMapping.getEntityNameByTable(ref.getName());
                        if(entityName==null){
                            if(camConfiguration.isAllowNoEntityOfTable()){
                                ref.setSecurityView(null);
                                LOG.trace("No entity related to table {}, create no security view.",
                                        ref.getName());
                                continue;
                            }else{
                                throw new ActionNotAllowedException("No entity related to table "
                                        +ref.getName()+", throws exception according to " +
                                        "'allowNoEntityOfTable' property["+ camConfiguration.isAllowNoEntityOfTable()
                                        +"] of CamConfiguration");
                            }
                        }

                        List<Permission> permissions = camService.getPermissionOfUser(
                                FactoryHelper.currentUser(), ExecutableType.VIEW.toString(), entityName);
                        if(permissions.isEmpty()){
                            if(FactoryHelper.configuration().isPassWithNoPermission()){
                                ref.setSecurityView(null);
                            }else{
                                throw new ActionNotAllowedException("Action["+ExecutableType.VIEW.toString()+"]" +
                                        " objectType["+entityName+"]" +
                                        " of user["+FactoryHelper.currentUser()+"] is not allowed");
                            }
                        }
                        String sqlCriteria = evaluator.toSqlCriteria(permissions);
                        if(sqlCriteria==null){
                            throw new CamException("security criteria view can't be null");
                        }
//                        String sqlCriteria = getSqlCriteria(entityName);
                        ref.setSecurityView(sqlCriteria);
                    }
                }
            }
            sqlBuilder.append(sqlSegment);
        }
        String interceptedSql = sqlBuilder.toString();
        LOG.debug("{}", SqlUtils.sqlForShort(interceptedSql));
        return interceptedSql;

    }

    private String getSqlCriteria(String entity){
        List<Permission> permissions = camService.getPermissionOfUser(
                FactoryHelper.currentUser(), ExecutableType.VIEW.toString(), entity);
        if(permissions.isEmpty()){
            throw new ActionNotAllowedException("");
        }
        String sqlCriteria = evaluator.toSqlCriteria(permissions);
        if(sqlCriteria==null){
            throw new CamException("security criteria view can't be null");
        }
        return sqlCriteria ;
    }
}
