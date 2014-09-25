package org.cbam.core;

import java.lang.reflect.Method;

/**
 * All method including business logic and other ORM framework will go here.
 *
 */
public interface FlowHandler {

    public Object handleFlow(Invokable invokable);
}
