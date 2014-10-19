package org.cam.core.performance;

import java.util.Collection;

/**
 * Created by wuyaohui on 14-10-19.
 */
public class QueryReporter {

    private String name ;
    private long cost ;
    private String queryStr;

    private Object result ;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public QueryReporter() {
    }

    public QueryReporter(String name, String queryStr) {
        this.name = name;
        this.queryStr = queryStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    @Override
    public String toString() {
        return "QueryReporter{" +
                "name='" + name + '\'' +
                ", cost(ms)=" + cost +
//                ", queryStr='" + queryStr + '\'' +
                ", result=" + (result instanceof Collection ? "list size:"+((Collection)result).size() : result) +
//                ", result=" + result +
                '}';
    }
}
