package com.dataSouce.sort;

import java.util.Arrays;

import com.dataSouce.test.SortTestHelper;

public class MergeSort {
	public static void mergeSort(int arr[]) {
		int length=arr.length;
		sort(arr,0,length-1);
	}
	//对arr[left....rigth]前闭后闭
	private static void sort(int[] arr, int left, int right) {
		if(right-left<=15) {
			insertSort(arr,left,right);
			return;
		}
		int mid=right/2+left/2;
		sort(arr,left,mid);
		sort(arr,mid+1,right);
		if(arr[mid]>arr[mid+1]) {
			merge(arr,left,mid,right);
		}
	}
	private static void insertSort(int[] arr, int left, int right) {
		//因为是前闭后闭 arr[left...right] 所以是i<=right
		for(int i=left+1;i<=right;i++) {
			int j=i;
			int temp=arr[j];
			for(;j>left && temp<arr[j-1];j--) {
				arr[j]=arr[j-1];
			}
			arr[j]=temp;
		}
	}
	private static void merge(int[] arr, int left, int mid, int right) {
		//因为arr[left....rigth]前闭后闭 所以right需要加1
		int aux[]  = Arrays.copyOfRange(arr, left,right+1);
		//将 arr[left...mid]与arr[mid+1...rigth]归并排序;
		int li=left;//代表第左数组的开始位置
		int ri=mid+1;//代表右数组的开始位置
		for(int i=left;i<=right;i++) {
			if(li>mid) {
				arr[i]=aux[ri-left];
				ri++;
			}else if(ri>right) {
				arr[i]=aux[li-left];
				li++;
			}else if(aux[li-left]>aux[ri-left]) {
				arr[i]=aux[ri-left];
				ri++;
			}else {
				arr[i]=aux[li-left];
				li++;
			}
		}
	}
	public static void main(String[] args) {
		int arr[]  = SortTestHelper.generateRandomArray(10, 0, 10);
		System.out.println(Arrays.toString(arr));
		SortTestHelper.sortTest("", arr, MergeSort::mergeSort);
		System.out.println(Arrays.toString(arr));
	}
}	
