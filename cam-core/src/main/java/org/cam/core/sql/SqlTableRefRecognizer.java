package org.cam.core.sql;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Recognize all table references in a sql.
 */
public class SqlTableRefRecognizer {

    private static final Logger LOG = LoggerFactory.getLogger(SqlTableRefRecognizer.class);
    private static final String FROM_PATTERN_STRING = "from(\\s+\\w+(\\s+\\w+)?(\\s*,\\s*\\w+(\\s+\\w+)?)*)";

    public TableRef[] recognize(String sql){
        List<TableRef> refs = Lists.newArrayList();
        if(isSelect(sql)){
            //TODO deal with select sql.
        }
        return refs.toArray(new TableRef[0]);
    }

    public boolean isSelect(String sql){
        String tmp = StringUtils.trim(sql);
        return StringUtils.startsWithIgnoreCase(tmp,"select");
    }

    public boolean isUpdate(String sql){
        String tmp = StringUtils.trim(sql);
        return StringUtils.startsWithIgnoreCase(tmp,"update");
    }

    public boolean isDelete(String sql){
        String tmp = StringUtils.trim(sql);
        return StringUtils.startsWithIgnoreCase(tmp,"update");
    }

}
