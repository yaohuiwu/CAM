package org.cbam.core.parser;

import org.cbam.core.meta.domain.Authorization;

import java.util.List;

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
     * Deal permission check for a list of object.
     *
     * @param objects
     * @param permission
     * @return true if all objects is permit , otherwise false
     */
    public boolean isPermit(List<Object> objects, String permission);

    /**
     * Decide if given object is permit by any of given permissions.
     *
     * @param object
     * @param permissions
     * @return
     */
    public boolean isPermit(Object object,List<String> permissions);

}
