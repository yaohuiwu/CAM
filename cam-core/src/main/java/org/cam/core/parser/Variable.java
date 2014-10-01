package org.cam.core.parser;

import org.cam.core.cache.Copyable;

/**
 * 权限表达式中的变量
 */
public class Variable implements Copyable{

    private String name;
    private String type;
    private String valueType;
    private Object value;

    public Variable() {
    }

    public Variable(String name, String type, String valueType, Object value) {
        this.name = name;
        this.type = type;
        this.valueType = valueType;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public Copyable copy() {
        Variable var = new Variable();
        var.setName(this.name);
        var.setType(this.type);
        var.setValueType(this.valueType);
        var.setValue(this.value);

        return var;
    }
}
