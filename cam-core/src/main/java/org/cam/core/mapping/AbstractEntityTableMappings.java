package org.cam.core.mapping;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by wuyaohui on 14-10-2.
 */
public abstract class AbstractEntityTableMappings implements EntityTableMapping{

    /**
     * entity <--> table
     */
    protected BiMap<String,String> entityTableMap;

    protected Map<String,EntityMapping> entityMappingMap;

    public AbstractEntityTableMappings(){
        entityTableMap = HashBiMap.create(60);
        entityMappingMap = Maps.newConcurrentMap();
    }

    @Override
    public String getEntityNameByTable(String tableName) {
        return entityTableMap.inverse().get(tableName);
    }

    @Override
    public String getTableNameByEntity(String entityName) {
        return entityTableMap.get(entityName);
    }

    @Override
    public EntityMapping getEntityByTable(String tableName) {
        return getEntity(getEntityNameByTable(tableName));
    }

    @Override
    public Table getTableByEntity(String entityName) {
        return null;
    }

    @Override
    public EntityMapping getEntity(String entityName) {
        return entityMappingMap.get(entityName);
    }

    @Override
    public Table getTable(String tableName) {
        return null;
    }
}
