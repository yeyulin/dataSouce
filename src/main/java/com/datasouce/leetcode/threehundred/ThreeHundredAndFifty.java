package com.datasouce.leetcode.threehundred;

import java.util.*;

/**
 * 350 两个数组的交集 II
 */
public class ThreeHundredAndFifty {
    public int[] intersect(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        Map<Integer, Integer> temps = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if (num1Length < num2Length) {
            for (int i = 0; i < num1Length; i++) {
                boolean flag=true;
                for (int j = 0; j < num2Length && flag; j++) {
                    if (nums1[i] == nums2[j]) {
                        Integer integer = temps.get(j);
                        if (Objects.isNull(integer)) {
                            result.add(nums1[i]);
                            temps.put(j, j);
                            flag=false;
                        }


                    }
                }
            }
            return toInts(result);
        }
        for (int i = 0; i < num2Length; i++) {
            boolean flag=true;
            for (int j = 0; j < num1Length && flag; j++) {
                if (nums2[i] == nums1[j]) {
                    Integer integer = temps.get(j);
                    if (Objects.isNull(integer)) {
                        result.add(nums2[i]);
                        temps.put(j, j);
                        flag=false;
                    }


                }
            }
        }
        return toInts(result);
    }
    private int[]toInts(List<Integer>lists){
        int []result=new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            result[i]=lists.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeHundredAndFifty threeHundredAndFifty = new ThreeHundredAndFifty();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = threeHundredAndFifty.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
        int[] nums3 = new int[]{4,9,5};
        int[] nums4 = new int[]{9,4,9,8,4};
        int[] intersect2 = threeHundredAndFifty.intersect(nums3, nums4);
        System.out.println(Arrays.toString(intersect2));
    }
}
