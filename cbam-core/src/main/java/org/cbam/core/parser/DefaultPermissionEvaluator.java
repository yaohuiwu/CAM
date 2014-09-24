package org.cbam.core.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.cbam.core.Action;
import org.cbam.core.parser.antlr.PermissionLexer;
import org.cbam.core.parser.antlr.PermissionParser;

import java.util.List;


/**
 * Created by yaohui on 14-9-21.
 */
public class DefaultPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean isPermit(Object object, String permission) {

        ANTLRInputStream antIn = new ANTLRInputStream(permission);

        PermissionLexer lexer = new PermissionLexer(antIn);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PermissionParser parser = new PermissionParser(tokenStream);
        ParseTree tree = parser.permission();

        PermVisitor pv = new PermVisitor(object);
        return pv.visit(tree);
    }

    @Override
    public boolean isPermit(Action action, String permission) {
        return false;
    }

    @Override
    public boolean isAnyPermit(Action action, List<String> permissions) {
        return false;
    }
}
