package com.datasouce.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yeyulin
 * @description:
 * @date 2020/7/28 9:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }



}
