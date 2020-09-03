package com.datasouce.leetcode.onehundred;

import java.util.Arrays;

/**
 * 189 旋转数组
 */
public class OneHundredAndEightyNine {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        for(int i=0;i<k;i++){
            int num = nums[length - 1];
            for(int j=length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=num;
        }
    }

    public static void main(String[] args) {
        OneHundredAndEightyNine oneHundredAndEightyNine=new OneHundredAndEightyNine();
        int[]nums=new int[]{1,2,3,4,5,6,7};
        oneHundredAndEightyNine.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
        int[]nums2=new int[]{-1,-100,3,99};
        oneHundredAndEightyNine.rotate(nums2,2);
        System.out.println(Arrays.toString(nums2));
    }
}
