package org.cam.core.cache;

import com.google.common.collect.Lists;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wuyaohui on 14-9-28.
 */
public class CacheDataAccessor<K,V> {

    private static final Logger LOG = LoggerFactory.getLogger(CacheDataAccessor.class);

    private final Ehcache cache;

    public CacheDataAccessor(Ehcache cache){
        this.cache = cache;
    }

    /* get some data - notice the cache is treated as an SOR.
    * the application code simply assumes the key will always be available
    */
    @SuppressWarnings("unchecked")
    public V get(K key)
    {
        Element e = cache.get(key);
        return e != null ? (V)e.getObjectValue():null;
    }

    public List<V> getAll(Collection<String> keys)
    {
//        List<V> values = Lists.newLinkedList();
//        Iterator<Element> it = elements.values().iterator();
//        while(it.hasNext()){
//            values.add((V)it.next().getObjectValue());
//        }
        return null;
    }

    /* write some data - notice the cache is treated as an SOR, it is
    * the cache's responsibility to write the data to the SOR.
    */
    public void write(K key, V value)
    {
        cache.putWithWriter(new Element(key, value));
    }

    public void delete(K key){
        cache.removeWithWriter(key);
    }
}
