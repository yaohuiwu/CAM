package org.cam.core.parser;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yaohui on 14-9-21.
 */
public class ParserTest {

    PermissionEvaluator evaluator = new DefaultPermissionEvaluator();
    User u17 = new User(17);
    User u18 = new User(18);
    User u19= new User(19);

    @Test
    public void testIntEq(){
        //EQ
        String perm = "create:org.learning.premission.User:age = 18";
        Assert.assertTrue(evaluator.isPermit(u18,perm));
        Assert.assertFalse(evaluator.isPermit(u17,perm));
        Assert.assertFalse(evaluator.isPermit(u19,perm));
    }

    @Test
    public void testIntGt(){
        String perm = "create:org.learning.premission.User:age > 18";
        Assert.assertTrue(evaluator.isPermit(u19,perm));
        Assert.assertFalse(evaluator.isPermit(u17, perm));
        Assert.assertFalse(evaluator.isPermit(u18,perm));
    }

    @Test
    public void testIntGe(){
        String perm = "create:org.learning.premission.User:age >= 18";
        Assert.assertTrue(evaluator.isPermit(u18,perm));
        Assert.assertTrue(evaluator.isPermit(u19, perm));
        Assert.assertFalse(evaluator.isPermit(u17,perm));
    }

    @Test
    public void testIntLt(){
        String perm = "create:org.learning.premission.User:age < 18";
        Assert.assertTrue(evaluator.isPermit(u17,perm));
        Assert.assertFalse(evaluator.isPermit(u18, perm));
        Assert.assertFalse(evaluator.isPermit(u19,perm));
    }

    @Test
    public void testIntLe(){
        String perm = "create:org.learning.premission.User:age <= 18";
        Assert.assertTrue(evaluator.isPermit(u17,perm));
        Assert.assertTrue(evaluator.isPermit(u18,perm));
        Assert.assertFalse(evaluator.isPermit(u19,perm));
    }

    @Test
    public void testAnd(){
        String perm = "create:org.learning.premission.User2:age > 18 and name = 'tom'";
        User2 u = new User2(19,"tom");
        Assert.assertTrue(evaluator.isPermit(u,perm));

        String perm2 = "create:org.learning.premission.User2:age > 18 and name = 'tom'";
        User2 u2 = new User2(19,"tomcat");
        Assert.assertFalse(evaluator.isPermit(u2, perm));
    }

    @Test
    public void testOr(){
        String perm = "create:org.learning.premission.User2:age > 18 or name = 'tom'";

        User2 u = new User2(19,"tom");
        Assert.assertTrue(evaluator.isPermit(u, perm));

        User2 u2 = new User2(19,"tomcat");
        Assert.assertTrue(evaluator.isPermit(u2,perm));

        User2 u3 = new User2(18,"tom");
        Assert.assertTrue(evaluator.isPermit(u3,perm));

        User2 u4 = new User2(18,"tomcat");
        Assert.assertFalse(evaluator.isPermit(u4, perm));

    }

    @Test
    public void testIn(){

        String perm = "create:org.learning.premission.User2: name in ( 'ketty','tom', 'cat' )";
        User2 u = new User2(18,"tom");
        Assert.assertTrue(evaluator.isPermit(u,perm));

        User2 u2 = new User2(18,"kate");
        Assert.assertFalse(evaluator.isPermit(u2,perm));

    }

    @Test
    public void testLike(){
        User2 tomcat = new User2(18,"tomcat");
        User2 tomfatty = new User2(18,"tomfatty");
        User2 Hitombat = new User2(18,"Hitombat");

        String permA = "create:org.learning.premission.User2: name like 'tom_at'";
        String permB = "create:org.learning.premission.User2: name like 'tom_at%'";
        String permC = "create:org.learning.premission.User2: name like '%tom_at%'";
        String permD = "create:org.learning.premission.User2: name like '%tom_at'";

        Assert.assertTrue(evaluator.isPermit(tomcat,permA));
        Assert.assertTrue(evaluator.isPermit(tomcat,permB));
        Assert.assertTrue(evaluator.isPermit(tomcat,permC));
        Assert.assertTrue(evaluator.isPermit(tomcat,permD));

        Assert.assertFalse(evaluator.isPermit(tomfatty,permA));
        Assert.assertTrue(evaluator.isPermit(tomfatty,permB));
        Assert.assertTrue(evaluator.isPermit(tomfatty,permC));
        Assert.assertFalse(evaluator.isPermit(tomfatty,permD));

        Assert.assertFalse(evaluator.isPermit(Hitombat,permA));
        Assert.assertFalse(evaluator.isPermit(Hitombat,permB));
        Assert.assertTrue(evaluator.isPermit(Hitombat,permC));
        Assert.assertTrue(evaluator.isPermit(Hitombat,permD));
    }

    @Test
    public void testComplexCondition00(){

        User3 u = new User3();
        u.setId("001");
        u.setName("tommy");
        u.setAge(18);
        u.setEducated(true);

        String orEducated = "create:org.learning.premission.User3 : age > 18 and name != 'tommy' or educated = true";
        Assert.assertTrue(evaluator.isPermit(u,orEducated));
    }

    @Test
    public void testComplexCondition01(){

        User3 u = new User3();
        u.setId("001");
        u.setName("tommy");
        u.setAge(18);
        u.setEducated(true);

        String orEducated = "create:org.learning.premission.User3 : age > 18 and (name != 'tommy' and educated = true)";
        Assert.assertFalse(evaluator.isPermit(u,orEducated));
    }
}
