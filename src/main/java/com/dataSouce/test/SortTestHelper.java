package com.dataSouce.test;

import java.util.Arrays;

/**
 * 排序帮助
 */
public class SortTestHelper {
    public static int[] generateRandomArray(int length, int rangeL, int rangeR) {
        assert (rangeL < rangeR);
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    public static Integer[] generateRandomArrayInteger(int length, int rangeL, int rangeR) {
        assert (rangeL < rangeR);
        Integer arr[] = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    public static int[] generateNearRandomArray(int length, int swapTimes) {
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * length);
            int b = (int) (Math.random() * length);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    public static int[] swap(int arr[], int first, int second) {
        int i = arr[first];
        arr[first] = arr[second];
        arr[second] = i;
        return arr;
    }

    public static boolean isSort(int arr[]) {
        for (int i = 0, length = arr.length; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] coptIntArray(int arr[]) {
        return Arrays.copyOfRange(arr, 0, arr.length);
    }

    public static void sortTest(String name, int arr[], SortIntefaceHelper helper) {
        long start = System.currentTimeMillis();
        helper.sortTest(arr);
        long end = System.currentTimeMillis();
        boolean sort = isSort(arr);
        assert sort;
        System.out.println(sort);
        System.out.println(name + ":" + (end - start));
    }
}
