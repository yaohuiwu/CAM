package org.cam.spring;

import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class JdbcTemplateDaoImpl{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Permission> permissionRowMapper = new ParameterizedRowMapper<Permission>() {
        @Override
        public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
            Permission p = new Permission();
            p.setId(rs.getString("id"));
            p.setAction(rs.getString("action"));
            p.setCriteria(rs.getString("criteria"));
            p.setObjectType(rs.getString("object_type"));
            return p;
        }
    };

    public List<Authorization> getAllAuthorization() {
        return jdbcTemplate.query("select * from cbam_authorization",new ParameterizedRowMapper<Authorization>() {
            @Override
            public Authorization mapRow(ResultSet rs, int rowNum) throws SQLException {
                Authorization a = new Authorization();
                a.setId(rs.getString("id"));
                a.setRoleId(rs.getString("role_id"));
                a.setPermissionId(rs.getString("permission_id"));
                a.setAuthorizedBy(rs.getString("authorized_by"));
                a.setUpdateTime(rs.getDate("update_time"));
                return a;
            }
        });
    }

    public List<Permission> getAllPermission() {
        return jdbcTemplate.query("select * from cbam_permission", permissionRowMapper);
    }

    public List<Permission> getPermissionsOf(Role role) {
        String query = "select p.* from cbam_authorization a, cbam_permission p where a.permission_id = p.id and  a.role_id = ? ";
        return jdbcTemplate.query(query, permissionRowMapper,role.getId());
    }

    public List<Role> getAllRole() {
        return jdbcTemplate.query("select * from cbam_role",new ParameterizedRowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                Role r = new Role();
                r.setId(rs.getString("id"));
                r.setName(rs.getString("name"));
                r.setUserCriteria(rs.getString("user_criteria"));
                return r;
            }
        });
    }

    public int createRole(Role role) {
        return jdbcTemplate.update("insert into cbam_role(id,name,user_criteria) values (?,?,?)",
                role.getId(),role.getName(),role.getUserCriteria());
    }

    public boolean updateRole(Role role) {
        int r = jdbcTemplate.update("update  cbam_role name = ? , user_criteria = ? where id = ? ",
                role.getName(),role.getUserCriteria(),role.getId());
        return r == 1;
    }

    public List<Permission> getPermsOfUserByActionAndObjectType(User user, String action, String objectType) {
        return null;
    }
}
