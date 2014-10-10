package org.cam.core.parser;

import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by wuyaohui on 14-10-10.
 */
public class ParserUtilTest {

    @Test
    public void testTypeMatch() throws Exception {
        String argAction = ExecutableType.VIEW.toString();
        String argObject = "org.cam.domain.User";

        Permission p = new Permission();
        p.setAction(ExecutableType.VIEW.toString());
        p.setObjectType("org.cam.domain.User");

        assertTrue(ParserUtil.typeMatch(argAction,argObject,p)); //both equals

        Permission p1 = new Permission(ExecutableType.VIEW.toString(),"*",null);
        assertTrue(ParserUtil.typeMatch(argAction,argObject,p1)); //ether equals

        Permission p2 = new Permission("*",argObject,null);
        assertTrue(ParserUtil.typeMatch(argAction,argObject,p2)); //ether equals

        Permission p3 = new Permission(argAction,"*",null);
        assertTrue(ParserUtil.typeMatch(argAction,argObject,p3)); //ether equals

        Permission p4 = new Permission("*","*",null);
        assertTrue(ParserUtil.typeMatch(argAction,argObject,p4)); //both all

        assertFalse(ParserUtil.typeMatch(argAction,"org.cam.domain.Role",p));
        assertFalse(ParserUtil.typeMatch("DELETE",argObject,p));
        assertFalse(ParserUtil.typeMatch("DELETE", "org.cam.domain.Role", p)); //both not equals
    }
}
