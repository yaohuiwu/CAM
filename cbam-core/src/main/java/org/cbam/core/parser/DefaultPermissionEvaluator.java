package org.cbam.core.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.cbam.core.Action;
import org.cbam.core.Executable;
import org.cbam.core.meta.domain.Permission;
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
    public boolean isPermit(Executable executable, Permission permission) {
        //TODO to be implemented.
        return false;
    }

    @Override
    public boolean isAnyPermit(Executable executable, List<Permission> permissions) {
        //TODO to be implemented.
        return false;
    }
}
