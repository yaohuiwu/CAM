package org.cam.core.cache;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.dbutils.DbUtils;
import org.cam.core.action.annotation.ExecutableType;
import org.cam.core.domain.Permission;
import org.cam.core.domain.Role;
import org.cam.core.parser.DefaultPermissionEvaluator;
import org.cam.core.parser.PermissionEvaluator;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by wuyaohui on 14-9-28.
 */
@Ignore
public class UserRoleCacheInitializationCostTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserRoleCacheInitializationCostTest.class);

    Connection conn;
    String dbHost = "192.168.8.172";

    String userTableSchema = "CREATE TABLE IF not exists `t_user` (\n" +
            "  `id` bigint(20) NOT NULL,\n" +
            "  `name` varchar(50) DEFAULT NULL,\n" +
            "  `age` int(11) DEFAULT NULL,\n" +
            "  `height` double DEFAULT NULL,\n" +
            "  `college` varchar(255) DEFAULT NULL,\n" +
            "  `phoneNumber` varchar(20) DEFAULT NULL,\n" +
            "  `salary` double(10,2) DEFAULT NULL,\n" +
            "  `company` varchar(255) DEFAULT NULL,\n" +
            "  `city` varchar(255) DEFAULT NULL,\n" +
            "  `country` varchar(255) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    @Before
    public void setUp() throws Exception {
        final int dataToCreate = 10000;

        String[] names = {"Tom","Lily","Xiaoming","David","Tiger"};
        int[] ages = {18,19,22,31,25};
        double[] heights = {175.0,180.0,190.2,155.0};
        String[] colleges = {"Beijing University","Qsing Hua University","RenMin University"};
        String[] phoneNumbers = {"15652367037","18652367037","15538511283"};
        double[] salaries = {12000.0,8000,9000,7000};
        String[] companies = {"Pekall","Google","Apple"};
        String[] cities = {"BeiJing","TianJing","DaLian","LuoYang"};

        Random r = new Random();

        String url = "jdbc:mysql://"+dbHost+"/test";
        //change password if yours is not empty.
        conn = DriverManager.getConnection(url,"root","pekall1234");
        //prepare User table
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            int created =st.executeUpdate(userTableSchema);
            if(created>0){
                LOG.debug("table t_user created .");
            }

            rs = st.executeQuery("select count(id) from t_user");
            rs.next();
            Long count = rs.getLong(1);
            if(count>0){

                LOG.debug("{} record exists.",count);
                return ;
            }
        }finally {
            DbUtils.closeQuietly(rs);
            DbUtils.closeQuietly(st);
        }

        String insert = "insert into t_user values (?,?,?,?,?,?,?,?,?,?)";

        //prepare User data : 10000

        //batch size :  Data gen time cost
        //20            11979ms
        //50            10069ms
        //100           10873ms
        final int batchSize = 100;

        PreparedStatement pstmt = null;
        final boolean autoCommit = conn.getAutoCommit();
        long startTime = System.currentTimeMillis();
        try{
            if(autoCommit){
                conn.setAutoCommit(false);
            }
            pstmt = conn.prepareCall(insert);

            for(int i=1;i<=dataToCreate ;i++){
                pstmt.setLong(1, (long) i);
                pstmt.setString(2,names[r.nextInt(names.length)]);
                pstmt.setInt(3, ages[r.nextInt(ages.length)]);
                pstmt.setDouble(4,heights[r.nextInt(heights.length)]);
                pstmt.setString(5,colleges[r.nextInt(colleges.length)]);
                pstmt.setString(6,phoneNumbers[r.nextInt(phoneNumbers.length)]);
                pstmt.setDouble(7,salaries[r.nextInt(salaries.length)]);
                pstmt.setString(8,companies[r.nextInt(companies.length)]);
                pstmt.setString(9,cities[r.nextInt(cities.length)]);
                pstmt.setString(10,"China");

                pstmt.addBatch();

                if(i%batchSize == 0){
                    LOG.debug("i={}",i);
                    pstmt.executeBatch();
                }
            }

            if(dataToCreate % batchSize != 0){
                pstmt.executeBatch();
            }
        }finally {
            conn.commit();
            conn.setAutoCommit(autoCommit);
            DbUtils.closeQuietly(pstmt);
        }
        LOG.info("Data gen time cost :{}ms", costMillis(startTime));
    }

    @Test
    public void testCalculateRoleOfUserInMem() throws Exception {

        long startTime = System.currentTimeMillis();

        PermissionEvaluator evaluator = new DefaultPermissionEvaluator();

        List<Role> roles = Lists.newArrayList(
                new Role("1","20Up","age>20"),
                new Role("2","Pekall","company='Pekall'"),
                new Role("3","Googler","company='Google'")
        );

        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select * from t_user");
            while(rs.next()){
               TestUser u = createUser(rs);
                for(Role role : roles){
                    evaluator.isPermit(u,toPermissionString(role));
//                    if(evaluator.isPermit(u,toPermissionString(role))){
//                    }
                }
////                        LOG.debug("user {} has role {}",u.getId(),role.getName());
            }
        }finally {
            DbUtils.closeQuietly(st);
        }
        LOG.info("Time cost {}ms",costMillis(startTime));
    }

    @Test
    public void testCalculateRoleOfUserByQuery() throws Exception {
        PermissionEvaluator evaluator = new DefaultPermissionEvaluator();

        List<Role> roles = Lists.newArrayList(
                new Role("1","20Up","age>20"),
                new Role("2","Pekall","company='Pekall'"),
                new Role("3","Googler","company='Google'")
        );

        final Map<String,String> fieldColumnMap = Maps.newHashMap();
        fieldColumnMap.put("age","age");
        fieldColumnMap.put("company","company");

        Statement st = null;
        ResultSet rs = null;

        long startTime = System.currentTimeMillis();

        st = conn.createStatement();

        for(Role role : roles){

            Permission p = toPermission(role);
            String sql = "select count(id) from t_user where "+evaluator.toSqlCriteria(Collections.singletonList(p));

            LOG.info("query [{}]",sql);
            rs = st.executeQuery(sql);

            rs.next();
            LOG.info("{} users has role {}",rs.getLong(1),role.getName());
        }
        DbUtils.closeQuietly(st);

        LOG.info("cost {} ms",costMillis(startTime));
    }

    private String toPermissionString(Role r){
        return ExecutableType.VIEW.toString()+":com.pekall.User:"+r.getUserCriteria();
    }

    private Permission toPermission(Role r){
        return new Permission(ExecutableType.VIEW.toString(),"com.pekall.mdm.User",r.getUserCriteria());
    }

    @After
    public void tearDown() throws Exception {
        if(conn!=null&&!conn.isClosed()){
            conn.close();
        }
    }

    public long costMillis(long startTime){
        return System.currentTimeMillis() - startTime;
    }

    private TestUser createUser(ResultSet r) throws SQLException{

        TestUser u = new TestUser();
        u.setId(r.getLong("id"));
        u.setName(r.getString("name"));
        u.setAge(r.getInt("age"));
        u.setCity(r.getString("city"));
        u.setCollege(r.getString("college"));
        u.setCompany(r.getString("company"));
        u.setHeight(r.getDouble("height"));
        u.setPhoneNumber(r.getString("phoneNumber"));
        u.setSalary(r.getDouble("salary"));
        u.setCountry(r.getString("country"));

        return u;
    }

    public class TestUser{

        private long id;
        private String name;
        private int age;
        private double height;
        private String college;
        private String phoneNumber;
        private double salary;
        private String company;
        private String city;
        private String country;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
