package org.cam.core;

import org.cam.core.action.Invokable;

/**
 * All method including business logic and other ORM framework will go here.
 *
 */
public interface FlowHandler {

    public Object handleFlow(Invokable invokable) throws Throwable;
}
