package org.cam.core.cache;

import net.sf.ehcache.store.compound.ReadWriteCopyStrategy;
import org.cam.core.Copyable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-9-28.
 */
public class CloneCopyStrategy<T> implements ReadWriteCopyStrategy<T>{

    private static final Logger LOG = LoggerFactory.getLogger(CloneCopyStrategy.class);

    @Override
    public T copyForWrite(T value) {
        return copy(value);
    }

    @Override
    public T copyForRead(T storedValue) {
        return copyForWrite(storedValue);
    }

    public <T> T copy(T value) {
        if(value!=null && value instanceof Copyable){
            LOG.debug("copy {} with CloneCopyStrategy.",value);
            return (T)((Copyable)value).copy();
        }
        return null;
    }
}
