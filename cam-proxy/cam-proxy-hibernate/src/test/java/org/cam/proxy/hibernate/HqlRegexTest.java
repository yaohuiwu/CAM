package org.cam.proxy.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuyaohui on 14-10-8.
 */
public class HqlRegexTest {

    private static final Logger LOG = LoggerFactory.getLogger(HqlRegexTest.class);
    private static final String HQL_REG = "from\\s+(\\w+)\\s*(?!where)(\\w+)?(\\s*,\\s*\\w+(\\s+\\w)?)*(\\s+where)?";
    private Pattern hqlPtn;

    @Before
    public void setUp() throws Exception {
        hqlPtn = Pattern.compile(HQL_REG);
    }

    @Test
    public void testHql1() throws Exception {
        String hql1 = "from Document d where d.owner = 'admin'";

        Matcher m = hqlPtn.matcher(hql1);
        RegexTestUtils.logGroups(m);
    }

    @Test
    public void testHqlWithTwoEntity() throws Exception {
        String hql = "select info from MdmApplicationInfo as info ,MdmApplicationStatus as status  where  info.id=status.appId and status.deviceId=:deviceId";

        Matcher m = hqlPtn.matcher(hql);
        RegexTestUtils.logGroups(m);
    }




}
