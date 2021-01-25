package com.datasouce.leetcode.sevenhundred;

/**
 * @author yeyulin 2021-01-25
 *         seven hundred and twenty-four
 *         724  寻找数组的中心索引
 */
public class SevenHundredAndTwentyFour {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
        SevenHundredAndTwentyFour sevenHundredAndTwentyFour = new SevenHundredAndTwentyFour();
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(sevenHundredAndTwentyFour.pivotIndex(nums));
        int[] nums2 = new int[]{-1, -1, -1, -1, -1, -1};
        System.out.println(sevenHundredAndTwentyFour.pivotIndex(nums2));
    }

}
