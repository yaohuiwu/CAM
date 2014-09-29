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
//        List<Permission> permList = Lists.newArrayList();
//
//        Permission per = new Permission(action,objectType,"country = 'USA'");
//        permList.add(per);
        return new UserImpl("mock_user");
    }
}
