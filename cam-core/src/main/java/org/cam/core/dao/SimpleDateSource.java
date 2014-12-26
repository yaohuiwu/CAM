package org.cam.core.dao;

import org.cam.core.exception.DataException;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wuyaohui on 14-9-29.
 * <p>
 *     Copy from http://www.open-open.com/lib/view/open1338106062370.html.
 * </p>
 * Just for test.
 */
public class SimpleDateSource implements DataSource{

    private static final String MSG_OPERATION_NOT_SUPPORTED =  "unsupported Operation.";
    private static final int DEFAULT_POOL_SIZE = 3;

    private int poolSize = DEFAULT_POOL_SIZE;//默认为3个

    private List<Connection> pool = new LinkedList<Connection>();

    public SimpleDateSource(String driver,String url,String name,String pwd){
        this(driver, url, name, pwd, DEFAULT_POOL_SIZE);
    }

    public SimpleDateSource(String driver,String url,String name,String pwd,int poolSize){

        try{
            Class.forName(driver);
            this.poolSize=poolSize;

            if(poolSize<=0){
                throw new DataException("不支持的池大小"+poolSize);
            }

            for(int i=0;i<poolSize;i++){
                Connection con = DriverManager.getConnection(url, name, pwd);
                con = ConnProxy.getProxiedConnection(con, pool);//获取被代理的对象
                pool.add(con);//添加被代理的对象
            }
        }catch(Exception e){
            throw new DataException(e.getMessage(),e);
        }
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new UnsupportedOperationException(MSG_OPERATION_NOT_SUPPORTED);
    }

    /**
     * 获取池大小
     */
    public int getPoolSize() {
        return poolSize;
    }

    /**
     * 不支持日志操作
     */
    public PrintWriter getLogWriter() throws SQLException {
        throw new UnsupportedOperationException(MSG_OPERATION_NOT_SUPPORTED);
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        throw new UnsupportedOperationException(MSG_OPERATION_NOT_SUPPORTED);
    }

    /**
     * 不支持超时操作
     */
    public void setLoginTimeout(int seconds) throws SQLException {
        throw new UnsupportedOperationException(MSG_OPERATION_NOT_SUPPORTED);
    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @SuppressWarnings("unchecked")
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return (T)this;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return DataSource.class.equals(iface);
    }

    /**
     * 从池中取一个连接对象<br/>
     * 使用了同步和线程调度技术
     */
    public Connection getConnection() throws SQLException {

        synchronized (pool) {
            if(pool.size()==0){
                try {
                    pool.wait();
                } catch (InterruptedException e) {
                    throw new DataException(e.getMessage(),e);
                }
                return getConnection();
            }else{
                return pool.remove(0);
            }
        }
    }

    public Connection getConnection(String username, String password)
            throws SQLException {
        throw new UnsupportedOperationException("不支持接收用户名和密码的操作");
    }

    /**
     * 静态内部类，实现对Connection的动态代理
     * @author <a href="mailto:wj@itcast.cn">王健</a>
     * @version 1.0 2012-5-6
     */
    static class ConnProxy implements InvocationHandler {

        private Object o;

        private List<Connection> pool;

        private ConnProxy(Object o,List<Connection> pool){
            this.o=o;
            this.pool=pool;
        }

        public static Connection getProxiedConnection(Object o, List<Connection> pool){
            return (Connection) Proxy.newProxyInstance(o.getClass().getClassLoader(),
                    new Class[]{Connection.class}, new ConnProxy(o, pool));

        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if("close".equals(method.getName())){
                synchronized (pool) {
                    pool.add((Connection) proxy);//将被代理的对象放回池中
                    pool.notify();//通知等待线程去获取一个连接吧
                }
                return null;
            }else{
                return method.invoke(o, args);
            }
        }

    }
}
