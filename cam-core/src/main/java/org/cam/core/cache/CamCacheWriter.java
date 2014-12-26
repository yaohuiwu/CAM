package org.cam.core.cache;

import net.sf.ehcache.CacheEntry;
import net.sf.ehcache.Element;
import net.sf.ehcache.writer.AbstractCacheWriter;

import java.util.Collection;

/**
 * Implement the CacheWriter interface which allows the cache to provide
 * the write-through or write-behind strategy.
 */
public class CamCacheWriter extends AbstractCacheWriter {

    @Override
    public void write(Element element){
        // Write an element to SOR.
    }

    @Override
    public void writeAll(Collection<Element> elements){
        //Write given elements to SOR.
    }

    @Override
    public void delete(CacheEntry entry){
        //Delete entry from cache.
    }

    @Override
    public void deleteAll(Collection<CacheEntry> entries){
        //Delete given entries from cache.
    }

}
