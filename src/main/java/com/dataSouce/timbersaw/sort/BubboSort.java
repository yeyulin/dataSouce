package com.dataSouce.timbersaw.sort;

import com.dataSouce.test.SortTestHelper;

/**
 * @author yeyulin
 * @description: 冒泡 ，相邻值进行对比
 * @date 2020/7/24 15:56
 **/
public class BubboSort {
    public static void sortTest(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        boolean flag = true;

        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0 ; j < arr.length - i -1; j++) {
                if(arr[j]>arr[j+1]){
                    SortTestHelper.swap(arr,j,j+1);
                    flag=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(10_000, 0, 10_000_000);
        SortTestHelper.sortTest("冒泡", arr, BubboSort::sortTest);
        SortTestHelper.sortTest("冒泡", arr, BubboSort::sortTest);
        SortTestHelper.sortTest("选择", arr, SelectSort::sortTest);
        SortTestHelper.sortTest("插入", arr, InsertSort::sortTest);
        //System.out.println(Arrays.toString(arr));
    }
}
