package org.cam.core.sql;

import com.google.common.collect.Lists;
import org.cam.core.CamService;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

@Ignore
public class SqlInterceptorTest {

    private SqlInterceptor interceptor ;
    private CamService mockCamService ;

    String sql0 = "select a.id, a.app_name, a.package_name, a.app_tag, a.app_type, a.app_file_size" +
            ", a.app_file_uuid, a.app_version_name, a.app_version_code, a.app_icon_url, a.app_pic_uuid" +
            ", a.security_policies, a.install_settings, s.update_time,a.description " +
            "from mdm_application_info a, mdm_application_status s, mdm_device_info dv " +
            "where s.app_id = a.id and a.status != ? and s.device_id = dv.id and s.device_id = ? and dv.status = ?";



    @Before
    public void setUp() throws Exception {
        CamService mockCamService = mock(CamService.class);
        interceptor = new DefaultSqlInterceptor(mockCamService);
    }

    @Test
    public void testIntercept() throws Exception {
        List<Permission> pList = Lists.newArrayList();
        Permission p = new Permission(ExecutableType.VIEW.toString(),"MdmApplicationInfo","orgId in ('1','2')");
        Permission p2 = new Permission(ExecutableType.VIEW.toString(),"MdmApplicationStatus","orgId in ('2')");
        Permission p3 = new Permission(ExecutableType.VIEW.toString(),"MdmDeviceInfo","orgId in ('1')");
        pList.add(p);
        when(mockCamService.getPermissionOfUser(null, ExecutableType.VIEW.toString(), "MdmApplicationInfo")).thenReturn(pList);

        String interceptedSql = interceptor.intercept(sql0);
        verify(mockCamService,times(3));
    }
}
