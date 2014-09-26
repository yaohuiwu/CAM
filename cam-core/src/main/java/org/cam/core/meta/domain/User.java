package org.cam.core.meta.domain;

import java.io.Serializable;

/**
 * Authorization entity.
 */
public interface User extends Serializable{

    public String getId();

    public String getName();

}
