package com.datasouce.leetcode;

/**
 * @author yeyulin
 * @description: 26 删除排序数组中的重复项
 * @date 2020/8/14 9:28
 **/
public class twentySix {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int number=0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[number]) {
                number++;
                nums[number]=nums[i];
            }
        }
        number++;
        return number;
    }
}
