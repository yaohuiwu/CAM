package org.cbam.core;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities class that handles plain java objects.
 *
 */
public class ObjectUtils {

    public static final Object[] EMPTY_OBJECTS =  new Object[0];

//    static Perl5Compiler compiler = new Perl5Compiler();
//    static PatternMatcher pm = new Perl5Matcher();

    private static final Logger LOG = LoggerFactory.getLogger(ObjectUtils.class);

    public static Field getField(Object obj,String attrName){
        Class clazz = obj.getClass();
        Field f = null;
        try {
            f = clazz.getDeclaredField(attrName);
        }catch (NoSuchFieldException e){}
        return f;
    }

    public static Class<?> getFieldType(Object obj,String attrName){
        Field f = getField(obj,attrName);
        return f.getType();
    }

    public static Object getFieldValue(Object obj,String attrName){
        Field f = getField(obj,attrName);
        Object value = null;
        try{
            value = f.get(obj);
        }catch (Exception e){
            e.printStackTrace();
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
//                ee.printStackTrace();
                throw new RuntimeException(ee.getCause());
            }
        }
        return property;
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
        boolean r = false;

        Pattern sqlLikePt = Pattern.compile("'%?.*%?'");//need more strict check
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

}
