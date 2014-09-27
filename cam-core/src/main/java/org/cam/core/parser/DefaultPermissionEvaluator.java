package org.cam.core.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.cam.core.Executable;
import org.cam.core.Logs;
import org.cam.core.meta.domain.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by yaohui on 14-9-21.
 */
public class DefaultPermissionEvaluator extends AbstractPermissionEvaluator implements PermissionEvaluator{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultPermissionEvaluator.class);

    @Override
    public boolean isPermit(Object object, String permission) {
        ParseTree tree = createParseTree(permission);
        DefaultPermissionVisitor pv = new DefaultPermissionVisitor(object);
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

    @Override
    public String toSqlCriteria(Map<String, String> fieldColumnMap, List<Permission> permissions) {
        StringBuilder s = new StringBuilder();
        if(permissions!=null){
            Iterator<Permission> iterator = permissions.iterator();
            while(iterator.hasNext()){
                Permission perm = iterator.next();
                Logs.debugIfEnabled(LOG, "{}", perm);

                ParseTree pt = createParseTree(perm.toString());
                SQLCriteriaTranslator translator = new SQLCriteriaTranslator(fieldColumnMap);
                s.append(translator.visit(pt));
                if(iterator.hasNext()){
                    s.append(" or ");
                }
            }
        }
        return s.toString();
    }

}
