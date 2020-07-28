package com.datasouce.sort;

import java.util.Arrays;

import com.datasouce.test.SortTestHelper;

public class ShellSort {
	public static void shellSort(int arr[]){
		int length=arr.length;
		for(int grap=length/2;grap>0;grap= (grap==2?1:(int)(grap/2.2))) {
			for(int i=grap;i<length;i++) {
				int j=i;
				int temp=arr[j];
				for(;j>=grap && temp<arr[j-grap];j-=grap) {
					arr[j]=arr[j-grap];
				}
				arr[j]=temp;
			}
		}
	}
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(10, 0, 10);
		SortTestHelper.sortTest("希尔", arr, ShellSort::shellSort);
		System.out.println(Arrays.toString(arr));
	}
}
