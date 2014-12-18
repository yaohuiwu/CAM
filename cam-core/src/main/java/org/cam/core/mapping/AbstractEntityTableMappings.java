package org.cam.core.mapping;

import com.google.common.collect.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wuyaohui on 14-10-2.
 */
public abstract class AbstractEntityTableMappings implements EntityTableMapping{

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

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

    @Override
    public Map<String,String> convertToColumns(String entityName, String... fields) {
        EntityMapping entityMapping = getEntity(entityName);
        if(entityMapping==null){
            throw new IllegalArgumentException("No mapping exists for entity "+entityName);
        }

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
        EntityMapping entityMapping = getEntity(entityName);
        if(entityMapping==null){
            throw new IllegalArgumentException("No mapping exists for entity "+entityName);
        }
        return entityMapping.fieldToColumn(field);
    }

    @Override
    public String[] convertToColumn(String entityName, String[] fields) {
        EntityMapping entityMapping = getEntity(entityName);
        if(entityMapping==null){
            throw new IllegalArgumentException("No mapping exists for entity "+entityName);
        }

//        Map<String,String> columnMap = Maps.newHashMap();
        List<String> columns = Lists.newArrayList();
        if(fields!=null&&fields.length>0){
            for(String field : fields){
                String column = entityMapping.fieldToColumn(field);
//                columnMap.put(field,column);
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
}
