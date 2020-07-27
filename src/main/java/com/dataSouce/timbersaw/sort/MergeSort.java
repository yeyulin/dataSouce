package com.dataSouce.timbersaw.sort;

import com.dataSouce.test.SortTestHelper;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description:
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
        int li=left;
        int ri=mid+1;
        for (int i = left; i <=right ; i++) {
            if(li>mid){
                arr[i]=aux[ri-left];
                ri++;
            }else if(ri>right){
                arr[i]=aux[li-left];
                li++;
            }
            else if(aux[li-left]>aux[ri-left]){
                arr[i]=aux[ri-left];
                ri++;
            }else{
                arr[i]=aux[li-left];
                li++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = SortTestHelper.generateRandomArray(10_000_000, 0, 10_000_000);
        MergeSort mergeSort = new MergeSort();
        SortTestHelper.sortTest("归并", arr, mergeSort::sortTest);
        int arr1[] = SortTestHelper.generateRandomArray(10_000_000, 0, 10_000_000);
        SortTestHelper.sortTest("归并", arr1, mergeSort::mergeSort2);
        //System.out.println(Arrays.toString(arr));
    }

}
