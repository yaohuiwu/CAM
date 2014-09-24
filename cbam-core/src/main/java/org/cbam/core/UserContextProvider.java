package org.cbam.core;

import org.cbam.core.meta.domain.User;

/**
 * Created by wuyaohui on 14-9-24.
 */
public interface UserContextProvider {

    public User getCurrentUser();
}
