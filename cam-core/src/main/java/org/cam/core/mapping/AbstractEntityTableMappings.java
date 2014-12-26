package org.cam.core.mapping;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wuyaohui on 14-10-2.
 */
public abstract class AbstractEntityTableMappings implements EntityTableMapping{

    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final int DEFAULT_EXCEPTED_ENTITY_NUM = 60;

    /**
     * entity <--> table
     */
    protected BiMap<String,String> entityTableMap;

    protected Map<String,EntityMapping> entityMappingMap;

    public AbstractEntityTableMappings(){
        entityTableMap = HashBiMap.create(DEFAULT_EXCEPTED_ENTITY_NUM);
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

    @Override
    public Map<String,String> convertToColumns(String entityName, String... fields) {
        EntityMapping entityMapping = getEntityWithCheck(entityName);

        Map<String,String> columnMap = Maps.newHashMap();
        if(fields!=null&&fields.length>0){
            for(String field : fields){
                String column = entityMapping.fieldToColumn(field);
                columnMap.put(field,column);
            }
        }
        return columnMap;
    }

    @Override
    public String convertToColumn(String entityName, String field) {
        EntityMapping entityMapping = getEntityWithCheck(entityName);
        return entityMapping.fieldToColumn(field);
    }

    @Override
    public String[] convertToColumn(String entityName, String[] fields) {
        EntityMapping entityMapping = getEntityWithCheck(entityName);

        List<String> columns = Lists.newArrayList();
        if(fields!=null&&fields.length>0){
            for (String field : fields){
                String column = entityMapping.fieldToColumn(field);
                if(field!=null){
                    columns.add(column);
                }else{
                    throw new IllegalStateException("Invalid field:"+field+" of entity:"+entityName
                            +" . No column defined for field:"+field);
                }
            }
        }
        return columns.toArray(EMPTY_STRING_ARRAY);
    }

    @Override
    public String[] getStringFields(String entityName) {
        EntityMapping entityMapping = getEntityWithCheck(entityName);

        List<String> stringFields = Lists.newArrayList();
        Map<String,EntityField> fields = entityMapping.getFieldMap();
        Iterator<EntityField> it = fields.values().iterator();
        while(it.hasNext()){
            EntityField entityField = it.next();
            if(String.class.getName().equals(entityField.getType())){
                stringFields.add(entityField.getName());
            }
        }

        return stringFields.toArray(new String[0]);
    }

    @Override
    public String[] getStringColumns(String entityName) {
        EntityMapping entityMapping = getEntityWithCheck(entityName);

        List<String> stringColumns = Lists.newArrayList();
        Map<String,EntityField> fields = entityMapping.getFieldMap();
        Map<String,String> fieldColumnMp = entityMapping.getFieldColumnMap();

        Iterator<EntityField> it = fields.values().iterator();
        while(it.hasNext()){
            EntityField entityField = it.next();
            if(String.class.getName().equals(entityField.getType())){
                String columnName = fieldColumnMp.get(entityField.getName());
                stringColumns.add(columnName);
            }
        }

        return stringColumns.toArray(new String[0]);
    }

    private EntityMapping getEntityWithCheck(String entityName){
        EntityMapping entityMapping = getEntity(entityName);
        if(entityMapping==null){
            throw new IllegalArgumentException("No mapping exists for entity " + entityName);
        }
        return entityMapping;
    }
}
