package com.datasouce.sort;

import java.util.Arrays;

import com.datasouce.test.SortTestHelper;

public class InsertSort {
	public static void insertSort(int arr[]) {
		int length=arr.length;
		for(int i=1;i<length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]){
					SortTestHelper.swap(arr, j-1, j);
				}else{
					break;
				}
				
			}
		}
	}
	public static void insertSort2(int arr[]) {
		int length=arr.length;
		for(int i=1;i<length;i++) {
			for(int j=i;j>0 && arr[j]<arr[j-1];j--) {
				SortTestHelper.swap(arr, j-1, j);
			}
		}
	}
	public static void insertSortOptimize(int arr[]) {
		int length=arr.length;
		for(int i=1;i<length;i++) {
			int temp=arr[i];
			int j=i;
			for(;j>0 ;j--) {
				if(temp<arr[j-1]){
					arr[j]=arr[j-1];
				}else{
					break;
				}
			}
			arr[j]=temp;
		}
	}
	public static void insertSortOptimize2(int arr[]) {
		int length=arr.length;
		for(int i=1;i<length;i++) {
			int temp=arr[i];
			int j=i;
			for(;j>0 && temp<arr[j-1];j--) {
				arr[j]=arr[j-1];
			}
			arr[j]=temp;
		}
	}
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(10, 0, 10);
		System.out.println(Arrays.toString(arr));
		SortTestHelper.sortTest("", arr, InsertSort::insertSortOptimize);
		System.out.println(Arrays.toString(arr));
	}
}
