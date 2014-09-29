package org.cam.core;

import org.apache.commons.dbutils.DbUtils;
import org.cam.core.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class ScriptHelper {

    private static final Logger LOG = LoggerFactory.getLogger(ScriptHelper.class);

    public static void runScript(DataSource dataSource,String classPathFile){
        URL fileUrl = ScriptHelper.class.getClassLoader().getResource(classPathFile);
        runScript(dataSource,fileUrl);
    }

    public static void runScript(DataSource dataSource,URL url){
        //load cam_schema.sql from classpath
        Connection con = null;
        ScriptRunner scriptRunner = null;
        FileInputStream fi = null;
        try{
            fi = new FileInputStream(url.getFile());
            Reader reader = new InputStreamReader(fi,"UTF-8");
            con = dataSource.getConnection();
            scriptRunner = new ScriptRunner(con);
            scriptRunner.runScript(reader);

        }catch (IOException ioe){
            throw new RuntimeException("error create reader for file "+url,ioe.getCause());
        }catch (SQLException sqlE){
            throw new DataException("error execute script file "+url,sqlE.getCause());
        }
        finally {
            DbUtils.closeQuietly(con);
            if(fi!=null){
                try{
                    fi.close();
                }catch (IOException e){
                }
            }
        }
    }
}
