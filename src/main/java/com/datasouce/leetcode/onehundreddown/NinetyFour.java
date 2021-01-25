package com.datasouce.leetcode.onehundreddown;

import java.util.ArrayList;
import java.util.List;
import com.datasouce.leetcode.TreeNode;

/**
 * @author yeyulin 2020-12-02
 *         中序遍历
 */
public class NinetyFour {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);

    }

}
