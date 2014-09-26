package org.cam.core;

import org.slf4j.Logger;

/**
 * Created by wuyaohui on 14-9-25.
 */
public class Logs {

    public static void traceIfEnabled(Logger logger,String message,Object... objects){
        if(logger.isTraceEnabled()){
            logger.trace(message,objects);
        }
    }

    public static void debugIfEnabled(Logger logger,String message,Object... objects){
        if(logger.isDebugEnabled()){
            logger.debug(message,objects);
        }
    }

    public static void warnIfEnabled(Logger logger,String message,Object... objects){
        if(logger.isWarnEnabled()){
            logger.warn(message,objects);
        }
    }
}
