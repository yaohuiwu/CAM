package org.cam.core;

import org.cam.core.domain.User;

/**
 * A user contract between developer and CAM system.
 */
public interface UserContextProvider {

    public User getCurrentUser();
}
