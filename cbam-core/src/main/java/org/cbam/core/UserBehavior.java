package org.cbam.core;

/**
 * Created by wuyaohui on 14-9-24.
 */
public class UserBehavior {

    /**
     * Id of user.
     */
    private String userId;

    private Executable executable;

    public UserBehavior() {
    }

    public UserBehavior(String userId, Executable executable) {
        this.userId = userId;
        this.executable = executable;
    }

    public String getUserId() {
        return userId;
    }

    public Executable getExecutable() {
        return executable;
    }
}
