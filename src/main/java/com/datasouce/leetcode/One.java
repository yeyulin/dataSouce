package com.datasouce.leetcode;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description: 两数之和 1
 * @date 2020/8/26 18:05
 **/
public class One {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        One one=new One();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = one.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
