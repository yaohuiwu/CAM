package org.cam.core.sql;

import org.apache.commons.lang3.StringUtils;

/**
 * Reference a table in sql statement.
 */
public class TableRef {

    private String originalString;

    private String name ;
    private String as ;
    private String alias ;
    private int index ;

    public TableRef() {
    }

    public TableRef(String originalString, int index) {

        if(originalString==null || index < 0){
            throw new IllegalArgumentException("null originalString or negative index.");
        }
        this.originalString = originalString;
        this.index = index ;

        String[] splits = StringUtils.split(originalString);
        if(splits.length==0){
            throw new IllegalArgumentException("empty originalString");
        }
        this.name = splits[0];

        if(splits.length > 1 ){
            if(splits.length > 2){
                this.as = splits[1];
                this.alias = splits[2];
            }else{
                this.alias = splits[1];
            }
        }
    }

    public String getOriginalString() {
        return originalString;
    }

    public String getName() {
        return name;
    }

    public String getAs() {
        return as;
    }

    public String getAlias() {
        return alias;
    }

    public int getIndex() {
        return index;
    }

    public int getLength(){
        return StringUtils.length(this.originalString);
    }
}
