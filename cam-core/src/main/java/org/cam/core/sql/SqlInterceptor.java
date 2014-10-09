package org.cam.core.sql;

/**
 * Sql interceptor.
 */
public interface SqlInterceptor {

    /**
     * Intercept a sql to be executed.
     *
     * @param originalSql
     * @return originalSql or modifiedSql.
     */
    public String intercept(String originalSql);
}
