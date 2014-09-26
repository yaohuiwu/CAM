package org.cam.proxy.hibernate;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.CoreDAO;
import org.cam.core.FactoryHelper;
import org.cam.core.Logs;
import org.cam.core.ObjectUtils;
import org.cam.core.meta.domain.Permission;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class SQLQueryFilterImpl extends AbstractQueryFilter {

    private static final Logger logger = LoggerFactory.getLogger(SQLQueryFilterImpl.class);

    private static final String FROM_REG = "from\\s+((\\w+)(\\s+(\\w+)?!where)?(,(\\w+)(\\s+(\\w+)?!where)?)*)";
    private static final Pattern FROM_PATTERN = Pattern.compile(FROM_REG);

    private CoreDAO coreDAO;

    public SQLQueryFilterImpl(CoreDAO coreDAO) {
        this.coreDAO = coreDAO;
    }

    @Override
    public String filterQueryString(Session session, String source) {

        List<TableIdentity> tableIdentities = extractTableIdentities(source);
//        Iterator<TableIdentity> it = tableIdentities.iterator();
//
//        String tmp = source;
//        while(it.hasNext()){
//            TableIdentity identity = it.next();
//            List<Permission> permissions = coreDAO.getPermissionsOfUserByObjectType(
//                    FactoryHelper.currentUser(),
//                    identity.getEntity());
//            String sqlCriteria = toSqlCriteria(permissions);
//            //replace table name with sqlCriteria.
//            tmp = StringUtils.replacePattern(tmp,
//                    ObjectUtils.getWordRegex(identity.getName()),
//                    toSecurityView(sqlCriteria));
//        }
        return source;
    }

    /**
     * Extract tables mentioned in source sql.
     *
     * @param sourceSql
     * @return
     */
    protected List<TableIdentity> extractTableIdentities(String sourceSql){
        String tmp = StringUtils.replacePattern(sourceSql,"\\s*,\\s*",",");
        Matcher m = FROM_PATTERN.matcher(tmp);

        Set<String> tableSet = Sets.newHashSet();
        while(m.find()){
            String[] parts = StringUtils.split(m.group(1), ',');
            tableSet.addAll(Arrays.asList(parts));
        }
        Logs.debugIfEnabled(logger,"Table {} found in sql [{}]",tableSet,sourceSql);

        List<TableIdentity> identities = Lists.newArrayList();
        Iterator<String> iterator = tableSet.iterator();
        while (iterator.hasNext()){
            String tableName = iterator.next();
            TableIdentity identity = new TableIdentity(null,tableName);
            identities.add(identity);
        }
        return identities;
    }

    protected String toSqlCriteria(List<Permission> permissions){
        return null;
    }

    protected String toSecurityView(String sqlCriteria){
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append(sqlCriteria);
        s.append(")");
        return s.toString();
    }


}
