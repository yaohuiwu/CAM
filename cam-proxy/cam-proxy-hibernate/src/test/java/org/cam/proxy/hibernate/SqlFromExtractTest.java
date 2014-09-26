package org.cam.proxy.hibernate;

import org.apache.commons.lang3.StringUtils;
import org.cam.core.ObjectUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class SqlFromExtractTest {

    @Test
    public void testSqlFromReg() throws Exception {
        String fromReg = "from\\s+((\\w+)(\\s+(\\w+)?!where)?(,(\\w+)(\\s+(\\w+)?!where)?)*)";

        String sql = "select * from t_doc where name like 'tom_cat'";
        String sql1 = "select * from t_doc t  where name like 'tom_cat'";
        String sql10 = "select * from t_doc  ,t_user,t_app where d.user_id = a.id and name like 'tom_cat'";
        String sql11 = "select * from t_doc  ,t_user  where d.user_id = a.id and name like 'tom_cat'";
        String sql2 = "select * from ( select * from t_doc where t.user_id = 'mock_user') d  where d.name like 'tom_cat'";
        String sql3 = "select * from ( select * from t_doc where t.user_id = 'mock_user') d  where d.name in (select * from names )";

        Pattern p = Pattern.compile(fromReg);


        String[] sqls = {sql,sql1,sql10,sql11,sql2,sql3};

        for(String s : sqls){
            System.out.println(s);
            s = StringUtils.replacePattern(s,"\\s*,\\s*",",");
            System.out.println(s);

            Matcher m = p.matcher(s);
            while(m.find()){
                System.out.println("start at:"+m.start(1));
                System.out.println(m.group(1));
            }
            System.out.println("");
            System.out.println("");
        }
    }
}
