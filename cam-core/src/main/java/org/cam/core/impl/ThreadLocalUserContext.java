package org.cam.core.impl;

import org.cam.core.UserContextProvider;
import org.cam.core.domain.User;
import org.cam.core.domain.UserImpl;

public abstract class ThreadLocalUserContext implements UserContextProvider {

    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();

    @Override
    public final User getCurrentUser() {
        User currentUser = getThreadUser();
        return currentUser!=null?currentUser: UserImpl.ANONYMOUS_USER;
    }

    /**
     * 设置线程绑定用户.
     *
     * @param user
     */
    protected static void setThreadUser(User user){
        USER_THREAD_LOCAL.set(user);
    }

    /**
     * 移除线程绑定用户
     */
    protected static void removeThreadUser(){
        USER_THREAD_LOCAL.remove();
    }

    /**
     * get thread user.
     *
     * @return
     */
    protected static User getThreadUser(){
        return USER_THREAD_LOCAL.get();
    }

}
