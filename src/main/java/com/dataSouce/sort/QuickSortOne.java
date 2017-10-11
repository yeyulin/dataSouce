package com.dataSouce.sort;


import com.dataSouce.test.SortTestHelper;

public class QuickSortOne {
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
	//arr[l...p-1]<arr[p] arr[p+1...r]>arr[p];
	private static int partition(int[] arr, int l, int r) {
		//解决在近乎有序的情况下排序慢的问题
		SortTestHelper.swap(arr,l,(int)(Math.random()*(r-l+1))+l );
		int temp=arr[l];
		/*arr[l+1...j]<temp arr[j+1....i)>temp  i是下一个要判断的元素 所以是前闭后开
		 * 使得初始数组都为空
		 * */
		int j=l;
		for(int i=l+1;i<=r;i++) {
			if(arr[i]<temp) {
				j++;
				SortTestHelper.swap(arr, i, j);
				
			}
		}
		SortTestHelper.swap(arr,j,l);
		return j;
	}
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(1000_00, 0, 10);
		int[] coptIntArray = SortTestHelper.coptIntArray(arr);
		int arr2[] =SortTestHelper.generateNearRandomArray(1000_000, 0);
		//System.out.println(Arrays.toString(arr));
		SortTestHelper.sortTest("", coptIntArray, MergeSort::mergeSort);
		SortTestHelper.sortTest("快速排序一", arr, QuickSortOne::quickSort);
		//System.out.println(Arrays.toString(arr));
	}
}
