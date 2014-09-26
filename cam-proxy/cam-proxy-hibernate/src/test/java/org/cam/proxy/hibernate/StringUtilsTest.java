package org.cam.proxy.hibernate;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class StringUtilsTest {

    @Test
    public void testReplace(){
        String source = "select * from t_doc t where t.name like 'tom_at_doc'";

        String expected = StringUtils.replacePattern(source,"\\bt_doc\\b","(select * from t_doc)");
        assertEquals("select * from (select * from t_doc) t where t.name like 'tom_at_doc'",expected);
    }
}
