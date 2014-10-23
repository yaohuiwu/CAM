package org.cam.sql.query;


import org.cam.sql.SqlParser;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * Created by yaohui on 14-10-19.
 */
public class QueryParserTest {

    private static final Logger LOG = LoggerFactory.getLogger(QueryParserTest.class);

    SqlParser sqlParser ;

    @Before
    public void setUp() throws Exception {
        sqlParser = new SqlParser();

    }

    @Test
    public void testParseSelectFiles() throws Exception {
        URL selectDirUrl = getClass().getClassLoader().getResource("default/select");
        LOG.debug("test sql file dir : {}",selectDirUrl.getFile());

        File selectDir = new File(selectDirUrl.getFile());
        File[] files = selectDir.listFiles();
        LOG.debug("Total file : {}",files.length);

        for(File f : files){
            LOG.debug("Parsing file :{}",f.getName());
            try(FileInputStream fi = new FileInputStream(f);)
            {
                sqlParser.parse(fi);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
