package org.cam.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by wuyaohui on 14-9-27.
 */
public class ObjectUtilsTest {

    @Test
    public void testGetterField() throws Exception {

        assertEquals("name",ObjectUtils.getterField("getName"));
        assertEquals("isAlive",ObjectUtils.getterField("isAlive"));
        assertEquals("123",new Integer(123).toString());
    }


    public class A{
        private String name;
        private boolean isAlive;
        private boolean eaten;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isAlive() {
            return isAlive;
        }

        public void setAlive(boolean isAlive) {
            this.isAlive = isAlive;
        }

        public boolean isEaten() {
            return eaten;
        }

        public void setEaten(boolean eaten) {
            this.eaten = eaten;
        }
    }

    public static void printlnList(List<?> list){
        if(list!=null){
            for(Object o : list){
                System.out.println(o.toString());
            }
        }else{
            System.out.println("list is null");
        }
    }
}
