package com.datasouce.BinarySearchTree;

public class BinarySearch<T extends Comparable> {
	//非递归二分查找算法
	public static  int find(Comparable[]arr,Comparable target) {
		//在arr[l...r]查找target
		int l=0;
		int r=arr.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(arr[mid].compareTo(target)==0) {
				return mid;
			}
			
			if(arr[mid].compareTo(target)>0) {
				//在arr[l...mid-1]查找target
				r=mid-1;
			}else {
				//在arr[mid+1...r]查找target
				l=mid+1;
			}
		}
		return -1;
	}
	//递归二分查找算法
	public static int recursionFind(Comparable[]arr,int left,int right,Comparable target) {
		int l=left;
		int r=right-1;
		if(l>r) {
			return -1;
		}
		int mid=l+(r-l)/2;
		if(arr[mid].compareTo(target)==0) {
			return mid;
		}
		else if(arr[mid].compareTo(target)>0) {
			return recursionFind(arr,l,mid, target);
		}
		else{
			return	recursionFind(arr,mid+1,r+1, target);
		}
	}
	public static void main(String[] args) {
		int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++) {
            arr[i] = new Integer(i);
        }
        int find = BinarySearch.find(arr, 10);
        int find2 = BinarySearch.find(arr, 1000001);
        System.out.println(find);
        System.out.println(find2);
        int recursionFind = recursionFind(arr, 0, 1000000, 10);
        int recursionFind2 = recursionFind(arr, 0, 1000000, 1000001);
        System.out.println(recursionFind);
        System.out.println(recursionFind2);
	}
}
