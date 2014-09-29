package org.cam.core.cache;

import net.sf.ehcache.Element;
import net.sf.ehcache.store.compound.ReadWriteCopyStrategy;
import org.cam.core.CamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wuyaohui on 14-9-28.
 */
public class CloneCopyStrategy implements ReadWriteCopyStrategy<Element>{

    private static final Logger LOG = LoggerFactory.getLogger(CloneCopyStrategy.class);

    @Override
    public Element copyForWrite(Element value) {
        return value!=null ? new Element(value.getObjectKey(),copy(value.getObjectValue())) : null;
    }

    @Override
    public Element copyForRead(Element storedValue) {
        return copyForWrite(storedValue);
    }

    public Object copy(Object value) {
        if(value!=null){
            if(value instanceof Copyable){
                if(LOG.isTraceEnabled()){
                    LOG.trace("Copy {} with CloneCopyStrategy",value);
                }
                return ((Copyable)value).copy();
            }
            throw new CamException(value.getClass().getSimpleName()+" is not instance of Copyable.");
        }
        return null;
    }
}
