package org.cam.proxy.hibernate;

import org.cam.core.mapping.AbstractEntityTableMappings;
import org.cam.core.mapping.EntityField;
import org.cam.core.mapping.EntityMapping;
import org.cam.core.util.ObjectUtils;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Selectable;
import org.hibernate.property.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Member;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by wuyaohui on 14-10-2.
 */
@SuppressWarnings("unchecked")
public class HibernateEntityTableMappingImpl extends AbstractEntityTableMappings{

    private static final Logger LOG = LoggerFactory.getLogger(HibernateEntityTableMappingImpl.class);

    private Configuration configuration;

    public HibernateEntityTableMappingImpl(Configuration configuration) {
        if(configuration==null){
            throw new IllegalArgumentException("Null hibernate configuration");
        }
        LOG.debug("Found hibernate configuration.");

        this.configuration = configuration;
        HibernateHelper.registerConfiguration(configuration);

        //init entityTableMap
        Iterator<PersistentClass> it = configuration.getClassMappings();
        while(it.hasNext()){
            PersistentClass pClass = it.next();

            EntityMapping entityMapping = new EntityMapping();
            entityMapping.setName(pClass.getEntityName());

            Iterator<Property> iterator = pClass.getPropertyIterator();
            while(iterator.hasNext()){
                Property p = iterator.next();
                Getter getter = p.getGetter(pClass.getMappedClass());
                Member member = getter.getMember();
                //ignore the collection field
                if(Collection.class.isAssignableFrom(getter.getReturnType())){
                    LOG.trace("ignore collection member :{}",member);
                    continue;
                }

                Iterator<Selectable> colIt = p.getColumnIterator();
                Selectable selectable = colIt.next();
                if(selectable instanceof Column){
                    Column col = (Column)selectable;
                    String fieldName = ObjectUtils.getterField(member.getName());
                    entityMapping.getFieldColumnMap().put(fieldName, col.getName());

                    EntityField entityField = new EntityField(fieldName,getter.getReturnType().getName());
                    entityMapping.getFieldMap().put(fieldName,entityField);
                }
            }
            entityTableMap.put(entityMapping.getName(), pClass.getTable().getName());
            entityMappingMap.put(entityMapping.getName(),entityMapping);

        }

        LOG.debug("{} entities detected",entityMappingMap.size());
    }

}
