package com.datasouce.leetcode.twohundred;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yeyulin
 * @description: 217 重复数组
 * @date 2020/8/17 9:36
 **/
public class TwoHundredAndSeventeen {
    Map<Integer,Integer>map=new HashMap<>();
    public boolean containsDuplicate(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            Integer value = map.get(nums[i]);
            if(value!=null){
                return true;
            }
            map.put(nums[i],nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        TwoHundredAndSeventeen twoHundredAndSeventeen=new TwoHundredAndSeventeen();
        int[]nums=new int[]{1,2,3,4,5,6,7,7};
        boolean b = twoHundredAndSeventeen.containsDuplicate(nums);
        System.out.println(b);
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(-7);
        //System.out.println(localDate.toString());
        String param="2020-07-12";
        LocalDate parse = LocalDate.parse(param, DateTimeFormatter.ISO_DATE);

        while (true){
            if(parse.isAfter(now)){
                break;
            }
            System.out.println(parse.toString());
            parse = parse.plusDays(1);

        }

    }
}
