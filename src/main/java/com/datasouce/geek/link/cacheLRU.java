package com.datasouce.geek.link;

import java.util.Arrays;

/**
 *
 */
public class cacheLRU {
    private static int[] data=null;
    private int size;
    private int count=0;
    public cacheLRU(int length){
        data=new int[length];
        size=length;
        count=0;
    }
    public void put(int value){
        int length = data.length;
        if(count==length){
            moveNumber(count-1);
            data[0]=value;
            return;
        }
        data[count++]=value;
    }
    public Integer getValue(int index){
        assert index>0 && index<=count;
        int datum = data[index];
        moveNumber(index);
        return datum;
    }
    private void moveNumber(int length){
        int temp=data[length];
        for(int i=length;i>0;i--){
           data[i]= data[i-1];
        }
        data[0]=temp;
    }

    public static void main(String[] args) {
        cacheLRU cacheLRU=new cacheLRU(4);
        cacheLRU.put(1);
        cacheLRU.put(2);
        cacheLRU.put(3);
        cacheLRU.put(4);
        cacheLRU.put(5);
        System.out.println(Arrays.toString(data));
        Integer value = cacheLRU.getValue(2);
        System.out.println(value);
        System.out.println(Arrays.toString(data));
//        cacheLRU.put(6);
//        System.out.println(Arrays.toString(data));
//        cacheLRU.put(7);
//        System.out.println(Arrays.toString(data));
//        int[] ints = SortTestHelper.generateRandomArray(5, 0, 100);
//        data=ints;
//        cacheLRU cacheLRU=new cacheLRU(5);
//        System.out.println(Arrays.toString(data));
//
//        cacheLRU.move();
//        System.out.println(Arrays.toString(data));
    }
}
