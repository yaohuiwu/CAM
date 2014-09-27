package org.cam.core.mock;

import com.google.common.collect.Lists;
import org.cam.core.CoreDAO;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.meta.domain.Authorization;
import org.cam.core.meta.domain.Permission;
import org.cam.core.meta.domain.Role;
import org.cam.core.meta.domain.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by wuyaohui on 14-9-27.
 */
public class MockDaoImpl implements CoreDAO{

    private DataSource ds;

    public MockDaoImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Authorization> getAllAuthorization() {
        return null;
    }

    @Override
    public List<Permission> getPermissionsOfUser(User user) {
        return null;
    }

    @Override
    public List<Permission> getPermissionsOfUserByObjectType(User user, String objectType) {
        return null;
    }

    @Override
    public List<Permission> getPermsOfUserByActionAndObjectType(User user, String action, String objectType) {
        List<Permission> permList = Lists.newArrayList();

        Permission per = new Permission(action,objectType,"country = 'China'");
        permList.add(per);

        return permList;
    }

    @Override
    public List<Permission> getAllPermission() {
        return null;
    }

    @Override
    public List<Permission> getPermissionsOf(Role role) {
        return null;
    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public int createRole(Role role) {
        return 0;
    }

    @Override
    public boolean updateRole(Role role) {
        return false;
    }

    @Override
    public List<Role> getRolesOfUser(String userId) {
        return null;
    }
}
