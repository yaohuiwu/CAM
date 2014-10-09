package org.cam.core;

import java.util.List;

/**
 * Created by wuyaohui on 14-10-9.
 */
public class TestUtil {

    public static void printlnList(List<?> list){
        System.out.println("print list");
        if(list!=null){
            if(list.isEmpty()){
                System.out.println("empty list");
            }else{
                for(Object o : list){
                    System.out.println(o.toString());
                }
            }
        }else{
            System.out.println("list is null");
        }
    }
}
