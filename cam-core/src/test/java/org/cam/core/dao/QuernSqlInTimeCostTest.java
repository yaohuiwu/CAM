package org.cam.core.dao;

import com.google.common.collect.Sets;
import org.apache.commons.dbutils.DbUtils;
import org.cam.core.ObjectUtilsTest;
import org.cam.core.ScriptRunner;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.domain.Authorization;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.sql.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by wuyaohui on 14-9-29.
 */
@Ignore
public class QuernSqlInTimeCostTest {

    DataSource dataSource ;

    private String inString = null;


    @Before
    public void setUp() throws Exception {
        dataSource = new SimpleDateSource("com.mysql.jdbc.Driver","jdbc:mysql://192.168.8.172/test","root","pekall1234");
        StringBuilder s = new StringBuilder();
        s.append("(");
        for(int i=1;i<=10000;i++){
            s.append(i);
            if(i!=10000){
                s.append(",");
            }
        }
        s.append(")");

        inString = s.toString();
    }

    @Test
    public void testInQuery() throws Exception {
        long literalQueryCost = 0L;
        long subQueryCost = 0L;

//        System.out.println(inString);
        long timeStart = System.currentTimeMillis();

        //查询id在 1-10000的所有用户
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            con = dataSource.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from t_user where id in "+inString);
            while(rs.next()){
                rs.getLong("id");
            }
            literalQueryCost = System.currentTimeMillis() - timeStart;
            System.out.println("timeCost(ms):"+literalQueryCost);


            long subQueryStart = System.currentTimeMillis();
            rs = st.executeQuery("select * from t_user where id in (select id from t_user)");
            while(rs.next()){
                rs.getLong("id");
            }
            subQueryCost = System.currentTimeMillis() - subQueryStart;
            System.out.println("subQueryCost:"+subQueryCost);
        }catch (SQLException sqlE){
            throw new RuntimeException("error getting",sqlE.getCause());
        }
        finally {
            DbUtils.closeQuietly(con, st, rs);
        }
//         Test result
//        timeCost(ms):157
//        subQueryCost:69

//        timeCost(ms):147
//        subQueryCost:60

//        timeCost(ms):153
//        subQueryCost:66

    }

}
