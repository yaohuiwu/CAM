package org.cam.core.parser;

import org.apache.commons.lang3.StringUtils;
import org.cam.core.ObjectUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yaohui on 14-9-21.
 */
public class ObjectUtilsTest {

    @Test
    public void testGetter() throws Exception{
        User u = new User(18);

        Object val = ObjectUtils.getter(u, "age");
        assertNotNull(val);
        assertTrue(val instanceof Integer);
        assertTrue(val.equals(18));

        User3 u3 = new User3();
        u3.setEducated(true);

        assertEquals(true, ObjectUtils.getter(u3, "educated"));
    }

    @Test
    public void testTrimWith(){
        String s = "'123444aaa'";
        String s2 = "123444aaa";

        assertEquals(s2, ObjectUtils.trimWith(s, "'"));
        assertEquals(s2, StringUtils.strip(s, "'"));
    }

    @Test
    public void testSqlLikePattern() throws Exception{

        String str = "'%tomcat%'";
        String str2 = "'tom_at%'";
        String str3 = "'%tom_at'";
        String str4 = "'tom_at'";

//        Perl5Compiler compiler = new Perl5Compiler();
//        Pattern p = compiler.compile("'%?.*%?'");
//        PatternMatcher m = new Perl5Matcher();
//
//        assertTrue(m.matches(str,p));
//        assertTrue(m.matches(str2,p));
//        assertTrue(m.matches(str3,p));
//        assertTrue(m.matches(str4,p));

        assertTrue(ObjectUtils.likeMatches("11tomcatdd",str));
        assertFalse(ObjectUtils.likeMatches("123tomat456",str));

        assertTrue(ObjectUtils.likeMatches("tomkatdd",str2));

        assertTrue(ObjectUtils.likeMatches("ddtomkat",str3));
        assertTrue(ObjectUtils.likeMatches("tomkat",str3));
        assertFalse(ObjectUtils.likeMatches("tomcaty",str3));
    }
}
