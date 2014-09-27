package org.cam.proxy.hibernate;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.*;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.meta.domain.Permission;
import org.cam.core.meta.domain.User;
import org.cam.core.parser.DefaultPermissionEvaluator;
import org.cam.core.parser.ParserUtil;
import org.cam.core.parser.PermissionEvaluator;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Selectable;
import org.hibernate.property.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Member;
import java.util.*;
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
    private PermissionEvaluator evaluator;

    public SQLQueryFilterImpl(CoreDAO coreDAO) {
        this.coreDAO = coreDAO;
        evaluator = new DefaultPermissionEvaluator();
    }

    @Override
    public String filterQueryString(Session session, String source) {

        Set<String> tableSet = extractTableIdentities(source);
        Logs.debugIfEnabled(logger,"Table {} found in sql [{}]",tableSet,source);
        Iterator<String> it = tableSet.iterator();

        String tmp = source;
        Configuration cfg = HibernateHelper.getConfiguration();
        User currentUser = FactoryHelper.currentUser();
        while(it.hasNext()){
            String table = it.next();//有无别名？
            PersistentClass pClass = getPersistClassByTable(table, cfg);
            List<Permission> permissions = coreDAO.getPermsOfUserByActionAndObjectType(
                    currentUser, ExecutableType.VIEW.toString(), pClass.getEntityName());
            //TODO 可以放入缓存
            Map<String,String> fieldColumnMap = Maps.newHashMap();
            Iterator<Property> iterator = pClass.getPropertyIterator();
            while(iterator.hasNext()){
                Property p = iterator.next();
                Getter getter = p.getGetter(pClass.getMappedClass());
                Member member = getter.getMember();

                Iterator<Selectable> colIt = p.getColumnIterator();
                Selectable selectable = colIt.next();
                if(selectable instanceof Column){
                    Column col = (Column)selectable;
                    fieldColumnMap.put(ObjectUtils.getterField(member.getName()),col.getName());
                }
            }
            String sqlCriteria = evaluator.toSqlCriteria(fieldColumnMap,permissions);
            if(sqlCriteria==null){
                throw new CamException("security criteria view can't be null");
            }
            if(!ParserUtil.isAll(sqlCriteria)){
                //replace table name with sqlCriteria.
                tmp = StringUtils.replacePattern(
                        tmp,
                        ObjectUtils.getWordRegex(table),
                        toSecurityView(table,sqlCriteria));
            }
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
