package com.dataSouce.test;

import java.util.Arrays;

import com.dataSouce.heap.MaxHeap;
import com.dataSouce.sort.SelectSort;

public class HeapTest<T extends Comparable> {
	public  void heapSort(T arr[]){
		long start=System.currentTimeMillis();
	
		int length=arr.length;
		MaxHeap<T>maxHeap=new MaxHeap<T>(length);
		for(int i=0;i<length;i++) {
			maxHeap.insert(arr[i]);
		}
		for(int i=length-1;i>=0;i--) {
			arr[i]=maxHeap.pop();
		}

		long end=System.currentTimeMillis();
	
		System.out.println("heapSort:"+(end-start));
	}
	public void heapifySort(T arr[]) {
		long start=System.currentTimeMillis();
		
		MaxHeap<T>maxHeap=new MaxHeap<T>(arr);
		for(int i=arr.length-1;i>=0;i--) {
			arr[i]=maxHeap.pop();
		}
		long end=System.currentTimeMillis();
		
		System.out.println("heapifySort:"+(end-start));
	}
	public static void main(String[] args) {
		
		Integer[] arr  = SortTestHelper.generateRandomArrayInteger(1000_000, 0, 1000000);
		Integer[] copyOf = Arrays.copyOf(arr, arr.length);
		HeapTest<Integer> heapTest=new HeapTest<>();
		heapTest.heapSort(arr);
		heapTest.heapifySort(copyOf);
	}
}
