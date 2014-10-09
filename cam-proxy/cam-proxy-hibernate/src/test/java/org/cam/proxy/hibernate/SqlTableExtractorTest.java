package org.cam.proxy.hibernate;

import org.cam.core.sql.SqlTableExtractor;
import org.cam.core.sql.TableSegment;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Set;

/**
 * Created by wuyaohui on 14-10-8.
 */
public class SqlTableExtractorTest {

    private SqlTableExtractor extractor ;

    @Before
    public void setUp() throws Exception {
        extractor = new SqlTableExtractor();
    }

    @Test
    public void testSelect() throws Exception {
        // sql from real world
        String rw01 = "select r.id as contact_rel_id,c.id, c.contact_name, r.tenant_name, r.update_time " +
                "from mdm_contact_group_relation r, mdm_contacts_info c " +
                "where (r.target_id = ? and r.target_type = ? and r.contact_id = c.id)";

        Set<TableSegment> tableSegmentSet = extractor.extractTableIdentities(rw01);
        assertNotNull(tableSegmentSet);
        assertEquals(2,tableSegmentSet.size());

        TableSegment tableR = new TableSegment();
        tableR.setName("mdm_contact_group_relation");
        tableR.setAlias("r");

        TableSegment tableC = new TableSegment();
        tableC.setName("mdm_contacts_info");
        tableC.setAlias("c");

        assertThat(tableSegmentSet,hasItem(tableR));
        assertThat(tableSegmentSet,hasItem(tableC));
    }

    @Test
    public void testUpdate() throws Exception {

    }
}
