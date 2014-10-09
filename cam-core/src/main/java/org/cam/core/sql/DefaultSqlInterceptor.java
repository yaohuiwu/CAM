package org.cam.core.sql;

/**
 * Created by wuyaohui on 14-10-9.
 */
public class DefaultSqlInterceptor implements SqlInterceptor{

    private SqlTableRefRecognizer tableRefRecognizer = new SqlTableRefRecognizer();

    @Override
    public String intercept(String originalSql) {
        String modifiedSql = null;
        if(tableRefRecognizer.isSelect(originalSql)){



            return modifiedSql;
        }else{
            return originalSql ;
        }
    }
}
