package org.cam.core.util;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class Nulls {

    public static <T> T safeGet(T object){
        return object!=null ? object : null;
    }
}
