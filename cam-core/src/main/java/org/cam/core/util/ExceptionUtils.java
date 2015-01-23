package org.cam.core.util;

/**
 * 异常工具类
 */
public class ExceptionUtils {

    /**
     *  强制将未检查的Throwable转换为RuntimeException.
     * @param t
     * @return
     */
    public static RuntimeException launderThrowable(Throwable t){
        if(t instanceof RuntimeException)
            return (RuntimeException) t;
        else if(t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("Not unchecked", t);
    }
}
