package org.cam.sql.query;

import org.antlr.v4.runtime.tree.ParseTree;
import org.cam.sql.antlr.SQLiteParser;
import org.cam.sql.antlr.SQLiteVisitor;
import org.cam.sql.SqlParser;

/**
 * Created by wuyaohui on 14-10-19.
 */
public class QueryParser extends SqlParser{

    public <T> T parseQuery(String queryStatement,SQLiteVisitor<T> visitor){
        SQLiteParser parser = createParser(queryStatement);
        ParseTree pst = parser.select_stmt();
        return visitParseTree(pst,visitor);
    }
}
