package org.cam.sql.query;


import org.cam.sql.SqlParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * Created by yaohui on 14-10-19.
 */
public class QueryParserTest {

    SqlParser sqlParser ;

    @Before
    public void setUp() throws Exception {
        sqlParser = new SqlParser();

    }

    @Test
    public void testParseSelectFiles() throws Exception {
        URL selectDirUrl = getClass().getClassLoader().getResource("default/select");
        System.out.println(selectDirUrl.getFile());

        File selectDir = new File(selectDirUrl.getFile());
        File[] files = selectDir.listFiles();
        for(File f : files){
            System.out.println(f.getName());
            try(FileInputStream fi = new FileInputStream(f);)
            {
                sqlParser.parse(fi);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
