package org.cam.proxy.hibernate;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.CoreDAO;
import org.cam.core.FactoryHelper;
import org.cam.core.Logs;
import org.cam.core.ObjectUtils;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.meta.domain.Permission;
import org.cam.core.meta.domain.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.PersistentClass;
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

        Set<String> tableSet = extractTableIdentities(source);
        Logs.debugIfEnabled(logger,"Table {} found in sql [{}]",tableSet,source);
        Iterator<String> it = tableSet.iterator();

        //Mock permission
        List<Permission> permissions = Lists.newArrayList();
        Permission per = new Permission();
        per.setCriteria("country = 'China'");
        permissions.add(per);


        String tmp = source;
        Configuration cfg = HibernateHelper.getConfiguration();
        User currentUser = FactoryHelper.currentUser();
        while(it.hasNext()){
            String table = it.next();
            PersistentClass pClass = getPersistClassByTable(table, cfg);
            //table name to entity name
            String entity = pClass.getEntityName();

//            List<Permission> permissions = coreDAO.getPermsOfUserByActionAndObjectType(
//                    currentUser, ExecutableType.VIEW.toString(), entity);

            StringBuilder sqlCriteria = new StringBuilder();
            if(permissions!=null){
                Iterator<Permission> permIt = permissions.iterator();
                while(permIt.hasNext()){
                    Permission perm = permIt.next();
                    sqlCriteria.append("(");
                    sqlCriteria.append(perm.getCriteria());
                    sqlCriteria.append(")");
                    if(permIt.hasNext()){
                        sqlCriteria.append(" or ");
                    }
                }
            }
            //replace table name with sqlCriteria.
            tmp = StringUtils.replacePattern(tmp,
                    ObjectUtils.getWordRegex(table),
                    toSecurityView(table,sqlCriteria.toString()));
        }
        Logs.debugIfEnabled(logger,"sql with security view [{}]",tmp);
        return tmp;
    }

    protected PersistentClass getPersistClassByTable(String table,Configuration cfg){
        PersistentClass rClass = null;
        Iterator<PersistentClass> mappings =  cfg.getClassMappings();
        while(mappings.hasNext()){
            PersistentClass pClass = mappings.next();
            if(table.equals(pClass.getTable().getName())){
                rClass = pClass;
                break;
            }
        }
        return rClass;
    }

    /**
     * Extract tables mentioned in source sql.
     *
     * @param sourceSql
     * @return
     */
    protected Set<String> extractTableIdentities(String sourceSql){
        String tmp = StringUtils.replacePattern(sourceSql,"\\s*,\\s*",",");
        Matcher m = FROM_PATTERN.matcher(tmp);

        Set<String> tableSet = Sets.newHashSet();
        while(m.find()){
            String[] parts = StringUtils.split(m.group(1), ',');
            tableSet.addAll(Arrays.asList(parts));
        }
        return tableSet;
    }

    protected String toSecurityView(String table,String sqlCriteria){
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append("select * from ");
        s.append(table);
        if(sqlCriteria!=null&&sqlCriteria.length()>0){
            s.append(" where ");
            s.append(sqlCriteria);
        }
        s.append(")");
        s.append(" a");
        return s.toString();
    }


}
