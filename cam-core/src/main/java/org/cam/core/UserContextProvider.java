package org.cam.core;

import org.cam.core.domain.User;

/**
 * A user contract between developer and CAM system.
 */
public interface UserContextProvider {

    /**
     * Allow CAM inner objects to access current user.
     *
     * @return
     */
    public User getCurrentUser();


    /**
     * Let provider provide CurrentUser.
     *
     * @param user
     */
    public void setCurrentUser(User user);
}
