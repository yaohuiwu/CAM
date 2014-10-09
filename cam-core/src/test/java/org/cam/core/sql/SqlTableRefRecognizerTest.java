package org.cam.core.sql;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqlTableRefRecognizerTest {

    private SqlTableRefRecognizer tableRefRecognizer ;

    @Before
    public void setUp() throws Exception {
        tableRefRecognizer = new SqlTableRefRecognizer();
    }

    @Test
    public void testIsSelect() throws Exception {

        assertTrue(tableRefRecognizer.isSelect("select * from t_user as u"));
        assertTrue(tableRefRecognizer.isSelect(" select * from t_user as u "));
        assertTrue(tableRefRecognizer.isSelect(" SELECT * from t_user as u "));
        assertFalse(tableRefRecognizer.isSelect(" selec * from t_user as u "));
        assertFalse(tableRefRecognizer.isSelect(null));
    }

    @Test
    public void testRecognize() throws Exception {
        String sql0 = "select a.id, a.app_name, a.package_name, a.app_tag, a.app_type, a.app_file_size" +
                ", a.app_file_uuid, a.app_version_name, a.app_version_code, a.app_icon_url, a.app_pic_uuid" +
                ", a.security_policies, a.install_settings, s.update_time,a.description " +
                "from mdm_application_info a, mdm_application_status s, mdm_device_info dv " +
                "where s.app_id = a.id and a.status != ? and s.device_id = dv.id and s.device_id = ? and dv.status = ?";
        TableRef[] refs = tableRefRecognizer.recognize(sql0);
        assertNotNull(refs);
        assertEquals(3,refs.length);

        TableRef appInfo = refs[0];
        assertEquals("mdm_application_info a",appInfo.getOriginalString());
        assertEquals("mdm_application_info",appInfo.getName());
        assertNull(appInfo.getAs());
        assertEquals("a",appInfo.getAlias());

        TableRef appStatus = refs[1];
        assertEquals("mdm_application_status s",appStatus.getOriginalString());
        assertEquals("mdm_application_status",appStatus.getName());
        assertNull(appInfo.getAs());
        assertEquals("s",appStatus.getAlias());

        TableRef dev = refs[2];
        assertEquals("mdm_device_info dv",dev.getOriginalString());
        assertEquals("mdm_device_info",dev.getName());
        assertNull(dev.getAs());
        assertEquals("dv",dev.getAlias());
    }
}
