package org.cam.core.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Status;
import net.sf.ehcache.loader.CacheLoader;
import org.cam.core.annotation.ExecutableType;
import org.cam.core.meta.domain.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Created by wuyaohui on 14-9-29.
 */
public class CamCacheLoader implements CacheLoader{

    private static final Logger LOG = LoggerFactory.getLogger(CamCacheLoader.class);

    @Override
    public Object load(Object key) throws CacheException {
        LOG.debug("load {}",key);

        Permission p = new Permission(ExecutableType.CREATE.toString(),"User","org_id=1");
        p.setId("perm_001");
        return p;
    }

    @Override
    public Map loadAll(Collection keys) {
        return null;
    }

    @Override
    public Object load(Object key, Object argument) {
        return null;
    }

    @Override
    public Map loadAll(Collection keys, Object argument) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public CacheLoader clone(Ehcache cache) throws CloneNotSupportedException {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void dispose() throws CacheException {

    }

    @Override
    public Status getStatus() {
        return null;
    }
}
