package com.datasouce.timbersaw.tree;

/**
 * @author yeyulin
 * @description:
 * @date 2020/8/10 10:05
 **/
public class TreeNode<E> {
    E val;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(E x) {
        this.val = x;
    }
}
