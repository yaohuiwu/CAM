package org.cam.core.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.loader.CacheLoader;
import net.sf.ehcache.util.ClassLoaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class Caches {

    private Caches() {
    }

    private static CacheManager cacheManager = null;

    private static final Logger LOG = LoggerFactory.getLogger(Caches.class);

    public static final CacheLoader DEFAULT_LOADER = null;
    public static final Object DEFAULT_ARG = null;
    public static final String CORE_CACHE_MANAGER_FILE = "/ehcache-cam.xml";

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

    public static CacheManager getCacheManager(){
        synchronized (Caches.class){
            if(cacheManager==null){
                cacheManager = createCoreCacheManager();
            }
        }
        return cacheManager;
    }

    private static CacheManager createCoreCacheManager(){
        URL url = null;
        ClassLoader standardClassloader = ClassLoaderUtil.getStandardClassLoader();
        if (standardClassloader != null) {
            url = standardClassloader.getResource(CORE_CACHE_MANAGER_FILE);
        }
        if(url != null){
            LOG.debug("Cam cache config file :{} found in standard classpath : {}",CORE_CACHE_MANAGER_FILE,url);
        }else{
            url = Caches.class.getResource(CORE_CACHE_MANAGER_FILE);
            if(url != null){
                LOG.debug("Cam cache config file :{} found in classpath : {}",CORE_CACHE_MANAGER_FILE,url);
            }else{
                throw new IllegalStateException(" Cam cache config file "+CORE_CACHE_MANAGER_FILE +" Not found.");
            }
        }

        return CacheManager.newInstance(url);
    }
}
