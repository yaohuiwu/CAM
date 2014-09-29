package org.cam.core.parser;

import org.cam.core.Executable;
import org.cam.core.domain.Permission;

import java.util.List;
import java.util.Map;

/**
 * Created by yaohui on 14-9-21.
 */
public interface PermissionEvaluator {

    /**
     * Decide if the object is authorized by given permission.
     *
     *
     * @param object
     *         a plain java bean to be accessed.
     * @param permission
     *         permission given to someone.
     * @return
     *         true if permission is passed , otherwise false.
     */
    public boolean isPermit(Object object, String permission);

    /**
     * Is given executable permit by given permission.
     *
     * @param executable
     * @param permission
     * @return true if it is permit , otherwise false
     */
    public boolean isPermit(Executable executable, Permission permission);

    /**
     * Decide if given executable is permit by any of given permissions.
     *
     * @param executable
     * @param permissions
     * @return
     */
    public boolean isAnyPermit(Executable executable,List<Permission> permissions);

    /**
     * Convert permissions to sql criteria.
     *
     * @param fieldColumnMap
     * @param permissions
     * @return
     */
    public String toSqlCriteria(Map<String,String> fieldColumnMap , List<Permission> permissions);

}
