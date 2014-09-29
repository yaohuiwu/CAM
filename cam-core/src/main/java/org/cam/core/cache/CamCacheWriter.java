package org.cam.core.cache;

import net.sf.ehcache.CacheEntry;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Element;
import net.sf.ehcache.writer.AbstractCacheWriter;
import net.sf.ehcache.writer.writebehind.operations.SingleOperationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Implement the CacheWriter interface which allows the cache to provide
 * the write-through or write-behind strategy.
 */
public class CamCacheWriter extends AbstractCacheWriter {

    private static final Logger LOG = LoggerFactory.getLogger(CamCacheWriter.class);

//    @Override
//    public CacheWriter clone(Ehcache cache) throws CloneNotSupportedException {
//        return null;
//    }

//    @Override
//    public void init() {
//
//    }

//    @Override
//    public void dispose() throws CacheException {
//
//    }

    @Override
    public void write(Element element) throws CacheException {
        LOG.debug("write {} to SOR",element);
    }

    @Override
    public void writeAll(Collection<Element> elements) throws CacheException {
        LOG.debug("write all {} to SOR",elements);
    }

    @Override
    public void delete(CacheEntry entry) throws CacheException {
        LOG.debug("delete {} from SOR",entry);
    }

    @Override
    public void deleteAll(Collection<CacheEntry> entries) throws CacheException {
        LOG.debug("write all {} to SOR",entries);
    }

    @Override
    public void throwAway(Element element, SingleOperationType operationType, RuntimeException e) {

    }
}
