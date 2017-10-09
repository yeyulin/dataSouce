package com.dataSouce.sort;

import java.util.Arrays;

import com.dataSouce.test.SortTestHelper;

public class SelectSort {
	public static void selectSort(int arr[]) {
		int length=arr.length;
		for(int i=0;i<length;i++) {
			int minIndex=i;
			for(int j=i+1;j<length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex=j;
				}
			}
			SortTestHelper.swap(arr, i, minIndex);
		}
	}
	
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(10, 0, 10);
		SortTestHelper.sortTest("选择", arr, SelectSort::selectSort);
		System.out.println(Arrays.toString(arr));
	}
}
