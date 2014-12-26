package org.cam.core.mock;

import org.cam.core.UserContextProvider;
import org.cam.core.domain.User;
import org.cam.core.domain.UserImpl;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class MockUserContextProvider implements UserContextProvider{

    @Override
    public User getCurrentUser() {
        return new UserImpl("mock_user","mock_user");
    }

    @Override
    public void setCurrentUser(User user) {
        //do nothing.
    }
}
