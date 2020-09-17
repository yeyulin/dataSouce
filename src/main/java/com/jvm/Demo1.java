package com.jvm;

/**
 * @author yeyulin 2020-09-17
 */
public class Demo1 {

  //新生代大小 5M -XX:NewSize=5242880 -XX:MaxNewSize=5242880 比例 -XX:SurvivorRatio=8 也就是 eden:4M su1:0.5M su2:0.5M
  //初始化堆10M -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760
    //
  //   大对象10M -XX:PretenureSizeThreshold=10485760
  // -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
  // -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc1.log
    public static void main(String[] args) {
        byte[] array1 = new byte[1024 * 1024];
        byte[] array2= new byte[1024 * 1024];
        array1=new byte[1024 * 1024];
        array1=null;
        byte[] array3 = new byte[2*1024 * 1024];
    }

}
