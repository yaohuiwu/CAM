package org.cam.core.annotation;

import org.cam.core.action.annotation.Executable;
import org.cam.core.action.annotation.ExecutableType;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by yaohui on 14-9-24.
 */
public class BusinessLogic {

    @Executable
    public void doSomething(){
        System.out.println("do something.");
    }


    @Executable(ExecutableType.VIEW)
    public List<String> getDocumentList(String orgId){ return Collections.emptyList() ;}

    @Test
    public void testPrintEnum(){
        assertEquals("CREATE",ExecutableType.CREATE.toString());
    }



}
