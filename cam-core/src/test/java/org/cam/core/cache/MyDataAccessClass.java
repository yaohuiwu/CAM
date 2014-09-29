package org.cam.core.cache;

import net.sf.ehcache.CacheEntry;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;
import net.sf.ehcache.writer.CacheWriter;
import net.sf.ehcache.writer.writebehind.operations.SingleOperationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by wuyaohui on 14-9-28.
 */
public class MyDataAccessClass<K,V> {

    private static final Logger LOG = LoggerFactory.getLogger(CacheDataAccessor.class);

    private final Ehcache cache;
    public MyDataAccessClass(Ehcache cache)
    {
        cache.registerCacheWriter(new MyCacheWriter());
        this.cache = new SelfPopulatingCache(cache,new MyCacheEntryFactory());
    }
    /* get some data - notice the cache is treated as an SOR.
    * the application code simply assumes the key will always be available
    */
    public V readSomeData(K key)
    {
        Element e = cache.get(key);
        return e != null ?(V)e.getObjectValue():null;
    }
    /* write some data - notice the cache is treated as an SOR, it is
    * the cache's responsibility to write the data to the SOR.
    */
    public void writeSomeData(K key, V value)
    {
        cache.putWithWriter(new Element(key, value));
    }
    /**
     * Implement the CacheEntryFactory that allows the cache to provide
     * the get-through strategy
     */
    private class MyCacheEntryFactory implements CacheEntryFactory
    {
        public Object createEntry(Object key) throws Exception
        {
//            return readDataFromDataStore(key);
            LOG.debug("get data with key [{}] from data store ",key);
            return null;
        }
    }

    /**
     * Implement the CacheWriter interface which allows the cache to provide
     * the write-through or write-behind strategy.
     */
    private class MyCacheWriter implements CacheWriter{
        @Override
        public CacheWriter clone(Ehcache cache) throws CloneNotSupportedException {
            return null;
        }

        @Override
        public void init() {

        }

        @Override
        public void dispose() throws CacheException {

        }

        @Override
        public void write(Element element) throws CacheException {

            LOG.debug("write data with element [{}] from data store ",element);
        }

        @Override
        public void writeAll(Collection<Element> elements) throws CacheException {

        }

        @Override
        public void delete(CacheEntry entry) throws CacheException {

        }

        @Override
        public void deleteAll(Collection<CacheEntry> entries) throws CacheException {

        }

        @Override
        public void throwAway(Element element, SingleOperationType operationType, RuntimeException e) {

        }
    }

}
