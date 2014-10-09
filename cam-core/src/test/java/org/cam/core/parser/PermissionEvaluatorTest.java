package org.cam.core.parser;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.cam.core.FactoryHelper;
import org.cam.core.TestCamFactory;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

/**
 * Created by wuyaohui on 14-9-27.
 */
public class PermissionEvaluatorTest {

    private static final Logger LOG = LoggerFactory.getLogger(PermissionEvaluatorTest.class);


    @Before
    public void setUp() throws Exception {
        FactoryHelper.register(new TestCamFactory());
    }

    @Test
    public void testToSqlCriteria() throws Exception {
        Map<String,String> map = Maps.newHashMap();
        map.put("country","c_country");
        map.put("city","c_city");

        List<Permission> permList = Lists.newArrayList();
        Permission p0 = new Permission(
                ExecutableType.VIEW.toString(),
                "org.cam.Company",
                "country = 'China' and (city like '%jing' or city like '%zhou')");
        permList.add(p0);

        Permission p1 = new Permission(
                ExecutableType.VIEW.toString(),
                "org.cam.Company",
                "city like '%jing'");
        permList.add(p1);

        PermissionEvaluator evaluator = new DefaultPermissionEvaluator();
        String sqlCriteria = evaluator.toSqlCriteria(permList);
        LOG.debug("sqlCriteria: [{}]",sqlCriteria);
        assertEquals("c_country = 'China' and (c_city like '%jing' or c_city like '%zhou') or c_city like '%jing'",sqlCriteria);
    }
}
