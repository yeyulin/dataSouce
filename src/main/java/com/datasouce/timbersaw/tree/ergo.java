package com.datasouce.timbersaw.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yeyulin
 * @description: 遍历
 * @date 2020/8/10 10:07
 **/
public class ergo {
    //小到大中序
    public <E> List<E> preorderTraversal(TreeNode<E> root, List<E> result) {
        if (root == null) {
            return result;
        }
        preorderTraversal(root.left, result);
        result.add(root.val);
        preorderTraversal(root.right, result);
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Deque<Integer>re=new LinkedList<>();
        re.push(1);
        re.push(2);
        re.push(3);
        while (!re.isEmpty()){
            System.out.println(re.poll());
        }
        System.out.println(190*100);
    }

}
