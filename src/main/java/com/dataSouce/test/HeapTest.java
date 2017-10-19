package com.dataSouce.test;

import java.util.Arrays;

import com.dataSouce.heap.MaxHeap;
import com.dataSouce.sort.SelectSort;

public class HeapTest<T extends Comparable> {
	/**
	 * 原地heap排序 不开辟额外的空间
	 * 索引从0开始
	 * parent(i)=(i-1)/2
	 * left child (i)=2*i+1
	 * right child (i)=2*i+2
	 * */
	public void heapSortNoOtherRoom(T arr[]) {
		long start=System.currentTimeMillis();
		int length=arr.length;
		//进行heapify 生成最大堆
		//从(最后一个元素的索引-1)/2开始
	    // 最后一个元素的索引 = n-1
		for(int i=(length-1-1)/2;i>=0;i--) {
			shiftDown(arr,length,i);
		}
		//交换最大堆的首尾 排序
		for(int i=length-1;i>0;i--) {
			swapHeap(arr, i, 0);
			//交换后继续维持最大堆,i代表要维持最大堆的元素个数
			shiftDown(arr, i, 0);
		}
		long end=System.currentTimeMillis();
		System.out.println("heapSortNoOtherRoom:"+(end-start));
	}
	private void shiftDown(T[] arr,int length, int i) {
		while(2*i+1<length) {
			int j=2*i+1;
			if(j+1<length && arr[j+1].compareTo(arr[j])>0) {
				j++;
			}
			if(arr[i].compareTo(arr[j])>0) {
				break;
			}
			swapHeap(arr, i, j);
			i=j;
		}
	}
	/**
	 * 优化shiftDown
	 * **/
	private void shiftDown2(T[] arr,int length, int i) {
		T e=arr[i];
		while(2*i+1<length) {
			int j=2*i+1;
			if(j+1<length && arr[j+1].compareTo(arr[j])>0) {
				j++;
			}
			if(e.compareTo(arr[j])>0) {
				break;
			}
			arr[i]=arr[j];
			//swapHeap(arr, i, j);
			i=j;
		}
		arr[i]=e;
	}
	  public static boolean isSorted(Comparable[] arr){

	        for( int i = 0 ; i < arr.length - 1 ; i ++ )
	            if( arr[i].compareTo(arr[i+1]) > 0 )
	                return false;
	        return true;
	    }
	 // 交换堆中索引为i和j的两个元素
    private void swapHeap(T arr[],int i, int j){
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
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
		
		Integer[] arr  = SortTestHelper.generateRandomArrayInteger(1000_000, 0, 1000_000);
		Integer[] copyOf = Arrays.copyOf(arr, arr.length);
		Integer[] copyOf2 = Arrays.copyOf(arr, arr.length);
		HeapTest<Integer> heapTest=new HeapTest<>();
		
		heapTest.heapSort(arr);
		assert isSorted(arr);
		heapTest.heapifySort(copyOf);
		assert isSorted(copyOf);
		heapTest.heapSortNoOtherRoom(copyOf2);
		assert isSorted(copyOf2);
	}
}
