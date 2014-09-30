package org.cam.proxy.hibernate;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.CamException;
import org.cam.core.CamService;
import org.cam.core.FactoryHelper;
import org.cam.core.ObjectUtils;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.cam.core.domain.User;
import org.cam.core.exception.ActionNotAllowedException;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class SQLQueryFilterImpl extends AbstractQueryFilter {

    private static final Logger LOG = LoggerFactory.getLogger(SQLQueryFilterImpl.class);

//    private static final String FROM_REG = "from\\s+((\\w+)(\\s+(\\w+)?!where)?(,(\\w+)(\\s+(\\w+)?!where)?)*)";
    private static final String FROM_PATTERN_STRING = "from(\\s+\\w+(\\s+\\w+)?(\\s*,\\s*\\w+(\\s+\\w+)?)*)";
    private static final Pattern FROM_PATTERN = Pattern.compile(FROM_PATTERN_STRING);

    private CamService camService ;
    private PermissionEvaluator evaluator;

    public SQLQueryFilterImpl() {
        evaluator = new DefaultPermissionEvaluator();
        camService = FactoryHelper.factory().getService();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String filterQueryString(Session session, String source) {

        Set<TableSegment> tableSet = extractTableIdentities(source);
        LOG.debug("Table {} found in sql [{}]",tableSet,source);
        Iterator<TableSegment> it = tableSet.iterator();

        String tmp = source;
        Configuration cfg = HibernateHelper.getConfiguration();
        User currentUser = FactoryHelper.currentUser();
        while(it.hasNext()){
            TableSegment table = it.next();
            PersistentClass pClass = getPersistClassByTable(table.getName(), cfg);
            List<Permission> permissions = camService.getPermissionOfUser(
                    currentUser, ExecutableType.VIEW.toString(), pClass.getEntityName());
            if(permissions.isEmpty()){
                throw new ActionNotAllowedException("");
            }

            //TODO put in cache later.
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
                        ObjectUtils.getWordRegex(table.getName()),
                        toSecurityView(table,sqlCriteria));
            }
        }
        LOG.debug("query with security view [{}]",tmp);
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
    protected Set<TableSegment> extractTableIdentities(String sourceSql){
//        String tmp = StringUtils.replacePattern(sourceSql,"\\s*,\\s*",",");
        Set<TableSegment> tableSet = Sets.newHashSet();

        Matcher m = FROM_PATTERN.matcher(sourceSql);
        while(m.find()){
            // examples :
            // t_doc where
            // t_doc  d,t_user,t_app where
            // t_doc t
            if(m.group(1)==null){
                break;
            }
            String tmp = StringUtils.trim(m.group(1));
            tmp = StringUtils.removeEndIgnoreCase(tmp, "where");
            // t_doc |
            // t_doc  d,t_user,t_app |
            // t_doc t|
            tmp = StringUtils.trim(tmp);
            // first split by ,
            String[] splits_1 = StringUtils.split(tmp,",");
            if(splits_1.length == 0){
                LOG.error("pattern {} broken, fix it!", FROM_PATTERN_STRING);
                continue;
            }
            for(String split_1 : splits_1){
                String[] splits_2 = StringUtils.split(StringUtils.trim(split_1));
                if(splits_2.length==0){
                    LOG.error("pattern {} broken, fix it!",FROM_PATTERN_STRING);
                    continue;
                }
                TableSegment tableSeg = new TableSegment();
                tableSeg.setName(splits_2[0]);
                if(splits_2.length > 1){
                    tableSeg.setAlias(splits_2[1]);
                }
                // equals method already override.
                tableSet.add(tableSeg);
            }
        }
        return tableSet;
    }

    protected String toSecurityView(TableSegment table,String sqlCriteria){
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append("select * from ");
        s.append(table.getName());
        if(sqlCriteria!=null&&sqlCriteria.length()>0){
            s.append(" where ");
            s.append(sqlCriteria);
        }
        s.append(")");

        if(table.hasNoAlias()){
            //give an alias for you
            s.append(" ");
            s.append(table.createDefaultAlias());
        }
        return s.toString();
    }

}
