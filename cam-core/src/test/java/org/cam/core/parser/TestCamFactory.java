package org.cam.core.parser;

import org.cam.core.impl.CamFactoryAdapter;
import org.cam.core.mapping.AbstractEntityTableMappings;
import org.cam.core.mapping.EntityMapping;
import org.cam.core.mapping.EntityTableMapping;

/**
 * Created by wuyaohui on 14-10-2.
 */
public class TestCamFactory extends CamFactoryAdapter {

    @Override
    public EntityTableMapping getEntityTableMapping() {
        return new TestMapping();
    }

    public class TestMapping extends AbstractEntityTableMappings{

        public TestMapping() {

            entityTableMap.put("org.cam.Company","t_company");

            EntityMapping entityMapping = new EntityMapping();
            entityMapping.setName("org.cam.Company");
            entityMapping.getFieldColumnMap().put("country","c_country");
            entityMapping.getFieldColumnMap().put("city","c_city");

            entityMappingMap.put(entityMapping.getName(),entityMapping);
        }
    }
}
