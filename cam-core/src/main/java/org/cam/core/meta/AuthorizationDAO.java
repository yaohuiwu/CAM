package org.cam.core.meta;

import org.cam.core.meta.domain.Authorization;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface AuthorizationDAO {

    public List<Authorization> getAllAuthorization();
}
