package org.cam.core;

import org.cam.core.meta.domain.User;

/**
 * Created by wuyaohui on 14-9-26.
 */
public interface CamFactory {

    public FlowHandler getFlowHandler();

    public User getCurrentUser();
}
