package com.datasouce.leetcode;

import java.util.Arrays;

/**
 * @author yeyulin
 * @description: 66 加一
 * @date 2020/8/24 17:42
 **/
public class SixtyAndSix {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        SixtyAndSix sixtyAndSix = new SixtyAndSix();
        int[] digits = new int[]{1,2,3};
        int[] ints = sixtyAndSix.plusOne(digits);
        System.out.println(Arrays.toString(ints));

        int[] digits1 = new int[]{4,3,2,1};
        int[] ints1 = sixtyAndSix.plusOne(digits1);
        System.out.println(Arrays.toString(ints1));
    }
}
