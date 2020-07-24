package com.dataSouce.timbersaw.sort;

import com.dataSouce.test.SortTestHelper;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description: 就像打牌时整理牌，小的插到左边，大的插到右边
 * @date 2020/7/24 13:33
 * 算法特点：最坏情况下时间复杂度O(N^2)
 * 依赖于初始排列顺序，特别适合于部分有序的数组，完全有序的情况下
 * 复杂度能达到O(N),但是逆序时效率降到O(N^2)
 **/
public class InsertSort {
    public static void sortTest(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //从后往前来进行插入排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(1000000, 0, 10_000_000);
        SortTestHelper.sortTest("插入", arr, SelectSort::sortTest);
        //System.out.println(Arrays.toString(arr));
    }
}
