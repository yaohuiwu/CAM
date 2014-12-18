package org.cam.core.mapping;

import java.util.Map;
import java.util.Set;

/**
 * Created by wuyaohui on 14-10-2.
 */
public interface EntityTableMapping {

    /**
     * Table name -> entity name.
     *
     * @param tableName
     * @return
     */
    public String getEntityNameByTable(String tableName);

    /**
     * Entity name -> table name.
     *
     * @param entityName
     * @return
     */
    public String getTableNameByEntity(String entityName);

    /**
     * Get Entity by table name.
     *
     * @param tableName
     * @return
     */
    public EntityMapping getEntityByTable(String tableName);

    /**
     * Get Table by entity name.
     *
     * @param entityName
     * @return
     */
    public Table getTableByEntity(String entityName);

    /**
     * Get entity.
     *
     * @param entityName
     * @return
     */
    public EntityMapping getEntity(String entityName);

    /**
     * Get table.
     *
     * @param tableName
     * @return
     */
    public Table getTable(String tableName);

    /**
     * Convert fields of entity to columns.
     *
     * @param entityName 实体名
     * @param fields 属性名列表
     * @return key: field   value: column
     */
    public Map<String,String> convertToColumns(String entityName,String... fields);

    /**
     * Convert one field of an entity to column.
     *
     * @param entityName
     * @param field
     * @return
     */
    public String convertToColumn(String entityName,String field);

    /**
     * Convert one field of an entity to column.
     *
     * @param entityName
     * @param fields
     * @return
     */
    public String[] convertToColumn(String entityName,String[] fields);

}
