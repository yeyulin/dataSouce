package com.dataSouce.BinarySearchTree;

/**
 *  二分搜索树
 *	由于K需要能够进行比较，所以需要extends Comparable<K>
 * **/
public class BinarySearchTreeBasics<K extends Comparable<K>,V> {
	class Node {
		private K k;
		private V v;
		private Node left;
		private Node right;
		public Node(K k, V v) {
			super();
			this.k = k;
			this.v = v;
			this.left = null;
			this.right = null;
		}
	}
	private Node root;//树的根节点
	private int count; // 树种的节点个数
	public BinarySearchTreeBasics() {
		root=null;
		count=0;
	}
	public boolean isEmpty() {
		return count==0;
	}
	public int size() {
		return count;
	}
	
}

