package com.datasouce.leetcode;

/**
 * @author yeyulin
 * @description: 865 具有所有最深结点的最小子树
 * @date 2020/8/14 14:33
 **/
public class EightHundredAndSixtyFive {
    /**
     * 最深叶节点的最近公共祖先
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int left = deep(root.left);
        int right = deep(root.right);
        if (left == right) {
            return root;
        }

        return left > right ? subtreeWithAllDeepest(root.left) : subtreeWithAllDeepest(root.right);
    }

    /**
     * 当前节点的深度
     *
     * @param root
     * @return
     */
    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        return left > right ? left + 1 : right + 1;
    }


}
