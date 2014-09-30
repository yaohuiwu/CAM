package org.cam.core.domain;

import java.util.Set;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class PermissionSet extends StringSet{

    public PermissionSet() {
    }

    public PermissionSet(Set<String> roleIdSet) {
        super(roleIdSet);
    }
}
