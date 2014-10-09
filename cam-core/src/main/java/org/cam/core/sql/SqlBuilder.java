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
        if(sqlSegment instanceof TableRefsSegment){
            TableRefsSegment tableRef = (TableRefsSegment)sqlSegment;
            if(tableRef.getSecurityView()!=null){
                s.append(tableRef.getSecurityView());
            }else{
                throw new IllegalStateException("TableRefsSegment "+tableRef+" has not been prepared.");
            }
        }else{
            s.append(sqlSegment.getOriginalString());
        }
        return this ;
    }

    @Override
    public String toString() {
        return s.toString();
    }
}
