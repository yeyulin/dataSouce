package com.dataSouce.test;

public class SortTestHelper {
	public static int[] generateRandomArray(int length,int rangeL,int rangeR) {
		assert(rangeL<rangeR);
		int arr[]=new int[length];
		for(int i=0;i<length;i++) {
			arr[i]=(int) (Math.random()*(rangeR-rangeL+1)+rangeL);
		}
		return arr;
	}
	public static int[] swap(int arr[],int first,int second) {
		int i=arr[first];
		arr[first]=arr[second];
		arr[second]=i;
		return arr;
	}
	public static boolean isSort(int arr[]) {
		for(int i=0,length=arr.length;i<length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	public static void sortTest(String name,int arr[],SortIntefaceHelper helper) {
		long start=System.currentTimeMillis();
		helper.sortTest(arr);
		assert isSort(arr);
		long end=System.currentTimeMillis();
		System.out.println(name+":"+(end-start));
	}
}
