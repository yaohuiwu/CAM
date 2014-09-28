package org.cam.core.parser;

import org.apache.commons.lang3.StringUtils;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuyaohui on 14-9-26.
 */
public class SqlFromExtractTest {

    String sql = "select * from t_doc t where name like 'tom_cat'";
    String sql1 = "select * from t_doc t  where name like 'tom_cat'";
    String sql10 = "select * from t_doc  d,t_user,t_app where d.user_id = a.id and name like 'tom_cat'";
    String sql11 = "select * from t_doc  ,t_user  where d.user_id = a.id and name like 'tom_cat'";
    String sql2 = "select * from ( select * from t_doc where t.user_id = 'mock_user') d  where d.name like 'tom_cat'";
    String sql3 = "select * from ( select * from t_doc where t.user_id = 'mock_user') d  where d.name in (select * from names )";

    String[] sqls = {sql,sql1,sql10,sql11,sql2,sql3};
    String sqlTablePatten = "from(\\s+\\w+(\\s+\\w+)?(\\s*,\\s*\\w+(\\s+\\w+)?)*)";
    @Test
    public void testSqlFromReg() throws Exception {

        String fromReg = "from\\s+((\\w+)(\\s+(\\w+)?!where)?(,(\\w+)(\\s+(\\w+)?!where)?)*)";
        Pattern p = Pattern.compile(sqlTablePatten);
        for(String s : sqls){
            System.out.println(s);
//            s = StringUtils.replacePattern(s,"\\s*,\\s*",",");
//            System.out.println(s);

            Matcher m = p.matcher(s);
            while(m.find()){
                System.out.println("start at:"+m.start(1));
                System.out.println(m.group(1));
            }
            System.out.println("");
            System.out.println("");
        }
    }

    @Test
    public void testPer5PatternMatcher() throws Exception {


        Perl5Compiler compiler = new Perl5Compiler();
        org.apache.oro.text.regex.Pattern p = compiler.compile(sqlTablePatten);
        org.apache.oro.text.regex.PatternMatcher m = new Perl5Matcher();


        for(String sql : sqls){

            System.out.println(sql);
            PatternMatcherInput input = new PatternMatcherInput(sql);

            MatchResult result = null;
            while(m.contains(input, p)) {
                result = m.getMatch();
                // Perform whatever processing on the result you want.

                System.out.println(result.group(0));
            }
            System.out.println();
        }

    }
}
