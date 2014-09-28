package org.cam.proxy.hibernate;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class TableSegment {

    private String name ;
    private String alias ;

    public TableSegment() {
    }

    public TableSegment(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean hasAlias(){
        return alias != null;
    }

    public boolean hasNoAlias(){
        return !hasAlias();
    }

    public String createDefaultAlias(){
        return hasNoAlias() ? name+"_alias" : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableSegment that = (TableSegment) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "TableSegment{" +
                "name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
