package org.cam.core.mapping;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by wuyaohui on 14-10-2.
 */
public class EntityMapping {

    private String name;
    private BiMap<String,String> fieldColumnMap;

    public EntityMapping() {
        fieldColumnMap = HashBiMap.create();
    }

//    public EntityMapping(String name, Map<String, String> fieldColumnMap) {
//        this.name = name;
//        this.fieldColumnMap = fieldColumnMap;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setFieldColumnMap(Map<String, String> fieldColumnMap) {
//        this.fieldColumnMap = fieldColumnMap;
//    }

    public String getName() {
        return name;
    }

    public Map<String, String> getFieldColumnMap() {
        return fieldColumnMap;
    }

    public String fieldToColumn(String fieldName){
        return fieldColumnMap.get(fieldName);
    }

    public String columnToField(String columnName){
        return fieldColumnMap.inverse().get(columnName);
    }
}
