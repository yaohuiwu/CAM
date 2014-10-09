package org.cam.core.sql;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableRefTest {

    @Test
    public void testNewTableRef() throws Exception {
        TableRef tableRef = new TableRef("t_user as u",10);
        assertEquals("t_user",tableRef.getName());
        assertEquals("as",tableRef.getAs());
        assertEquals("u",tableRef.getAlias());
    }

    @Test
    public void testTableRefWithAs() throws Exception {
        TableRef tableRef = new TableRef("t_user u",10);
        assertEquals("t_user",tableRef.getName());
        assertNull(tableRef.getAs());
        assertEquals("u",tableRef.getAlias());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTableRefWithNegativeIndex() throws Exception {
        TableRef tableRef = new TableRef("t_user u",-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTableRefWithEmptyString() throws Exception {
        TableRef tableRef = new TableRef("",1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTableRefWithEmptyString2() throws Exception {
        TableRef tableRef = new TableRef(" ",1);
    }
}
