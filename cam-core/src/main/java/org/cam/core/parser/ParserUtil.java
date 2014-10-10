package org.cam.core.parser;

import com.google.common.base.Strings;
import org.cam.core.domain.Permission;

/**
 * Created by yaohui on 14-9-27.
 */
public class ParserUtil {

    public static final String ALL = "*";

    public static final String EMPTY = "";

    public static boolean isAll(String expression){
        return ALL.equals(expression);
    }

    public static boolean typeMatch(String action,String objectType,Permission perm){
        if(Strings.isNullOrEmpty(action) || Strings.isNullOrEmpty(objectType)){
            throw new IllegalArgumentException("null action or objectType");
        }
        if(ParserUtil.isAll(action) || ParserUtil.isAll(objectType)){
            throw new IllegalArgumentException("action and objectType must be specified explicitly.");
        }
        if(perm == null){
            return false ;
        }
        String cmpAction = perm.getAction();
        String cmpObjectType = perm.getObjectType();

        boolean isActionEquals = action.equals(cmpAction);
        boolean isObjectTypeEquals = objectType.equals(cmpObjectType);
        if(isActionEquals && isObjectTypeEquals){
            return true ;//both equals
        }
        boolean isActionAll = isAll(cmpAction);
        if(isActionAll && isObjectTypeEquals){
            return true ;
        }
        boolean isObjectTypeAll = isAll(cmpObjectType) ;
        if((isActionAll && isObjectTypeAll) || (isObjectTypeAll && isActionEquals)){
            return true ;
        }
        return false ;
    }
}
