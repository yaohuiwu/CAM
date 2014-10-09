package org.cam.core.sql;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TableRefsSegmentTest {

    @Test
    public void testSetSecurityView() throws Exception {

        TableRefsSegment tableRefsSegment =
                new TableRefsSegment("mdm_application_info a, mdm_application_status s, mdm_device_info dv",0);
        assertNotNull(tableRefsSegment);

        List<TableRef> refList = tableRefsSegment.getTableRefList();
        assertNotNull(refList);
        assertEquals(3,refList.size());

        for(TableRef ref : refList){
            ref.setSecurityView("org_id in ('1','2')");
        }
        assertEquals("(select * from mdm_application_info where org_id in ('1','2')) a," +
                "(select * from mdm_application_status where org_id in ('1','2')) s," +
                "(select * from mdm_device_info where org_id in ('1','2')) dv",tableRefsSegment.toSqlString());
    }
}
