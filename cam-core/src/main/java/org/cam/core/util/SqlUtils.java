package org.cam.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sql related utils.
 */
public class SqlUtils {

    private static Pattern PTN_SQL_IN = Pattern.compile("([iI][nN])(\\s*)\\((.+?)\\)");
    private static final int LONG_LIST_GROUP_NUM = 3;
    private static final int LONG_LIST_LENGTH = 300;
    private static final int SPACE_GROUP_NUM = 2;

    private SqlUtils() {
    }

    /**
     * Get a short version sql if it is too long. Commonly used for log.
     *
     * @param sql
     * @return
     */
    public static String sqlForShort(String sql){
        Matcher matcher = PTN_SQL_IN.matcher(sql);
        StringBuilder shortSql = new StringBuilder();

        int lastStart = 0;
        while (matcher.find()){
            shortSql.append(sql.substring(lastStart,matcher.start()));
            if(matcher.group(LONG_LIST_GROUP_NUM).length() > LONG_LIST_LENGTH){
                shortSql.append(matcher.group(1));
                shortSql.append(matcher.group(SPACE_GROUP_NUM));
                shortSql.append("(...)");
            }else{
                shortSql.append(matcher.group(0));
            }
            lastStart = matcher.end();
        }
        if(lastStart == 0){
            return sql;
        }else{
            if(lastStart < sql.length()){
                shortSql.append(sql.substring(lastStart));
            }
        }
        return shortSql.toString();
    }
}
