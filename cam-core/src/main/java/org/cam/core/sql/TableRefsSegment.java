package org.cam.core.sql;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wuyaohui on 14-10-9.
 */
public class TableRefsSegment extends SqlSegment{

    private List<TableRef> tableRefList ;

    private String securityView ;

    public String getSecurityView() {
        return securityView;
    }

    public void setSecurityView(String securityView) {
        this.securityView = securityView;
    }

    public TableRefsSegment(String originalString, int index) {
        super(originalString, index);
        tableRefList = Lists.newArrayList();

        String trimStr = StringUtils.trim(originalString);
        String[] splits = trimStr.split("\\s*,\\s*");
        for(String split : splits){
            TableRef ref = new TableRef(split);
            tableRefList.add(ref);
        }
    }

    public List<TableRef> getTableRefList() {
        return tableRefList;
    }

    public String toSqlString(){
        StringBuilder s = new StringBuilder();
        if(tableRefList!=null){
            Iterator<TableRef> it = tableRefList.iterator();
            while(it.hasNext()){
                TableRef tableRef = it.next();
                if(tableRef.getSecurityView()==null){
                    throw new IllegalStateException("security view of "+tableRef+" has not been created.");
                }
                s.append(tableRef.getSecurityView());
                if(it.hasNext()){
                    s.append(",");
                }
            }
        }
        return s.toString();
    }

}
