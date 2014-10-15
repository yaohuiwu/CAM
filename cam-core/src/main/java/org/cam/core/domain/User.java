package org.cam.core.domain;

import org.cam.core.cache.Copyable;

import java.io.Serializable;

/**
 * Authorization entity.
 */
public interface User extends Serializable,Copyable{

    public String getId();

    public String getName();

}
