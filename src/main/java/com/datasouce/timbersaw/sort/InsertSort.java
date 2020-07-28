package com.datasouce.timbersaw.sort;

import com.datasouce.test.SortTestHelper;

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
                    SortTestHelper.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void insertSort2(int arr[]) {
        SortTestHelper.prefix(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j >0; j--) {
                if(arr[j-1]>arr[j]){
                    SortTestHelper.swap(arr,j-1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(10_000, 0, 10_000_000);
        SortTestHelper.sortTest("插入", arr, InsertSort::sortTest);
        int arr2[] = SortTestHelper.generateRandomArray(10_000, 0, 10_000_000);
        SortTestHelper.sortTest("插入", arr2, InsertSort::insertSort2);
        //System.out.println(Arrays.toString(arr));
    }
}
