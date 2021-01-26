package com.datasouce.leetcode.onehundreddown;

/**
 * @author yeyulin 2021-01-26
 *         搜索插入位置 35
 */
public class ThirtyFive {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

}
