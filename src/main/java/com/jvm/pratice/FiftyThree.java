package com.jvm.pratice;

/**
 * @author yeyulin 2020-09-21
 */
public class FiftyThree {
    // -XX:NewSize=100M -XX:MaxNewSize=100M -XX:InitialHeapSize=200M -XX:MaxHeapSize=200M
    //-XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC
    // -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc53.log
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;
        Thread.sleep(1000);
    }

}
