package org.cam.core.dao;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.dbutils.DbUtils;
import org.cam.core.CamException;
import org.cam.core.util.ObjectUtils;
import org.cam.core.util.ScriptRunner;
import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.PermissionSet;
import org.cam.core.domain.Role;
import org.cam.core.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class JdbcPersistentDaoImpl implements PersistentDao{

    private static final Logger LOG = LoggerFactory.getLogger(JdbcPersistentDaoImpl.class);

    private final DataSource dataSource ;

    public JdbcPersistentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isSorPrepared() {

        Set<String> camTables = Sets.newHashSet("cam_role","cam_permission","cam_authorization");
        StringBuilder s = new StringBuilder();
        s.append("SELECT count(TABLE_NAME) FROM information_schema.`TABLES`  where ");
        s.append("table_name in (");
        s.append(ObjectUtils.joinAsSqlIn(camTables));
        s.append(")");

        try(
           Connection con = dataSource.getConnection();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(s.toString());
        ){
            rs.next();
            Long camTableCount = rs.getLong(1);
            if(camTableCount.intValue() == camTables.size()){
                return true;
            }
        }catch (SQLException sqlE){
            throw new DataException("Error isSorPrepared",sqlE);
        }
        LOG.debug("CAM system table not exists.");
        return false;
    }

    @Override
    public void initializeSor() {
        if(isSorPrepared()){
            LOG.info("CAM schema is already prepared. Nothing will be done");
            return ;
        }
        LOG.info("Initializing CAM schema.");
        Connection con = null;
        try{
            con = dataSource.getConnection();
            ScriptRunner scriptRunner = new ScriptRunner(con);
            scriptRunner.runScript(getClass().getClassLoader().getResourceAsStream("cam_schema.sql"));
        }catch (SQLException sqlE){
            LOG.error("Error initializing Sor", sqlE);
        }finally {
            DbUtils.closeQuietly(con);
        }
        LOG.info("Initializing CAM schema successfully.");
    }

    @Override
    public List<Role> getAllRole() {
        List<Role> roles = Lists.newArrayList();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from cam_role");
            while(rs.next()){
                Role role = new Role();
                role.setId(rs.getString("id"));
                role.setName(rs.getString("name"));
                role.setUserCriteria(rs.getString("user_criteria"));
                roles.add(role);
            }
        }catch (SQLException sqlE){
            throw new DataException("error getting all roles",sqlE);
        }finally {
            DbUtils.closeQuietly(con,st,rs);
        }
        return roles;
    }

    @Override
    public Map<String, Set<Authorization>> getAuthorizationByRoles(Set<String> roleIdSet) {
        Preconditions.checkArgument(roleIdSet!=null&&!roleIdSet.isEmpty());
        Map<String,Set<Authorization>> results = Maps.newHashMap();

        StringBuilder s = new StringBuilder();
        s.append("select a.* from cam_authorization a where a.role_id in (");
        s.append(ObjectUtils.joinAsSqlIn(roleIdSet));
        s.append(")");

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(s.toString());
            while(rs.next()){
                Authorization a = new Authorization();
                a.setId(rs.getString("id"));
                a.setRoleId(rs.getString("role_id"));
                a.setPermissionId(rs.getString("perm_id"));
                a.setUpdateTime(rs.getDate("update_time"));
                a.setAuthorizedBy(rs.getString("authorized_by"));

                Set<Authorization> aSet = results.get(a.getRoleId());
                if(aSet == null){
                    aSet = Sets.newHashSet();
                    results.put(a.getRoleId(),aSet);
                }
                aSet.add(a);
            }
        }catch (SQLException sqlE){
            throw new DataException("error getting authorization by roles",sqlE);
        }finally {
            DbUtils.closeQuietly(con,st,rs);
        }

        //Set empty value for those role having no permissions.
        for(String roleId : roleIdSet){
            if(results.containsKey(roleId)){
                results.put(roleId, Collections.EMPTY_SET);
            }
        }
        return results;
    }

    @Override
    public List<Permission> getPermissions(Set<String> permissionIdSet) {
        List<Permission> perms = Lists.newArrayList();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select p.* from cam_permission p where p.id in ("+ ObjectUtils.joinAsSqlIn(permissionIdSet)+")");
            while(rs.next()){
                Permission p = new Permission();
                p.setId(rs.getString("id"));
                p.setAction(rs.getString("action"));
                p.setObjectType(rs.getString("object_type"));
                p.setCriteria(rs.getString("criteria"));
                perms.add(p);
            }
        }catch (SQLException sqlE){
            throw new DataException("error getting permissions",sqlE);
        }finally {
            DbUtils.closeQuietly(con,st,rs);
        }

        return perms;
    }

    @Override
    public Permission getSinglePermission(String permissionId) {

        Permission perm = null;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            con = dataSource.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from cam_permission where id = '"+permissionId+"'");

            if(rs.next()){
                perm = new Permission(rs.getString("action"),rs.getString("object_type"),rs.getString("criteria"));
                perm.setId(rs.getString("id"));
            }
        }catch (SQLException sqlE){
            throw new DataException("error getting single permission",sqlE);
        }finally {
            DbUtils.closeQuietly(con,st,rs);
        }
        return perm;
    }

    @Override
    public PermissionSet getPermissionOfRole(String roleId) {
        return null;
    }

    @Override
    public Collection<String> singleColumnListQuery(String queryString) {
        return singleColumnListQuery(queryString,1);
    }

    @Override
    public Set<String> singleColumnListQuery(String queryString, int columnIndex) {
        if(columnIndex<1){
            throw new CamException("columnIndex must be great or equal 1.");
        }
        Set<String> results = Sets.newHashSet();
        try(
                Connection con = dataSource.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(queryString);
        ){
            while(rs.next()){
                String valueOfColN = rs.getString(columnIndex);
                if(valueOfColN!=null){
                    results.add(valueOfColN);
                }
            }
        }catch (SQLException sqlE){
            throw new DataException("error getting single column list",sqlE);
        }
        return results;
    }
}
