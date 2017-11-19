package com.dataSouce.BinarySearchTree;

import java.util.*;

public class RBTree <Key extends Comparable<Key>, Value>{
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private int size;
    private Node root;


    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(Node node) {
        return node != null && node.color;
    }

    //颜色转换
    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    //左旋
    private Node rotationLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //右旋
    private Node rotationRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //平衡操作
    private Node balance(Node node) {

        if (isRed(node.left) && isRed(node.right) && !isRed(node)) {
            if ((isRed(node.left.left) || isRed(node.left.right) || isRed(node.right.left) || isRed(node.right.right)))
                flipColors(node);
        }
        else {
            if (isRed(node.left)){
                if (isRed(node.left.right))
                    node.left = rotationLeft(node.left);
                if (isRed(node.left) && isRed(node.left.left))
                    node = rotationRight(node);
            }else if (isRed(node.right)){
                if (isRed(node.right) && isRed(node.right.left))
                    node.right = rotationRight(node.right);

                if (isRed(node.right) && isRed(node.right.right))
                    node = rotationLeft(node);
            }

            if (isRed(node.left) && isRed(node.right) && !isRed(node)) {
                if ((isRed(node.left.left) || isRed(node.left.right) || isRed(node.right.left) || isRed(node.right.right)))
                    flipColors(node);
            }
        }
        return node;
    }

    private Node max(Node node) {
        if(node == null) {
            return null;
        } else {
            while(node.right != null) {
                node = node.right;
            }

            return node;
        }
    }

    private Node min(Node node) {
        if(node == null) {
            return null;
        } else {
            while(node.left != null) {
                node = node.left;
            }

            return node;
        }
    }

    public Value max() {
        return root == null ? null : max(root).value;
    }

    public Value min() {
        return root == null ? null : min(root).value;
    }


    //插入
    public void put(Key key, Value value) {
        root = put(key, value, root);
        root.color = BLACK;
    }

    private Node put(Key key, Value value, Node node) {
        if(node == null) {
            ++size;
            return new Node(key, value, null, null, RED);
        } else {
            int cmp = key.compareTo(node.key);
            if(cmp < 0) {
                node.left = put(key, value, node.left);
            } else if (cmp > 0){
                node.right = put(key, value, node.right);
            }else{
                node.value = value;
            }

           return balance(node);
        }
    }

    public void deleteMin(){
        if (!isEmpty()){
            root.color = RED;

            root = deleteMin(root);
            --size;
            if (!isEmpty())
                root.color = BLACK;
        }
    }

    private Node deleteMin(Node node){
        if (node.left == null){
            return node.right;
        }

        if (!isRed(node.left)) {
            if(!isRed(node.left) && !isRed(node.right))
                flipColors(node);
            else
                node = rotationLeft(node);
        }

        node.left = deleteMin(node.left);

        return balance(node);

    }

    public void deleteMax(){
        if (!isEmpty()){
            root.color = RED;

            root = deleteMax(root);
            --size;
            if (!isEmpty())
                root.color = BLACK;
        }
    }

    private Node deleteMax(Node node){
        if (node.right == null){
            return node.left;
        }

        if (!isRed(node.right)) {
            if(!isRed(node.left) && !isRed(node.right))
                flipColors(node);
            else
                node = rotationRight(node);
        }

        node.right = deleteMax(node.right);

        return balance(node);

    }

    //删除
    public void delete(Key key){
        if (!isEmpty()){
            root.color = RED;

            root = delete(key, root);

            if (!isEmpty())
                root.color = BLACK;
        }
    }

    private Node delete(Key key, Node node){
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);

        if (cmp < 0){
            if (node.left != null && !isRed(node.left)) {
                if(!isRed(node.right))
                    flipColors(node);
                else
                    node = rotationLeft(node);
            }

            node.left = delete(key, node.left);
        }else if (cmp > 0){
            if (node.right != null && !isRed(node.right)) {
                if(!isRed(node.left))
                    flipColors(node);
                else
                    node = rotationRight(node);
            }

            node.right = delete(key, node.right);
        }else {
            --size;
            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            Node x = min(node.right);
            node.key = x.key;
            node.value = x.value;

            node.right = deleteMin(node.right);
        }

        return balance(node);
    }



    //判断树是否为一棵红黑树
    public boolean isRBTree() {
        return isRBTree(root);
    }

    public boolean isRBTree(Node node) {
        if(node == null) {
            return true;
        } else if(node.color == RED) {
            return false;
        } else {
            Node x = node;
            int count = 0;

            for(; x != null; x = x.left) {
                if(x.color == BLACK) {
                    ++count;
                }
            }

            return isRBTree(node, count, 0);
        }
    }

    private boolean isRBTree(Node node, int count, int k) {
        if(node == null) {
            return count == k;
        } else if((isRed(node.left) && isRed(node.left.left))
                ||(isRed(node.left) && isRed(node.left.right))
                ||(isRed(node.right) && isRed(node.right.right))
                ||(isRed(node.right) && isRed(node.right.left))) {
            return false;
        } else {
            if(node.color == BLACK) {
                ++k;
            }
            return node.left == null && node.right == null ? k == count:isRBTree(node.left, count, k) && isRBTree(node.right, count, k);
        }
    }

    //树的中序遍历
    public void inTraverse(){
        inTraverse(root);
    }

    private void inTraverse(Node node){
        if (node == null)
            return;
        inTraverse(node.left);
        System.out.print(node.key + " ");
        inTraverse(node.right);
    }

    //测试
    public static void main(String[] args) {
        int n = 10;
        int a;
        Random random = new Random();
        RBTree<Integer, String> rbt = new RBTree<Integer, String>();

        for (int i = 1; i <= n; ++i) {
            a = random.nextInt(10);
            System.out.println("a:"+a);
            rbt.put(a, "naoko");
        }

       /* for (int i = 0; i < 5; ++i) {
            rbt.delete(i);
        }*/

        if (!rbt.isRBTree()) {
            System.out.println("不是红黑树");
            return;
        }

        rbt.inTraverse();

        System.out.println("是红黑树");
    }

}
