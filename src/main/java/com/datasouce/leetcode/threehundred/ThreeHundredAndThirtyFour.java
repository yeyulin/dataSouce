package com.datasouce.leetcode.threehundred;

/**
 * @author yeyulin 2020-11-18
 */
public class ThreeHundredAndThirtyFour {

    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int big = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= big) {
                big = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeHundredAndThirtyFour threeHundredAndThirtyFour = new ThreeHundredAndThirtyFour();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(threeHundredAndThirtyFour.increasingTriplet(nums));
        System.out.println(threeHundredAndThirtyFour.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));

    }

}
