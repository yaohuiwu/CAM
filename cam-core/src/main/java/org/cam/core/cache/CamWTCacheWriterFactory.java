package org.cam.core.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.writer.CacheWriter;
import net.sf.ehcache.writer.CacheWriterFactory;

import java.util.Properties;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class CamWTCacheWriterFactory extends CacheWriterFactory{

    @Override
    public CacheWriter createCacheWriter(Ehcache cache, Properties properties) {
        return new CamCacheWriter();
    }
}
