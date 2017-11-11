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
		public K getK() {
			return k;
		}
		public void setK(K k) {
			this.k = k;
		}
		public V getV() {
			return v;
		}
		public void setV(V v) {
			this.v = v;
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
	public void insertRecursion(K k,V v) {
		//递归插入
		root=insertRecursion(root,k,v);
	}
	//向以node为根的二分搜索树中,插入节点(k,v)使用递归算法,返回插入新节点后的二分搜索树的根
	private Node insertRecursion(Node root, K k, V v) {
		if(root==null) {
			count++;
			return new Node(k, v);
		}
		if(root.getK().compareTo(k)==0) {
			root.setV(v);
		}else if(k.compareTo(root.getK())>0) {
			root.setRight(insertRecursion(root.getRight(), k, v));
		}else {
			root.setLeft(insertRecursion(root.getLeft(), k, v));
		}
		return root;
	}
	public void insertLoop(K k,V v) {
		if(root==null) {
			root=new Node(k, v);
			count++;
			return;
		}
		Node parent=null;//最后一个节点
		Node node=root;
		int cmp=0;
		//当node为null parent为最后一个节点时退出循环 或更新节点值时退出方法
		while(node!=null) {
			parent=node;
			cmp=k.compareTo(node.getK());
			if(cmp>0) {
				//把右节点赋值为当前节点
				node=node.getRight();
			}else if(cmp<0) {
				//把左节点赋值为当前节点
				node=node.getLeft();
			}else {
				//更新当前节点值
				node.setV(v);
				return;
			}
		}
		if(k.compareTo(parent.getK())>0) {
			parent.setRight(new Node(k, v));
		}else {
			parent.setLeft(new Node(k, v));
		}
		count++;
	}
	 // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public V search(K key){
        return search( root , key );
    }
	  // 在以node为根的二分搜索树中查找key所对应的value
    // 若value不存在, 则返回NULL
    private V search(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.getK()) == 0 ) {
            return node.getV();
        }
        else if( key.compareTo(node.getK()) < 0 ) {
            return search( node.getLeft() , key );
        }
        else { // key > node->key{
            return search( node.getRight(), key );
        }
    }
    //前序遍历 以node为根的二叉搜索树前序遍历
    public void perOrder(Node node) {
    	if(node!=null) {
    		System.out.println(node.getK()+"----->"+node.getV());
    		perOrder(node.getLeft());
    		perOrder(node.getRight());
    	}
    }
    //以node为根的二叉搜索树中序遍历 数据是从小到大 排序打印
    public void inOrder(Node node) {
    	if(node!=null) {
    		perOrder(node.getLeft());
    		System.out.println(node.getK()+"----->"+node.getV());
    		perOrder(node.getRight());
    	}
    }
  //以node为根的二叉搜索树后序遍历 数据是从小到大 排序打印
    public void pastOrder(Node node) {
    	if(node!=null) {
    		perOrder(node.getLeft());
    		perOrder(node.getRight());
    		System.out.println(node.getK()+"----->"+node.getV());
    	}
    }
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}

