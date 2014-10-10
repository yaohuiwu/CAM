package org.cam.core.impl;

import org.cam.core.UserContextProvider;
import org.cam.core.domain.User;

public abstract class ThreadLocalUserContext implements UserContextProvider {

    private static final ThreadLocal<User> threadUser = new ThreadLocal<>();

    @Override
    public User getCurrentUser() {
        return null;
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


    protected static User getThreadUser(){ return threadUser.get(); }
}
