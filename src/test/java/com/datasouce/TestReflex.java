package com.datasouce;

import java.lang.reflect.Method;

/**
 * @author yeyulin
 * @description:
 * @date 2020/8/11 9:14
 **/
public class TestReflex {
    public static void target(int i) {

        System.out.println("i"+"---");
        if(i==19){
            new Exception("#" + i).printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 20; i++) {
            Class klass = Class.forName("com.datasouce.TestReflex");

            Method method = klass.getMethod("target", int.class);
            method.invoke(null, i);
        }

    }
}
