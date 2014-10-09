package org.cam.core;

import com.google.common.base.Preconditions;
import org.cam.core.action.Executable;
import org.cam.core.domain.User;

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
                " executable=" + executable +
                '}';
    }

    public String getExecutableName(){
        return executable!=null ? executable.getName() : null;
    }

    public Object[] getExecutableArguments(){
        return executable!=null? executable.getObjects() : null;
    }
}
