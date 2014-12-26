package org.cam.sql;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.cam.sql.antlr.SQLiteLexer;
import org.cam.sql.antlr.SQLiteParser;
import org.cam.sql.antlr.SQLiteVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SqlParser {

    private static final Logger LOG = LoggerFactory.getLogger(SqlParser.class);

    public ParseTree parse(String input){
        return parse(new ANTLRInputStream(input));
    }

    public ParseTree parse(InputStream fi){
        return parse(createANTLRInput(fi));
    }

    public ParseTree parse(ANTLRInputStream antIn){
        SQLiteLexer lexer = new SQLiteLexer(antIn);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLiteParser parser = new SQLiteParser(tokenStream);

        return parser.parse();
    }

    public ANTLRInputStream createANTLRInput(InputStream input){
        ANTLRInputStream stream = null;
        try{
            stream = new ANTLRInputStream(input);
        }catch (IOException e){
            LOG.error("Error creating ANTLRInputStream", e);
        }
        return stream;
    }

    public  <T> T visitParseTree(ParseTree pst,SQLiteVisitor<T> visitor){
        return visitor.visit(pst);
    }
}
