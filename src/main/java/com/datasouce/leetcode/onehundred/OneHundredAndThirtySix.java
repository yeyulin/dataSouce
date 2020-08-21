package com.datasouce.leetcode.onehundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yeyulin
 * @description: 136 只出现一次的数字
 * @date 2020/8/21 17:45
 **/
public class OneHundredAndThirtySix {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int value=0;
        int next=1;
        for (int num : nums) {
            Integer integer = map.get(num);
            if(Objects.isNull(integer)){
                map.put(num,value);
                continue;
            }
            map.put(num,next);
        }
        for (int num : nums) {
            Integer integer = map.get(num);
            if(integer==0){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        OneHundredAndThirtySix oneHundredAndThirtySix=new OneHundredAndThirtySix();
        int[]nums=new int[]{2,2,1};
        int i = oneHundredAndThirtySix.singleNumber(nums);
        System.out.println(i);
    }
}
