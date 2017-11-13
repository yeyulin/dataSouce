package com.dataSouce.test;

import java.util.Arrays;

import com.dataSouce.BinarySearchTree.BinarySearchTreeBasics;


public class BSTTest {
	public static void main(String[] args) {
		  int N = 10;

	        // 创建一个数组，包含[0...N)的所有元素
	        Integer[] arr = new Integer[N];
	        for(int i = 0 ; i < N ; i ++)
	            arr[i] = new Integer(i);

	        // 打乱数组顺序
	        for(int i = 0 ; i < N ; i ++){
	            int pos = (int) (Math.random() * (i+1));
	            Integer t = arr[pos];
	            arr[pos] = arr[i];
	            arr[i] = t;
	        }
	      System.out.println(Arrays.toString(arr));
	      
	        // 将这个N个数插入到二叉树中
	        BinarySearchTreeBasics<Integer, String> bst = new BinarySearchTreeBasics<Integer, String>();
	        for(Integer num: arr) {
	            bst.insertRecursion(num, num.toString());
	        }
	        
	       System.out.println( bst.search(2)+"----");
	       
	        
	       
	        BinarySearchTreeBasics<Integer, String> bst2 = new BinarySearchTreeBasics<Integer, String>();
	        for(Integer num: arr)
	            bst2.insertLoop(num, num.toString());
	        
	        System.out.println( bst2.search(2)+"----");
	        
	}
}
