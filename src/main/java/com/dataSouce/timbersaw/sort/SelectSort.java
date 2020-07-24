package com.dataSouce.timbersaw.sort;

import com.dataSouce.test.SortTestHelper;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description: 每次选择一个数，然后遍历其后的每一个数，和这个数比较
 * @date 2020/7/24 9:14
 **/
public class SelectSort {
    public static void sortTest(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //从前往后来进行选择
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SortTestHelper.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(100, 0, 1000);
        SortTestHelper.sortTest("选择", arr, SelectSort::sortTest);
        System.out.println(Arrays.toString(arr));
    }
}
