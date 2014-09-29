package org.cam.core;

import org.cam.core.dao.CamDao;
import org.cam.core.domain.User;

/**
 * Created by wuyaohui on 14-9-26.
 */
public interface CamFactory {

    public FlowHandler getFlowHandler();

    public User getCurrentUser();

//    public CoreDAO getCoreDao();
//    public CamDao getCamDao();
    public CamService getService();
}
