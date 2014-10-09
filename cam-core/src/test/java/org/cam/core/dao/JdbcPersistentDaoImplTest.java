package org.cam.core.dao;

import com.google.common.collect.Sets;
import org.cam.core.ObjectUtilsTest;
import org.cam.core.util.ScriptRunner;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by wuyaohui on 14-9-29.
 */
@Ignore
public class JdbcPersistentDaoImplTest {

    DataSource dataSource ;

    PersistentDao persistentDao;

//    ScriptRunner scriptRunner;

    @Before
    public void setUp() throws Exception {
        dataSource = new SimpleDateSource("com.mysql.jdbc.Driver","jdbc:mysql://192.168.8.172/test","root","pekall1234");
        persistentDao = new JdbcPersistentDaoImpl(dataSource);

        persistentDao.initializeSor();

        //prepare test data
        ScriptRunner.runScript(dataSource,getClass().getClassLoader().getResource("dataTest.sql"));
    }

    @Test
    public void testGetAllRole() throws Exception {

        List<Role> roleList =persistentDao.getAllRole();
        assertNotNull(roleList);
        assertEquals(5,roleList.size());

        ObjectUtilsTest.printlnList(roleList);
    }

    @Test
    public void testGetAuthorizationByRoles() throws Exception {
        Map<String,Set<Authorization>> roles = persistentDao.getAuthorizationByRoles(Sets.newHashSet("r1","r2"));
        System.out.println(roles);
        assertEquals(2,roles.size());

        assertEquals(2,roles.get("r1").size());
        assertEquals(1,roles.get("r2").size());
    }

    @Test
    public void testGetPermissions() throws Exception {
        List<Permission> permissions = persistentDao.getPermissions(Sets.newHashSet("p1","p2"));
        ObjectUtilsTest.printlnList(permissions);
        assertEquals(2,permissions.size());
    }

    @Test
    public void testGetSinglePermission() throws Exception {
        Permission perm = persistentDao.getSinglePermission("p1");
        assertNotNull(perm);
        
        System.out.println(perm);
        
        Permission expected = new Permission(ExecutableType.VIEW.toString(),"com.pekall.mdm.Document","uploadBy = 'tom'");
        assertEquals(expected,perm);
    }

    @After
    public void tearDown() throws Exception {
        ScriptRunner.runScript(dataSource, getResource("dataClear.sql"));
    }

    private URL getResource(String scriptName){
        return getClass().getClassLoader().getResource(scriptName);
    }
}
