package org.cbam.core.meta;

import org.cbam.core.meta.domain.Authorization;

import java.util.List;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface AuthorizationDAO {

    public List<Authorization> getAllAuthorization();
}
