package org.cam.core.dao;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A {@link org.cam.core.dao.CamDao} implementation using ehcache as cache layer and RDBMS as SOR.
 *
 */
public class CamDaoImpl implements CamDao{

    private CacheManager cacheMgr;

    private PersistentDao persistentDao;

    public CamDaoImpl() {
    }

    public CamDaoImpl(PersistentDao persistentDao) {
        this.persistentDao = persistentDao;
        cacheMgr = cacheMgr.getInstance();
    }

    @Override
    public Set<String> getCachedRolesOfUser(User user) {
        return null;
    }

    @Override
    public Set<Role> getAllRoleFromSor() {
        return null;
    }

    @Override
    public void cacheRolesOfUser(User user, Set<String> roles) {

    }

    @Override
    public Set<String> getPermissionIdsOfRole(String roleId) {
        return null;
    }

    @Override
    public Map<String, Set<String>> getPermissionsIdOfRoles(Set<String> roleSet) {
        return null;
    }

    @Override
    public Permission getSinglePermission(String permissionId) {
        return null;
    }

    @Override
    public List<Permission> getPermissionsOfRoles(Set<String> roleIdSet, String action, String objectType) {
        return null;
    }
}
