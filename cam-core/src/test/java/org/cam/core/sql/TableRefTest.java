package org.cam.core.sql;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableRefTest {

    @Test
    public void testNewTableRef() throws Exception {
        TableRef tableRef = new TableRef("t_user as u");
        assertEquals("t_user",tableRef.getName());
        assertEquals("as",tableRef.getAs());
        assertEquals("u",tableRef.getAlias());
    }

    @Test
    public void testTableRefWithAs() throws Exception {
        TableRef tableRef = new TableRef("t_user u");
        assertEquals("t_user",tableRef.getName());
        assertNull(tableRef.getAs());
        assertEquals("u",tableRef.getAlias());
    }

    @Test
    public void testSetSecurityView() throws Exception {
        TableRef tableRef = new TableRef("t_user u");
        tableRef.setSecurityView("*");
        assertEquals("t_user u",tableRef.getSecurityView());
    }

    @Test
    public void testSetSecurityView2() throws Exception {
        TableRef tableRef = new TableRef("t_user u");
        tableRef.setSecurityView("org_id in ('1','2')");
        assertEquals("(select * from t_user where org_id in ('1','2')) u",tableRef.getSecurityView());
    }

    @Test
    public void testSetSecurityView3() throws Exception {
        TableRef tableRef = new TableRef("t_user u");
        tableRef.setSecurityView("org_id in ('1','2') and name like '%tom_at%'");
        assertEquals("(select * from t_user where org_id in ('1','2') and name like '%tom_at%') u",tableRef.getSecurityView());
    }


}
