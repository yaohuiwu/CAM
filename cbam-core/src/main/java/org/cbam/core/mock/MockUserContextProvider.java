package org.cbam.core.mock;

import org.cbam.core.UserContextProvider;
import org.cbam.core.meta.domain.User;
import org.cbam.core.meta.domain.UserImpl;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class MockUserContextProvider implements UserContextProvider{

    @Override
    public User getCurrentUser() {
        return new UserImpl("mock_user");
    }
}
