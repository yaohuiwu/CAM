package org.cam.core.performance;

import com.google.common.collect.Lists;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.cam.core.dao.SimpleDateSource;
import org.cam.core.util.ScriptRunner;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 测试sql的不同限制条件的查询性能
 */
@Ignore
public class CriteriaPerformanceTest {

    private static final Logger LOG = LoggerFactory.getLogger(CriteriaPerformanceTest.class);

    DataSource dataSource ;
    QueryRunner queryRunner;

    @Before
    public void setUp() throws Exception {
        String host_local = "localhost" ;
        dataSource = new SimpleDateSource("com.mysql.jdbc.Driver","jdbc:mysql://"+host_local+"/test",
                "root","pekall1234");
        queryRunner = new QueryRunner(dataSource);
        try(
            Connection con = dataSource.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select version()");
        ){
            rs.next();
            LOG.debug("version of mysql : {}", rs.getString(1));
        }catch (SQLException sqlE){
            throw new RuntimeException("error getting",sqlE.getCause());
        }
    }

//    @Test
//    public void testPrepareData() throws Exception {
//        long start = System.currentTimeMillis();
//        LOG.debug("begin");
//        try(
//            Connection con = dataSource.getConnection();
//        ){
//            ScriptRunner runner = new ScriptRunner(con);
//            runner.setLogWriter(null);
//            ClassLoader cla = getClass().getClassLoader();
//            runner.runScript(cla.getResource("data/mdm_org.sql"));
//            runner.runScript(cla.getResource("data/mdm_org_tree_path.sql"));
//            runner.runScript(cla.getResource("data/mdm_action_history.sql"));
//            runner.runScript(cla.getResource("data/mdm_user.sql"));
//
//        }catch (SQLException sqlE){
//            throw new RuntimeException("error getting",sqlE.getCause());
//        }
//        LOG.debug("end. cost {} ms",System.currentTimeMillis()-start);
//    }

//    @Test
//    @Ignore
//    public void testClear() throws Exception {
//        long start = System.currentTimeMillis();
//        LOG.debug("begin clear");
//        try(Connection con = dataSource.getConnection();){
//            ScriptRunner runner = new ScriptRunner(con);
//            ClassLoader cla = getClass().getClassLoader();
//            runner.runScript(cla.getResource("data/dataClear.sql"));
//        }catch (SQLException sqlE){
//            throw new RuntimeException("error getting",sqlE.getCause());
//        }
//        LOG.debug("end clear. cost {} ms",System.currentTimeMillis()-start);
//    }


    @Test
    public void testCount() throws Exception {
        LOG.debug("-------------{}-------------", "mdm_user");

        runScalarQuery(createCountReporters("mdm_user"));
//
//        LOG.debug("-------------{}-------------\n","mdm_action_history");
//
//        runScalarQuery(createCountReporters("mdm_action_history"));

//        LOG.debug("-------------{}-------------\n","mdm_org");
//
//        runScalarQuery(createCountReporters("mdm_org"));
    }

    @Test
    public void testList() throws Exception {
        LOG.debug("-------------{}-------------", "mdm_user");

        runListQuery(createListReporters("mdm_user"));
//
//        LOG.debug("-------------{}-------------\n","mdm_action_history");
//
//        runListQuery(createListReporters("mdm_action_history"));

//        LOG.debug("-------------{}-------------\n","mdm_org");
//
//        runListQuery(createListReporters("mdm_org"));
    }


    private List<QueryReporter> createListReporters(String table){
        QueryReporter original = new QueryReporter("original list","select * from "+table+" order by id limit 0,20");
        QueryReporter join = new QueryReporter("join list"," select * from "+table+" t INNER JOIN mdm_org_tree_path ON org_code =  descendant_code and ancestor_code = '330000000000' order by t.id limit 0,20");
        QueryReporter subSelect = new QueryReporter("subselect list",
                " select * from "+table+" t where org_code in " +
                        "(select descendant_code from mdm_org_tree_path where ancestor_code = '330000000000') order by t.id limit 0,20");
        QueryReporter subSelect2 = new QueryReporter("subselect2 list",
                " select * from (select * from "+table+" where org_code in " +
                        "(select descendant_code from mdm_org_tree_path where ancestor_code = '330000000000')) u order by u.id limit 0,20");
        return Lists.newArrayList(original,join,subSelect,subSelect2);
    }


    private void runListQuery(List<QueryReporter> reporterList) throws Exception{
        for(QueryReporter queryReporter : reporterList){
            long start = System.currentTimeMillis();
            List<Object[]> arraylist = queryRunner.query(queryReporter.getQueryStr(),
                    new ArrayListHandler());
//            for(Object[] objs : arraylist){
//                for(Object o : objs){
//                    System.out.print(o + ",");
//                }
//                System.out.println();
//            }
            queryReporter.setResult(arraylist);
            queryReporter.setCost(System.currentTimeMillis()-start);
            LOG.debug("{}",queryReporter);
        }
        LOG.debug("\n");
    }

    private List<QueryReporter> createCountReporters(String table){
        QueryReporter original = new QueryReporter("original count","select count(*) from "+table);
        QueryReporter join = new QueryReporter("join count"," select count(*) from "+table+" INNER JOIN mdm_org_tree_path ON org_code =  descendant_code and ancestor_code = '330000000000'");
        QueryReporter subSelect = new QueryReporter("subselect count",
                " select count(*) from "+table+" where org_code in " +
                        "(select descendant_code from mdm_org_tree_path where ancestor_code = '330000000000')");
        QueryReporter subSelect2 = new QueryReporter("subselect2 count",
                " select count(*) from (select * from "+table+" where org_code in " +
                        "(select descendant_code from mdm_org_tree_path where ancestor_code = '330000000000')) u");
        return Lists.newArrayList(original,join,subSelect,subSelect2);
    }

    private void runScalarQuery(List<QueryReporter> reporterList) throws Exception{
        for(QueryReporter queryReporter : reporterList){
            long start = System.currentTimeMillis();
            Long count = queryRunner.query(queryReporter.getQueryStr(),new ScalarHandler<Long>(1));
            queryReporter.setResult(count);

            queryReporter.setCost(System.currentTimeMillis()-start);
            LOG.debug("{}",queryReporter);
        }
        LOG.debug("\n");
    }

}
