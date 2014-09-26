package org.cam.core.mock;

import org.cam.core.UserContextProvider;
import org.cam.core.meta.domain.User;
import org.cam.core.meta.domain.UserImpl;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class MockUserContextProvider implements UserContextProvider{

    @Override
    public User getCurrentUser() {
        return new UserImpl("mock_user");
    }
}
