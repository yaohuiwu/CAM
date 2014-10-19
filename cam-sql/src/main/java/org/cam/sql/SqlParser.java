package org.cam.sql;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.cam.sql.antlr.SQLiteLexer;
import org.cam.sql.antlr.SQLiteParser;
import org.cam.sql.antlr.SQLiteVisitor;

public abstract class SqlParser {

    protected SQLiteParser createParser(String sqlStatement){
        ANTLRInputStream antIn = new ANTLRInputStream(sqlStatement);
        SQLiteLexer lexer = new SQLiteLexer(antIn);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new SQLiteParser(tokenStream);
    }

    protected  <T> T visitParseTree(ParseTree pst,SQLiteVisitor<T> visitor){
        return visitor.visit(pst);
    }
}
