package com.datasouce.sort;

import com.datasouce.test.SortTestHelper;

public class QuickSortTwoWays {
	public static  void quickSort(int arr[]) {
		int length=arr.length;
		sort(arr,0,length-1);
	}

	private static void sort(int[] arr, int l, int r) {
		if(l>=r) {
			return;
		}
		int p=partition(arr,l,r);
		sort(arr,l,p-1);
		sort(arr,p+1,r);
	}

	private static int partition(int[] arr, int l, int r) {
		SortTestHelper.swap(arr,l,(int)(Math.random()*(r-l+1))+l );
		int temp=arr[l];
		//arr[l+1...i)<=temp arr(j...r]>=temp;
		int i=l+1; //保证初始数组为空 不存在
		int j=r;
		while(true) {
			while(i<=r &&arr[i]<temp) {
				i++;
			}
			while(j>=l+1 && arr[j]>temp) {
				j--;
			}
			if(i>j) {
				break;
			}
			SortTestHelper.swap(arr, i, j);
			i++;
			j--;
		}
		SortTestHelper.swap(arr, l, j);
		return j;
	}
	public static void main(String[] args) {
		int arr[] =SortTestHelper.generateRandomArray(1000_000_000, 0,10);
		int[] coptIntArray = SortTestHelper.coptIntArray(arr);
		//System.out.println(Arrays.toString(arr));
		SortTestHelper.sortTest("merge", coptIntArray, MergeSort::mergeSort);
		SortTestHelper.sortTest("quick", arr, QuickSortTwoWays::quickSort);
	}
}
