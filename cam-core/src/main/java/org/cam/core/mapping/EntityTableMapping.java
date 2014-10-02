package org.cam.core.mapping;

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
}
