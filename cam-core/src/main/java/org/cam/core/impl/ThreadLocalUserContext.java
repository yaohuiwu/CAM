package org.cam.core.impl;

import org.cam.core.UserContextProvider;
import org.cam.core.domain.User;
import org.cam.core.domain.UserImpl;

public abstract class ThreadLocalUserContext implements UserContextProvider {

    private static final ThreadLocal<User> threadUser = new ThreadLocal<>();

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
        threadUser.set(user);
    }

    /**
     * 移除线程绑定用户
     */
    protected static void removeThreadUser(){
        threadUser.remove();
    }

    /**
     * get thread user.
     *
     * @return
     */
    protected static User getThreadUser(){ return threadUser.get(); }

}
