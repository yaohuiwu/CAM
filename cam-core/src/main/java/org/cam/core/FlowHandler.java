package org.cam.core;

/**
 * All method including business logic and other ORM framework will go here.
 *
 */
public interface FlowHandler {

    public Object handleFlow(Invokable invokable);
}