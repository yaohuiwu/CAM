package org.cam.core.action;

/**
 * Represent a execution that will be executed by JVM , which is also a contract <br/>
 * between developer code and CBAM system. Similar to a Method.
 */
public interface Executable {

    public String getName();

    public Object[] getObjects();
}
