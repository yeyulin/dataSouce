package com.datasouce;

/**
 * @author yeyulin
 * @description:
 * -verbose:gc -Xms10m -Xmx10m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:MaxGCPauseMillis=200m
 * https://zhuanlan.zhihu.com/p/131643439
 * @date 2020/8/4 9:39
 *
 **/
public class TestJC {
    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;
        byte[] arr1 = new byte[size];
        createOneM();
        System.out.println("createOneM------------");
        byte[] arr2 = new byte[size];
        System.out.println("22------------");
        byte[] arr3 = new byte[size];
        System.out.println("33------------");
        createOneM();
        System.out.println("createOneM2------------");
        Thread.sleep(20000);
        byte[] arr5 = new byte[size];
        System.out.println("5555------------");
    }

    public static void createOneM() {
        byte[] arr = new byte[1024 * 1024];
    }

}
