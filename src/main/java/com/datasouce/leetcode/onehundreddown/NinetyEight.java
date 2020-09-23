package com.datasouce.leetcode.onehundreddown;

import com.datasouce.leetcode.TreeNode;

/**
 * @author yeyulin 2020-09-23
 *         98 验证二叉搜索树
 */
public class NinetyEight {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if(root.val<=pre){
            return false;
        }
        //中序遍历
        pre=root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        NinetyEight ninetyEight=new NinetyEight();
        TreeNode node=new TreeNode(1);
        TreeNode node1=new TreeNode(1);
        node.left=node1;
        boolean validBST = ninetyEight.isValidBST(node);
        System.out.println(validBST);
    }

}
