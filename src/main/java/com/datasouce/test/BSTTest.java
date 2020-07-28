package com.datasouce.test;

import java.util.Arrays;

import com.datasouce.BinarySearchTree.BinarySearchTreeBasics;


public class BSTTest {
	public static void main(String[] args) {
		  int N = 6;
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
	       System.out.println("----------前序遍历-----------");
	       bst.perOrder();
	       System.out.println("----------中序遍历-----------");
	       bst.inOrder();
	       System.out.println("----------后序遍历-----------");
	       bst.pastOrder();
	       System.out.println("----------层序遍历---------");
	       bst.levelOrder();
	    /*   int min= bst.minimum();
	       System.out.println("最小值"+min); 
	       int max= bst.maximum();
	       System.out.println("最大值"+max);
	       bst.remove(3);
	       bst.perOrder();*/
	        
	}
}
