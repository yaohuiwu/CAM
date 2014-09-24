package org.cbam.core;

import com.google.common.base.Preconditions;
import org.cbam.core.meta.domain.User;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class UserBehavior {

    /**
     * Id of user.
     */
    private User user;

    private Executable executable;

    public UserBehavior(User user, Executable executable) {
        Preconditions.checkArgument(user!=null && executable!=null
                ,"Arguments user and executable must not be null.");
        this.user = user;
        this.executable = executable;
    }

//    public User getUser() {
//        return user;
//    }

    public String getUserId(){
        return user.getId();
    }

    public Executable getExecutable() {
        return executable;
    }

    public boolean isNoDataExecuted(){
        Object[] objects = executable.getObjects();
        return objects == null || objects.length == 0;
    }

    @Override
    public String toString() {
        return "UserBehavior{" +
                "user=" + user +
                ", executable=" + executable +
                '}';
    }
}
