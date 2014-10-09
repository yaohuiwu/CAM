package org.cam.core.action.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Executable {

    /**
     * Value of executable name.
     *
     * @return
     */
    public ExecutableType value() default ExecutableType.VIEW;

    /**
     * Object types which target method will operate on. It's not necessary.
     * @return
     */
    public String[] objectTypes() default {};


}
