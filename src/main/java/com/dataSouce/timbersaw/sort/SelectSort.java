package com.dataSouce.timbersaw.sort;

import com.dataSouce.test.SortTestHelper;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description:
 * @date 2020/7/24 9:14
 **/
public class SelectSort {
    public static void sortTest(int arr[]) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
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
