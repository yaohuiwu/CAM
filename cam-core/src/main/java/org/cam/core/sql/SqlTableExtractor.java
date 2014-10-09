package org.cam.core.sql;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract tables from sql dml statement.
 */
public class SqlTableExtractor {

    private static final Logger LOG = LoggerFactory.getLogger(SqlTableExtractor.class);

    private static final String FROM_PATTERN_STRING = "from(\\s+\\w+(\\s+\\w+)?(\\s*,\\s*\\w+(\\s+\\w+)?)*)";
    private static final Pattern FROM_PATTERN = Pattern.compile(FROM_PATTERN_STRING);

    /**
     * Extract tables mentioned in source sql.
     *
     * @param sourceSql
     * @return
     */
    public Set<TableSegment> extractTableIdentities(String sourceSql){
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
}
