package org.cam.core.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.loader.CacheLoader;
import net.sf.ehcache.loader.CacheLoaderFactory;
import org.cam.core.CamFactory;
import org.cam.core.FactoryHelper;
import org.cam.core.dao.PersistentDao;

import java.util.Properties;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class CamCacheLoaderFactory extends CacheLoaderFactory{

    @Override
    public CacheLoader createCacheLoader(Ehcache cache, Properties properties) {
        CamFactory camFactory = FactoryHelper.factory();
        PersistentDao persistentDao = null;
        if(camFactory!=null){
            persistentDao = camFactory.getPersistentDao();
        }
        return new CamCacheLoader(persistentDao);
    }
}
