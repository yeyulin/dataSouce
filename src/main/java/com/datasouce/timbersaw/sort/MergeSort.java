package com.datasouce.timbersaw.sort;

import com.datasouce.test.SortTestHelper;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description: 含义：直接在原序列上直接归并排序，每次归并排序分别对左右两边进行归并排序，直至细分到两两分组
 * 平均时间复杂度：O(nlogn)
 * 最坏时间复杂度：O(nlogn)
 * 最优时间复杂度：O(nlogn)
 * 最坏空间复杂度：O(n)
 * @date 2020/7/27 9:08
 **/
public class MergeSort {
    public void sortTest(int arr[]) {
        SortTestHelper.prefix(arr);
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);

    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mind = left / 2 + right / 2;
        sort(arr, left, mind);
        sort(arr, mind + 1, right);
        if (arr[mind] > arr[mind + 1]) {
            merge(arr, left, mind, right);
        }
    }

    /**
     * 将 arr[left...mid]与arr[mid+1...rigth]归并排序
     *
     * @param arr
     * @param left
     * @param mind
     * @param right
     */
    private void merge(int[] arr, int left, int mind, int right) {
        int aux[] = Arrays.copyOfRange(arr, left, right + 1);
        int li = left;
        int ri = mind + 1;
        for (int i = left; i <= right; i++) {
            if (li > mind) {
                arr[i] = aux[ri - left];
                ri++;
            } else if (ri > right) {
                arr[i] = aux[li - left];
                li++;
            } else if (aux[li - left] > aux[ri - left]) {
                arr[i] = aux[ri - left];
                ri++;
            } else {
                arr[i] = aux[li - left];
                li++;
            }
        }
    }

    public void mergeSort2(int arr[]) {
        SortTestHelper.prefix(arr);
        mSort(arr, 0, arr.length - 1);
    }

    private void mSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left / 2 + right / 2;
        mSort(arr, left, mid);
        mSort(arr, mid + 1, right);
        if (arr[mid] > arr[mid + 1]) {
            mMerge(arr, left, mid, right);
        }
    }

    /**
     * arr[left...mid] arr[mid+1....right]
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void mMerge(int[] arr, int left, int mid, int right) {
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int li = left;
        int ri = mid + 1;
        for (int i = left; i <= right; i++) {
            if (li > mid) {
                arr[i] = aux[ri - left];
                ri++;
            } else if (ri > right) {
                arr[i] = aux[li - left];
                li++;
            } else if (aux[li - left] > aux[ri - left]) {
                arr[i] = aux[ri - left];
                ri++;
            } else {
                arr[i] = aux[li - left];
                li++;
            }
        }
    }

    public void mergeSort3(int arr[]) {
        SortTestHelper.prefix(arr);
        morge3(arr, 0, arr.length - 1);
    }

    private void morge3(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left / 2 + right / 2;
        morge3(arr, left, mid);
        morge3(arr, mid + 1, right);
        if (arr[mid] > arr[mid + 1]) {
            morge3(arr, left, mid, right);
        }

    }

    private void morge3(int[] arr, int left, int mid, int right) {
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);
        //这时有两个数组 一个是aux 一个是arr，aux是arr要排序截取的一部分，对该部分排序，赋值给arr
        //aux又mid分割为两个数组，aux[left...mid] aux[mid+1..right]
        //这两个数组进行排序，最后赋值到arr
        int li = left;
        int ri = mid + 1;

        for (int i = left; i <= right; i++) {
            //当存在左边完全大于右边时，右边数据已经被赋值，左边数据没有被赋值
            if (ri > right) {
                arr[i] = aux[li - left];
                li++;

            } else if (li > mid) {
                //当存右边完全大于左边时，左边数据已经被赋值，右边数据没有被赋值
                arr[i] = aux[ri - left];
                ri++;

            } else if (aux[li - left] > aux[ri - left]) {
                arr[i] = aux[ri - left];
                ri++;

            } else {
                arr[i] = aux[li - left];
                li++;

            }
        }
    }

    public void mergeSort4(int arr[]) {
        SortTestHelper.prefix(arr);
        mergeSort4(arr, 0, arr.length - 1);
    }

    private void mergeSort4(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left / 2 + right / 2;
        mergeSort4(arr, left, mid);
        mergeSort4(arr, mid + 1, right);
        if (arr[mid] > arr[mid + 1]) {
            mergeSort4(arr, left, mid, right);
        }
    }

    private void mergeSort4(int[] arr, int left, int mid, int right) {
        int[] aux = Arrays.copyOfRange(arr, left, right + 1);
        int li = left;
        int ri = mid + 1;
        for (int i = left; i <= right; i++) {
            if (li > mid) {
                arr[i] = aux[ri - left];
                ri++;
            } else if (ri > right) {
                arr[i] = aux[li - left];
                li++;
            } else if (aux[li - left] > aux[ri - left]) {
                arr[i] = aux[ri - left];
                ri++;
            } else {
                arr[i] = aux[li - left];
                li++;
            }
        }
    }

    public static void main(String[] args) {
       // int arr[] = SortTestHelper.generateRandomArray(1_000_000, 0, 10_000_000);
        MergeSort mergeSort = new MergeSort();
//        SortTestHelper.sortTest("归并", arr, mergeSort::sortTest);
//        int arr2[] = SortTestHelper.generateRandomArray(1_000_000, 0, 10_000_000);
//        SortTestHelper.sortTest("归并", arr2, mergeSort::mergeSort2);
        int arr3[] = SortTestHelper.generateRandomArray(1_000_000, 0, 10_000_000);
        SortTestHelper.sortTest("归并", arr3, mergeSort::mergeSort4);
        //System.out.println(Arrays.toString(arr));
    }

}
