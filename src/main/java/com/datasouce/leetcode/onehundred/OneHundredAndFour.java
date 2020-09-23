package com.datasouce.leetcode.onehundred;

import com.datasouce.leetcode.TreeNode;

/**
 * @author yeyulin 2020-09-22
 *         104
 */
public class OneHundredAndFour {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right ? left : right) + 1;
    }

}
