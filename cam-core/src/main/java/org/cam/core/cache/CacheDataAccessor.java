package org.cam.core.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by wuyaohui on 14-9-28.
 */
public class CacheDataAccessor<K,V> {

    private final Ehcache cache;

    public CacheDataAccessor(Ehcache cache){
        this.cache = cache;
    }

    /* get some data - notice the cache is treated as an SOR.
    * the application code simply assumes the key will always be available
    */
    @SuppressWarnings("unchecked")
    public V get(K key){
        Element e = cache.get(key);
        return e != null ? (V)e.getObjectValue():null;
    }

    public List<V> getAll(Collection<String> keys){
        return Collections.EMPTY_LIST;
    }
    /* write some data - notice the cache is treated as an SOR, it is
    * the cache's responsibility to write the data to the SOR.
    */
    public void write(K key, V value){
        cache.putWithWriter(new Element(key, value));
    }

    public void put(K key, V value){
        cache.put(new Element(key, value));
    }

    public void delete(K key){
        cache.removeWithWriter(key);
    }

    public void remove(K key){
        cache.remove(key);
    }
}
