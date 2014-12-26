package org.cam.core.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.cam.core.action.Executable;
import org.cam.core.domain.Permission;

import java.util.Iterator;
import java.util.List;


/**
 * Created by yaohui on 14-9-21.
 */
public class DefaultPermissionEvaluator extends AbstractPermissionEvaluator implements PermissionEvaluator{

    @Override
    public boolean isPermit(Object object, String permission) {
        ParseTree tree = createParseTree(permission);
        DefaultPermissionVisitor pv = new DefaultPermissionVisitor(object);
        return pv.visit(tree);
    }

    @Override
    public boolean isPermit(Executable executable, Permission permission) {
        return false;
    }

    @Override
    public boolean isAnyPermit(Executable executable, List<Permission> permissions) {
        return false;
    }

    @Override
    public String toSqlCriteria(List<Permission> permissions) {
        StringBuilder s = new StringBuilder();
        if(permissions!=null){
            Iterator<Permission> iterator = permissions.iterator();
            while(iterator.hasNext()){
                Permission perm = iterator.next();

                ParseTree pt = createParseTree(perm.toString());
                SQLCriteriaTranslator translator = new SQLCriteriaTranslator();

                String sqlCri = translator.visit(pt);
                if(ParserUtil.isAll(sqlCri)){
                    return ParserUtil.CHAR_ASTERISK;
                }
                s.append(sqlCri);
                if(iterator.hasNext()){
                    s.append(" or ");
                }
            }
        }
        return s.toString();
    }

}
