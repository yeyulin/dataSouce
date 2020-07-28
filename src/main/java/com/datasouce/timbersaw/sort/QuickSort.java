package com.datasouce.timbersaw.sort;

import com.datasouce.test.SortTestHelper;

/**
 * @author yeyulin
 * @description:
 * @date 2020/7/27 16:06
 **/
public class QuickSort {
    public void sortTest(int arr[]) {
        SortTestHelper.prefix(arr);
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        int patition = partition(arr, left, right);
        sort(arr, left, patition - 1);
        sort(arr, patition + 1, right);
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        //该patition要在 left---right 之间
        int partition = (right - left) / 2 + left;
        SortTestHelper.swap(arr, left, partition);
        //选择左边第一个
        int temp = arr[left];
        //初始化
        int li = left;
        //arr[li+1....partition-1]<arr[partition]  arr[partition+1....right]>arr[partition]

        //从第二个开始循环
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < temp) {
                li++;
                SortTestHelper.swap(arr, i, li);
            }
        }
        // SortTestHelper.swap(arr, li, left);
        SortTestHelper.swap(arr, left, li);
        return li;
    }

    public void quickSort2(int arr[]) {
        SortTestHelper.prefix(arr);
        quickSort2(arr, 0, arr.length - 1);
    }

    private void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //选择合适的数值 p
        int p = partition2(arr, left, right);
        quickSort2(arr, left, p-1);
        quickSort2(arr, p + 1, right);
    }

    private int partition2(int[] arr, int left, int right) {
        //SortTestHelper.swap(arr, left, (right - left) / 2 + left);
        //比较的值
        int temp = arr[left];
        //选择合适的数值
        int li = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < temp) {
                //表明右边有比选择的值小
                li++;
                SortTestHelper.swap(arr, i, li);
            }
        }
        //运行到这里表面 下标再li之前的值都是比temp小
        //又因为arr[li]<arr[left],需要交换下标
        SortTestHelper.swap(arr, left, li);
        return li;
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(8905, 0, 10_000_000);
        QuickSort quickSort = new QuickSort();
        SortTestHelper.sortTest("", arr, quickSort::sortTest);
        int arr2[] = SortTestHelper.generateRandomArray(100_000, 0, 10_000_000);
        SortTestHelper.sortTest("", arr, quickSort::quickSort2);

        int[] arr1 = new int[20];
        int l = 10;
        int r = arr1.length - 1;
        int i = (int) (Math.random() * ((r - l + 1)) + l);
        int ii = (r - l) / 2 + l;
        System.out.println(ii);
        System.out.println(i);
        System.out.println(arr1[i]);
    }
}
