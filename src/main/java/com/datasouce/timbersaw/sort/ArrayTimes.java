package com.datasouce.timbersaw.sort;

/**
 * @author yeyulin
 * @description: 11  有序数组元素出现的次数
 * @date 2020/7/31 18:17
 **/
public class ArrayTimes {
    public int sortTimes(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (target < arr[middle]) {
                high = middle;
            } else if (target > arr[middle]) {
                low = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }
    public int sortTimes2(int[]arr,int num){
        int result=0;
        if(arr==null || arr.length==0){
            return result;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayTimes arrayTimes = new ArrayTimes();
        int[] ints = {1, 222, 222, 222, 2345, 7891, 7891, 6666};
        int f = arrayTimes.sortTimes(ints, 222 );
        System.out.println(f);
        System.out.println(arrayTimes.sortTimes2(ints,222));
    }
}
