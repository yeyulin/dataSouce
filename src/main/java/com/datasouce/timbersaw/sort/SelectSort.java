package com.datasouce.timbersaw.sort;

import com.datasouce.test.SortTestHelper;

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


    public static void selectSort2(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SortTestHelper.swap(arr, i, j);
                }
            }
        }
    }

    public void selectSort3(int arr[]){
        int length=arr.length;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(10_000, 0, 100000);
        SortTestHelper.sortTest("选择", arr, SelectSort::sortTest);
        int arr2[] = SortTestHelper.generateRandomArray(10_000, 0, 100000);
        SortTestHelper.sortTest("选择", arr2, SelectSort::selectSort2);
        int arr3[] = SortTestHelper.generateRandomArray(10_000, 0, 100000);
        SelectSort selectSort=new SelectSort();
        SortTestHelper.sortTest("选择", arr3, selectSort::selectSort3);
        //System.out.println(Arrays.toString(arr));
    }
}
