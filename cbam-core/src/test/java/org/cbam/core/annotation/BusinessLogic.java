package org.cbam.core.annotation;

/**
 * Created by yaohui on 14-9-24.
 */
public class BusinessLogic {

    @Executable(value = {}, type = "edit")
    public void doSomething(){
        System.out.println("do something.");
    }
}
