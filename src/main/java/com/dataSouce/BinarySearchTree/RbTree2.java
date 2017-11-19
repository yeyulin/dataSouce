package com.dataSouce.BinarySearchTree;

public class RbTree2 <K extends Comparable<K>,V>{
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private int size;
	private Node root;
	public boolean isEmpty() {
		return size==0;
	}
	//判断当前节点是不是红色节点
	private boolean isRead(Node node) {
		return node!=null && node.getColor();
	}
	//互相转换 红的变黑，黑的变红
	private void flipColors(Node node) {
		node.setColor(!node.getColor());
		node.getLeft().setColor(!node.getLeft().getColor());
		node.getRight().setColor(!node.getRight().getColor());
	}
	//左旋 将node的右节点成为node的父节点(parent),之前parent的左节点成为node的右节点，同时parent的左节点是node
	private Node totationLeft(Node node) {
		Node x=node.getRight();
		node.right=x.left;
		x.left=node;
		x.color=node.color;
		node.color=RED;
		return x;
	}
	//右旋 将node的左节点成为node的父节点(parent),之前parent的右节点成为node的左节点,同时parent的右节点是node
	private Node rotationRight(Node node) {
		Node x=node.getLeft();
		node.left=x.right;
		x.right=node;
		x.color=node.color;
		node.color=RED;
		return x;
	}
	private Node balance(Node node) {
		if() {}
		return node;
	}
	private class Node{
		K key;
		V value;
		Node left;
		Node right;
		boolean color;
		public Node(K key, V value, Node left, Node right, boolean color) {
			super();
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.color = color;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public boolean getColor() {
			return color;
		}
		public void setColor(boolean color) {
			this.color = color;
		}
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
}
