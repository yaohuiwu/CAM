package org.cam.core.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities class that handles plain java objects.
 *
 */
public class ObjectUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ObjectUtils.class);

    private static final int LEG_GET = 3;
    private static final int TOKEN_TWO = 2;

    private ObjectUtils() {
    }

    public static Field getField(Object obj,String attrName){
        Class clazz = obj.getClass();
        Field f = null;
        try {
            f = clazz.getDeclaredField(attrName);
        }catch (NoSuchFieldException e){
            LOG.error("No such field.",e);
        }
        return f;
    }

    public static Class getFieldType(Object obj,String attrName){
        Field f = getField(obj,attrName);
        return f.getType();
    }

    public static Object getFieldValue(Object obj,String attrName){
        Field f = getField(obj,attrName);
        Object value = null;
        try{
            value = f.get(obj);
        }catch (Exception e){
            LOG.error("Exception",e);
        }
        return value;
    }

    /**
     * Equal to {@link org.apache.commons.lang3.StringUtils#strip(String, String)} but with a nicer name.
     *
     * @param str  the String to remove characters from, may be null
     * @param stripChars  the characters to remove, null treated as whitespace
     * @return the stripped String, {@code null} if null String input
     */
    public static String trimWith(String str,String stripChars){
        return StringUtils.strip(str,stripChars);
    }

    /**
     * Get property value from an object with the getter method.
     *
     * @param object the object where the property live in
     * @param fieldName property name
     * @return property value. {@code null} if the common java bean accessor method has tried.
     */
    public static Object getter(final Object object,String fieldName){
        Object property = null;

        StringBuilder s = new StringBuilder("get");
        s.append(StringUtils.capitalize(fieldName));
        try{
            property = MethodUtils.invokeExactMethod(object,s.toString());
        }catch (Exception e){
            //try with isXXX
            StringBuilder s2 = new StringBuilder("is");
            s2.append(StringUtils.capitalize(fieldName));
            try{
                property = MethodUtils.invokeExactMethod(object,s2.toString());
            }catch (Exception ee){
                LOG.error("Exception",ee);
            }
        }
        return property;
    }

    public static String getterField(String getter){
        if(getter.startsWith("get")){
            return StringUtils.uncapitalize(getter.substring(LEG_GET));
        }else{
            return getter;
        }
    }

    /**
     * Check whether given str matches the like pattern.
     *
     * @param str given str
     * @param likePattern sql like pattern , for example , "%tom_at%".
     * @return  {@code true} if matches, otherwise false.
     */
    public static boolean likeMatches(String str,String likePattern){

        Preconditions.checkArgument(likePattern!=null && !likePattern.isEmpty(),"null likePattern");
        //need more strict check
        Pattern sqlLikePt = Pattern.compile("'%?.*%?'");
        Matcher sqlLikeM = sqlLikePt.matcher(likePattern);
        if(!sqlLikeM.matches()){
            throw new IllegalArgumentException("Bad sql like string :"+likePattern);
        }
        String ptCopy = trimWith(likePattern,"'");
        ptCopy = ptCopy.replace("%",".*");
        ptCopy = ptCopy.replace('_','.');
        Pattern p = Pattern.compile(ptCopy);

        return p.matcher(str).matches();
    }

    public static String getWordRegex(String word){
        StringBuilder s = new StringBuilder();
        s.append("\\b");
        s.append(word);
        s.append("\\b");
        return s.toString();
    }

    public static boolean matches(String str,String pattern){
        return Pattern.compile(pattern).matcher(str).matches();
    }

    public static String joinAsSqlIn(Collection<String> items){
        StringBuilder s = new StringBuilder();
        return s.append("'")
         .append(StringUtils.join(items.iterator(),"','"))
         .append("'").toString();
    }

    public static String toSqlString(String s){
        return new StringBuilder().append("'").append(s).append("'").toString();
    }

    public static Matcher getMatcher(String s,String regexString){
        return Pattern.compile(regexString).matcher(s);
    }

    public static String innerWhitespace(String s){
        if(s==null){
            return null;
        }
        String tmp = StringUtils.trim(s);
        String[] splits = StringUtils.split(tmp);
        if(splits.length != TOKEN_TWO){
            throw new IllegalArgumentException("string must contain whitespace like 'abc def'");
        }
        return StringUtils.substring(tmp,splits[0].length(),tmp.indexOf(splits[1]));
    }

    public static String endWhitespace(String s){
        if(s==null){
            return null;
        }
        char[] chars = s.toCharArray();

        StringBuilder b = new StringBuilder();
        for(int i= chars.length-1;i>=0;i--){
            if(Character.isWhitespace(chars[i])){
                b.append(chars[i]);
            }else{
                break;
            }
        }
        return b.toString();
    }

}
