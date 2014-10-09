package org.cam.core.sql;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Segment of sql.
 */
public class SqlSegment {

    protected int index ;
    protected String originalString ;

    public SqlSegment() {
    }

    public SqlSegment(String originalString,int index) {
        if( originalString==null || index < 0){
            throw new IllegalArgumentException("null originalString or negative index.");
        }
        this.originalString = originalString;
        this.index = index;
    }

    public int getLength(){
        return StringUtils.length(this.originalString);
    }

    public int getIndex() {
        return index;
    }

    public String getOriginalString() {
        return originalString;
    }

    @Override
    public String toString() {
        return "SqlSegment{" +
                "index=" + index +
                ", originalString='" + originalString + '\'' +
                '}';
    }

    public String toSqlString(){
        return getOriginalString();
    }
}
