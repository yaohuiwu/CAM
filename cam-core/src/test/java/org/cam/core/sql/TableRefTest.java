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

}
