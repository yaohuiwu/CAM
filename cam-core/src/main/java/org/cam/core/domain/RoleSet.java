package org.cam.core.domain;

import com.google.common.collect.Sets;
import org.cam.core.cache.Copyable;

import java.util.Set;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class RoleSet implements Copyable{

    private Set<String> roleIdSet;

    public RoleSet(Set<String> roleIdSet) {
        this.roleIdSet = roleIdSet;
    }

    public Set<String> getRoleIdSet() {
        return roleIdSet;
    }

    @Override
    public Copyable copy() {
        Set<String> setCpy = Sets.newHashSet();
        setCpy.addAll(roleIdSet);
        return new RoleSet(setCpy);
    }
}
