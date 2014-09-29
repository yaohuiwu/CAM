package org.cam.core.dao;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.ObjectUtils;
import org.cam.core.ScriptHelper;
import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JdbcPersistentDaoImpl implements PersistentDao{

    private static final Logger LOG = LoggerFactory.getLogger(JdbcPersistentDaoImpl.class);

    private final DataSource dataSource ;

    public JdbcPersistentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isSorPrepared() {

        Set<String> camTables = Sets.newHashSet("cam_role","cam_permission","cam_authorization");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            //check cam tables exists
            StringBuilder s = new StringBuilder();
            s.append("SELECT count(TABLE_NAME) FROM information_schema.`TABLES`  where ");
            s.append("table_name in (");
            s.append(ObjectUtils.joinAsSqlIn(camTables));
            s.append(")");
            st = con.createStatement();
            rs = st.executeQuery(s.toString());
            rs.next();
            Long camTableCount = rs.getLong(1);
            if(camTableCount.intValue() == camTables.size()){
                return true;
            }
        }catch (SQLException sqlE){
            throw new RuntimeException("error getting",sqlE.getCause());
        }
        finally {
            DbUtils.closeQuietly(con,st,rs);
        }
        LOG.debug("CAM system table not exists.");
        return false;
    }

    @Override
    public void initializeSor(Properties properties) {
        if(isSorPrepared()){
            LOG.info("CAM schema is already prepared. Nothing will be done");
            return ;
        }
        LOG.info("Initializing CAM schema.");
        ScriptHelper.runScript(dataSource,"cam_schema.sql");
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
            LOG.error("error getting all roles",sqlE);
            throw new DataException("error getting all roles",sqlE.getCause());
        }
        finally {
            DbUtils.closeQuietly(con,st,rs);
        }
        return roles;
    }

    @Override
    public Map<String, Set<Authorization>> getAuthorizationByRoles(Set<String> roleIdSet) {
        Preconditions.checkArgument(roleIdSet!=null&&!roleIdSet.isEmpty());
        Map<String,Set<Authorization>> results = Maps.newHashMap();

        StringBuilder s = new StringBuilder();
        s.append("select a.* from cam_authorization a where a.role_id in ('");
        s.append(ObjectUtils.joinAsSqlIn(roleIdSet));
        s.append("')");

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
            throw new RuntimeException("error getting authorization by roles",sqlE.getCause());
        }
        finally {
            DbUtils.closeQuietly(con,st,rs);
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
            throw new RuntimeException("error getting",sqlE.getCause());
        }
        finally {
            DbUtils.closeQuietly(con,st,rs);
        }

        return perms;
    }
}
