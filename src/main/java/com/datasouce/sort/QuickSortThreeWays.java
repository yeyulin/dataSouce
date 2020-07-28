package com.datasouce.sort;

import com.datasouce.test.SortTestHelper;

public class QuickSortThreeWays {
	public static void quickSort(int arr[]) {
		int length=arr.length;
		sort(arr,0,length-1);
	}

	private static void sort(int[] arr, int l, int r) {
		if(l>=r) {
			return;
		}
		  // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
		SortTestHelper.swap(arr, l, (int)(Math.random()*(r-l+1)) + l );
		int v=arr[l];
		int lt=l; //arr[l+1...lt]<v
		int gt=r+1;//arr[gt....r]>v
		int i=l+1;//arr[lt+1....i)==v下标i的起始位置
		while(i<gt) {
			if(arr[i]<v) {
				SortTestHelper.swap(arr,i,lt+1);
				lt++;
				i++;
			}else if(arr[i]>v){
				SortTestHelper.swap(arr,i,gt-1);
				gt--;
			}else{
				i++;
			}
		}
		SortTestHelper.swap(arr,l,lt);
		sort(arr, l, lt-1);
		sort(arr, gt, r);
	}
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(1000_000_00, 0, 10);
		int[] coptIntArray = SortTestHelper.coptIntArray(arr);
		int arr2[] =SortTestHelper.generateNearRandomArray(1000_000, 0);
		//System.out.println(Arrays.toString(arr));
		SortTestHelper.sortTest("mergeSort", coptIntArray, MergeSort::mergeSort);
		SortTestHelper.sortTest("quickSort", arr, QuickSortThreeWays::quickSort);
		//System.out.println(Arrays.toString(arr));
	}
}
