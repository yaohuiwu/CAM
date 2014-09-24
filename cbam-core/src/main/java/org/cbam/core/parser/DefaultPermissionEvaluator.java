package org.cbam.core.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
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
    public boolean isPermit(List<Object> objects, String permission) {
        boolean allPermit = true;
        if(objects!=null){
            for(Object o : objects){
                if(!isPermit(o,permission)){
                    allPermit = false;
                    break;
                }
            }
        }
        return allPermit;
    }

    @Override
    public boolean isPermit(Object object, List<String> permissions) {
        boolean anyPermit = false;
        if(permissions!=null){
            for(String permission : permissions){
                if(isPermit(object,permission)){
                    anyPermit = true;
                    break;
                }
            }
        }
        return anyPermit;
    }
}
