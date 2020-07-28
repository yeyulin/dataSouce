package com.datasouce.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;


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
		 public Node(Node node){
	            this.k = node.k;
	            this.v = node.v;
	            this.left = node.left;
	            this.right = node.right;
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
		@Override
		public String toString() {
			return "Node [k=" + k + ", v=" + v + ", left=" + left + ", right=" + right + "]";
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
   //前序遍历
    public void perOrder() {
    	perOrder(root);
    }
    //中序遍历
    public void inOrder() {
    	inOrder(root);
    }
    //后续遍历
    public void pastOrder() {
    	pastOrder(root);
    }
    //层级遍历 
    public void levelOrder() {
    	levelOrder(root);
    }
    //获取最小值
    public K minimum() {
    	Node node=	minimum(root);
    	return node.getK();
    }
    //获取最大值
    public K maximum() {
    	Node node=	maximum(root);
    	return node	.getK();
    }
  //删除最小值
	public void removeMin() {
		if(root!=null) {
			root=removeMin(root);
		}
	}
	//删除最大值
	public void removeMax() {
		if(root!=null) {
			root=removeMax(root);
		}
	}
	//删除任意值
	public void remove(K key) {
		root=remove(root,key);
	}
	
	//********************
    //* 二分搜索树的辅助函数
    //********************
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
    //前序遍历 以node为根的二叉搜索树深度(前序遍历)
    private void perOrder(Node node) {
    	if(node!=null) {
    		System.out.println(node.getK()+"----->"+node.getV());
    		perOrder(node.getLeft());
    		perOrder(node.getRight());
    	}
    }
    //以node为根的二叉搜索树深度(中序遍历) 数据是从小到大 排序打印
    private void inOrder(Node node) {
    	if(node!=null) {
    		inOrder(node.getLeft());
    		System.out.println(node.getK()+"----->"+node.getV());
    		inOrder(node.getRight());
    	}
    }
  //以node为根的二叉搜索树深度(后序遍历 )数据是从小到大 排序打印
    private void pastOrder(Node node) {
    	if(node!=null) {
    		pastOrder(node.getLeft());
    		pastOrder(node.getRight());
    		System.out.println(node.getK()+"----->"+node.getV());
    	}
    }
  //以node为根的二叉搜索树 广度(层序遍历)
    private void levelOrder(Node node) {
    	Queue<Node>q=new ArrayDeque<Node>();
    	q.add(node);
		while(!q.isEmpty()) {
			Node n=q.poll();
			System.out.println(n.getK()+"---------->"+n.getV());
			if(n.getLeft()!=null) {
				q.add(n.getLeft());
			}
			if(n.getRight()!=null) {
				q.add(n.getRight());
			}
		}
    }
    private Node minimum(Node node) {
    	while(node!=null) {
    		if(node.getLeft()!=null) {
    			node=node.getLeft();
    		}else{
    			return node;
    		}
    	}
		return null;
	}
    private Node maximum(Node node) {
    	if(node.getRight()==null) {
    		return node;
    	}
    		return maximum(node.getRight());
	}
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
    /*	if( node.left == null ){

            Node rightNode = node.right;
            node.right = null;
            count --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;*/
		if(node.getLeft()==null) {
			Node rightNode=node.getRight();
			node.setRight(null);
			count--;
			return rightNode;
		}
		//把删除后的节点的子节点移到删除节点的位置
		node.setLeft(removeMin(node.getLeft()));
		return node;
	}
    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
	private Node removeMax(Node node) {
		/* if( node.right == null ){

	            Node leftNode = node.left;
	            node.left = null;
	            count --;
	            return leftNode;
	        }

	        node.right = removeMax(node.right);
	        return node;*/
		Node parent=null;
		Node preNode=node;
		while(node!=null) {
			if(node.getRight()==null) {
				parent=node.getLeft();
				node.setLeft(null);
				count--;
				break;
			}else {
				preNode=node;
				node=preNode.getRight();
			}
		}
		preNode.setRight(parent);
		/*while(node.getRight()!=null) {
			Node childNode=node.getRight();
			if(childNode.getRight()==null) {
				Node leftNode=childNode.getLeft();
				childNode.setLeft(null);
				node.setRight(leftNode);
				count--;
				return node;
			}else {
				node=node.getRight();
			}
		}
		*/
		return preNode;
	}
	  // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
	private Node remove(Node node, K key) {
		if(node==null) {
			return null;
		}
		if(key.compareTo(node.getK())<0) {
			//将删除后的结果放到新的二分搜索树的根的左节点
			node.setLeft(remove(node.getLeft(), key));
			return node;
		}
		else if(key.compareTo(node.getK())>0) {
			node.setRight(remove(node.getRight(), key));
			return node;
		}
		else {
			 // 待删除节点左子树为空的情况
			if(node.getLeft()==null) {
				Node rightNode=node.getRight();
				node.setRight(null);
				count--;
				return rightNode;
			}
			   // 待删除节点右子树为空的情况
			if(node.getRight()==null) {
				Node leftNode=node.getLeft();
				node.setLeft(null);
				count--;
				return leftNode;
			}
			 // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
			//要删除节点的后继节点	 替代要删除的节点1
			Node successNode=new Node(minimum(node.getRight()));
			count++;
			//removeMin删除最小值节点 返回的是下一个最小值节点的根
			successNode.setRight(removeMin(node.getRight()));
			successNode.setLeft(node.getLeft());
			node.setRight(null);
			node.setLeft(null);
			count--;
			return successNode;
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

