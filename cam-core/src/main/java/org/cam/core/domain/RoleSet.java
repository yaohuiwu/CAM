package org.cam.core.domain;

import java.util.Set;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class RoleSet extends StringSet{

    public RoleSet() {
    }

    public RoleSet(Set<String> roleIdSet) {
        super(roleIdSet);
    }
}
