package com.dataSouce.test;


import com.dataSouce.sort.InsertSort;
import com.dataSouce.sort.SelectSort;

public class SortTest {
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(100000, 0, 100000);
		int coptIntArray[]  = SortTestHelper.coptIntArray(arr);
		int coptIntArray2[]  = SortTestHelper.coptIntArray(arr);
		SortTestHelper.sortTest("选择", arr, SelectSort::selectSort);
		SortTestHelper.sortTest("插入", coptIntArray, InsertSort::insertSort);
		SortTestHelper.sortTest("插入2", coptIntArray2, InsertSort::insertSortOptimize);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(coptIntArray));
	}
}
