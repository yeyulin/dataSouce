package com.datasouce.sort;

import java.util.Arrays;

import com.datasouce.test.SortTestHelper;

public class BubbleSort {
	public static void bubbleSort(int arr[]) {
		int length=arr.length;
		boolean flag=true;
		for(int i=0;i<length-1;i++) {
			flag=true;
			for(int j=0;j<length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					SortTestHelper.swap(arr, j, j+1);
					flag=false;
				}
			}
			if(flag) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(10, 0, 10);
		System.out.println(Arrays.toString(arr));
		SortTestHelper.sortTest("冒泡", arr, BubbleSort::bubbleSort);
		System.out.println(Arrays.toString(arr));
	}
}
