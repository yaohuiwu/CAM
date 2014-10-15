package org.cam.core.sql;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Recognize all table references in a sql.
 */
public class SqlTableRefRecognizer {

    private static final Logger LOG = LoggerFactory.getLogger(SqlTableRefRecognizer.class);
//    private static final String FROM_PATTERN_STRING = "from(\\s+\\w+(\\s+\\w+)?(\\s*,\\s*\\w+(\\s+\\w+)?)*)";
//    public static final String FROM_REGEX = "([Ff][Rr][Oo][Mm]\\s+)(\\w+((\\s+[Aa][Ss])?\\s+\\w+)?(\\s*,\\s*\\w+((\\s+[Aa][Ss])?\\s+\\w+)?)*)";
    public static final String FROM_REGEX = "(([Ff][Rr][Oo][Mm]\\s+)|([Jj][Oo][Ii][Nn])\\s+)(\\w+((\\s+[Aa][Ss])?\\s+\\w+)?(\\s*,\\s*\\w+((\\s+[Aa][Ss])?\\s+\\w+)?)*)";

    /**
     * Split sql to segments by tableRef.
     *
     * @param sql
     * @return
     */
    public List<SqlSegment> analyze(String sql){
        if(sql == null || sql.isEmpty()){
            throw new IllegalArgumentException("null or empty sql.");
        }
        List<SqlSegment> segments = Lists.newArrayList();
        if(isSelect(sql)){
            Pattern fromPtn = Pattern.compile(FROM_REGEX);
            Matcher matcher = fromPtn.matcher(sql);

            int lastMatchIndex = 0;
            while (matcher.find()){
                int start = matcher.start() + matcher.group(1).length();
                int end = matcher.end();

                String prefixSql = sql.substring(lastMatchIndex, start);
                SqlSegment prefixSegment = new SqlSegment(prefixSql,lastMatchIndex);
                segments.add(prefixSegment);

                String tableSegStr = matcher.group(4);
                if(StringUtils.endsWithIgnoreCase(tableSegStr,"where")){
                    tableSegStr = removeWhere(tableSegStr);
                    end -= 5;
                    String endWhitespace = ObjectUtils.endWhitespace(tableSegStr);
                    end -= endWhitespace.length();
                }
                String tableRefsString  = StringUtils.substring(sql,start,end);

                SqlSegment fromSegment = new TableRefsSegment(tableRefsString,start);
                LOG.trace("{}",fromSegment);
                segments.add(fromSegment);

                lastMatchIndex = end;
            }
            if(lastMatchIndex < sql.length()){
                String endString = StringUtils.substring(sql,lastMatchIndex);
                segments.add(new SqlSegment(endString,lastMatchIndex));
            }
        }
        return segments;
    }

    public String removeWhere(String sql){
        return StringUtils.removeEndIgnoreCase(sql, "where");
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

    public boolean isInsert(String sql){
        String tmp = StringUtils.trim(sql);
        return StringUtils.startsWithIgnoreCase(tmp,"update");
    }

}
