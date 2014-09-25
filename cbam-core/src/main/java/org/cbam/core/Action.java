package org.cbam.core;

import java.util.Arrays;

public class Action implements Executable{

    private final String name;
    private Object[] objects;

    public Action(String name, Object[] objects) {
        this.name = name;
        this.objects = objects;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object[] getObjects() {
        return this.objects;
    }

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }
}
