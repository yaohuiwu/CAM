package org.cam.core.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.cam.core.Executable;
import org.cam.core.meta.domain.Permission;
import org.cam.core.parser.antlr.PermissionLexer;
import org.cam.core.parser.antlr.PermissionParser;

import java.util.List;
import java.util.Map;

/**
 * Created by wuyaohui on 14-9-27.
 */
public class AbstractPermissionEvaluator{

    protected ParseTree createParseTree(String permission){
        ANTLRInputStream antIn = new ANTLRInputStream(permission);

        PermissionLexer lexer = new PermissionLexer(antIn);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PermissionParser parser = new PermissionParser(tokenStream);
        return parser.permission();
    }


}
