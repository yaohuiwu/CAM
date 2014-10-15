package org.cam.core.sql;

import org.cam.core.TestUtil;
import org.cam.core.util.ObjectUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;

public class SqlTableRefRecognizerTest {

    private static final Logger LOG = LoggerFactory.getLogger(SqlTableRefRecognizerTest.class);

    private SqlTableRefRecognizer tableRefRecognizer ;

    String sql0 = "select a.id, a.app_name, a.package_name, a.app_tag, a.app_type, a.app_file_size" +
            ", a.app_file_uuid, a.app_version_name, a.app_version_code, a.app_icon_url, a.app_pic_uuid" +
            ", a.security_policies, a.install_settings, s.update_time,a.description " +
            "from mdm_application_info a, mdm_application_status s, mdm_device_info dv " +
            "where s.app_id = a.id and a.status != ? and s.device_id = dv.id and s.device_id = ? and dv.status = ?";


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

        List<SqlSegment> segs = tableRefRecognizer.analyze(sql0);
        TestUtil.printlnList(segs);
        assertNotNull(segs);
        assertEquals(3,segs.size());

        SqlSegment seg0 = segs.get(0);
        TableRefsSegment seg1 = (TableRefsSegment)segs.get(1);
        SqlSegment seg2 = segs.get(2);

        assertEquals("select a.id, a.app_name, a.package_name, a.app_tag, a.app_type, a.app_file_size" +
                        ", a.app_file_uuid, a.app_version_name, a.app_version_code, a.app_icon_url, a.app_pic_uuid" +
                        ", a.security_policies, a.install_settings, s.update_time,a.description " +
                        "from ",seg0.getOriginalString());
        assertEquals(" " +
                "where s.app_id = a.id and a.status != ? and s.device_id = dv.id and s.device_id = ? and dv.status = ?",seg2.getOriginalString());

        List<TableRef> refs = seg1.getTableRefList();

        TableRef appInfo = refs.get(0);
        assertEquals("mdm_application_info", appInfo.getName());
        assertNull(appInfo.getAs());
        assertEquals("a",appInfo.getAlias());

        TableRef appStatus = refs.get(1);
        assertEquals("mdm_application_status",appStatus.getName());
        assertNull(appInfo.getAs());
        assertEquals("s",appStatus.getAlias());

        TableRef dev = refs.get(2);
        assertEquals("mdm_device_info",dev.getName());
        assertNull(dev.getAs());
        assertEquals("dv",dev.getAlias());
    }

    @Test
    public void testFromReg() throws Exception {

        Matcher m = ObjectUtils.getMatcher(sql0, SqlTableRefRecognizer.FROM_REGEX);
        while(m.find()){
            LOG.debug("start:{},end:{},group 1:{}",m.start(),m.end(),m.group(1));

            String from  = sql0.substring(m.start(),m.start()+4);
            LOG.debug("from :{}",from);
            assertTrue("from".equalsIgnoreCase(from));
            LOG.debug("char at {} : {}",m.start(),sql0.charAt(m.start()));
            LOG.debug("char at {} : {}",m.end()-1,sql0.charAt(m.end()-1));
        }
    }

    @Test
    public void testRecognizeSingleFrom() throws Exception {
        String sql1 = "SELECT * FROM mdm_org";
        List<SqlSegment> segments = tableRefRecognizer.analyze(sql1);
        TestUtil.printlnList(segments);

        assertNotNull(segments);
        assertEquals(2,segments.size());
    }

     @Test
    public void testRecognizeSingleFromWithWhere() throws Exception {
        String sql1 = "SELECT * FROM mdm_org where 1=1 ";
        List<SqlSegment> segments = tableRefRecognizer.analyze(sql1);
        TestUtil.printlnList(segments);

        assertNotNull(segments);
        assertEquals(3,segments.size());
    }

    @Test
    public void testRecognizeMultipleFrom() throws Exception {
        String sql1 = "SELECT * FROM mdm_org WHERE org_code IN " +
                "(SELECT descendant_code FROM mdm_org_tree_path WHERE ancestor_code = :orgCode)";
        List<SqlSegment> segments = tableRefRecognizer.analyze(sql1);
        TestUtil.printlnList(segments);

        assertNotNull(segments);
        assertEquals(5,segments.size());
    }

    @Test
    public void testRecognizeSqlContainsWhere() throws Exception {
        String sql1 = "SELECT * FROM mdm_org where org_code IN " +
                "(SELECT descendant_code FROM mdm_org_tree_path WHERE ancestor_code = :orgCode)";
        List<SqlSegment> segments = tableRefRecognizer.analyze(sql1);
        TestUtil.printlnList(segments);

        assertNotNull(segments);
        assertEquals(5,segments.size());

        assertEquals("SELECT * FROM ",segments.get(0).getOriginalString());
        assertEquals(" where org_code IN " +
                "(SELECT descendant_code FROM ",segments.get(2).getOriginalString());
        assertEquals(" WHERE ancestor_code = :orgCode)",segments.get(4).getOriginalString());

    }

    @Test
    public void testRecognizeSqlContainsJoin() throws Exception {
        String sql = "select mdmenterpr0_.id as id1_57_1_, mdmenterpr0_.account as account2_57_1_, " +
                "mdmenterpr0_.com_id as com_id3_57_1_, mdmenterpr0_.create_time as create_t4_57_1_, " +
                "mdmenterpr0_.create_user_id as create_u5_57_1_, mdmenterpr0_.email as email6_57_1_, " +
                "mdmenterpr0_.key_128 as key_7_57_1_, mdmenterpr0_.key_256 as key_8_57_1_, " +
                "mdmenterpr0_.mobile_phone as mobile_p9_57_1_, mdmenterpr0_.name as name10_57_1_, " +
                "mdmenterpr0_.org_code as org_cod11_57_1_, mdmenterpr0_.password as passwor12_57_1_, " +
                "mdmenterpr0_.police_id as police_13_57_1_, mdmenterpr0_.source as source14_57_1_, " +
                "mdmenterpr0_.status as status15_57_1_, mdmenterpr0_.telephone as telepho16_57_1_, " +
                "mdmenterpr0_.update_time as update_17_57_1_, mdmenterpr0_.update_user_id as update_18_57_1_, " +
                "groupset1_.user_id as user_id1_57_3_, mdmusergro2_.id as group_id2_33_3_, " +
                "mdmusergro2_.id as id1_58_0_, mdmusergro2_.is_auto_invite_user_register_device as is_auto_2_58_0_, " +
                "mdmusergro2_.com_id as com_id3_58_0_, mdmusergro2_.create_time as create_t4_58_0_, " +
                "mdmusergro2_.create_user_id as create_u5_58_0_, mdmusergro2_.description as descript6_58_0_, " +
                "mdmusergro2_.invite_register_device_param as invite_r7_58_0_, mdmusergro2_.name as name8_58_0_, " +
                "mdmusergro2_.org_code as org_code9_58_0_, mdmusergro2_.status as status10_58_0_, " +
                "mdmusergro2_.type as type11_58_0_, mdmusergro2_.update_time as update_12_58_0_, " +
                "mdmusergro2_.update_user_id as update_13_58_0_ " +
                "from mdm_user mdmenterpr0_ " +
                "left outer join mdm_group_user groupset1_ on mdmenterpr0_.id=groupset1_.user_id " +
                "left outer join mdm_user_group mdmusergro2_ on groupset1_.group_id=mdmusergro2_.id " +
                "where mdmenterpr0_.id=?";

        List<SqlSegment> segments = tableRefRecognizer.analyze(sql);
        TestUtil.printlnList(segments);

        assertNotNull(segments);
        assertEquals(7,segments.size());


    }
}
