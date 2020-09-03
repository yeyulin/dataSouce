package com.datasouce.leetcode.twohundred;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * @author yeyulin
 * @description: 283 移动0
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @date 2020/8/25 17:43
 **/
public class TwoHundredAndEightyThree {
    public void moveZeroes(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]==0){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;

                }
            }

        }
    }

    public static void main(String[] args) {
        TwoHundredAndEightyThree twoHundredAndEightyThree=new TwoHundredAndEightyThree();
        int[]nums=new int[]{0,1,0,3,12};
        twoHundredAndEightyThree.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
