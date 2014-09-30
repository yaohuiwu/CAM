package org.cam.core.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.loader.CacheLoader;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class Caches {

    public static final CacheLoader DEFAULT_LOADER = null;
    public static final Object DEFAULT_ARG = null;

    public static <V> V get(Object key, Class<V> clazz, Ehcache ehcache){
        Element ele = ehcache.get(key);
        return extractValue(ele,clazz);
    }

    public static Element getWithDefaultLoader(Object key,Ehcache ehcache){
        return getWithDefaultLoader(key,DEFAULT_ARG,ehcache);
    }

    public static Element getWithDefaultLoader(Object key,Object argument,Ehcache ehcache){
        return ehcache.getWithLoader(key,DEFAULT_LOADER,argument);
    }

    @SuppressWarnings("unchecked")
    public static <V> V extractValue(Element ele, Class<V> clazz){
        if(ele!=null){
            Object value = ele.getObjectValue();
            if(value!=null&&clazz.equals(value.getClass())){
                return (V)value;
            }
        }
        return null;
    }

    public static Element element(Object key,Object value){
        return new Element(key,value);
    }
}
