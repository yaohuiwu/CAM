package org.cbam.core.db.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Authorization entity.
 */
public interface User extends Serializable{

    public String getId();

    public String getName();

}
