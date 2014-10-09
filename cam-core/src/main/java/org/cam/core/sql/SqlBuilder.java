package org.cam.core.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(SqlBuilder.class);
    private StringBuilder s ;

    public SqlBuilder() {
        s = new StringBuilder();
    }

    public SqlBuilder append(SqlSegment sqlSegment){
        if(sqlSegment==null){//ignored
            LOG.warn("null sqlSegment");
            return this ;
        }
        s.append(sqlSegment.toSqlString());
        return this ;
    }

    @Override
    public String toString() {
        return s.toString();
    }
}
