package org.cam.core;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by wuyaohui on 14-9-27.
 */
public class ObjectUtilsTest {

    @Test
    public void testGetterField() throws Exception {

        assertEquals("name",ObjectUtils.getterField("getName"));
        assertEquals("isAlive",ObjectUtils.getterField("isAlive"));
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
}
