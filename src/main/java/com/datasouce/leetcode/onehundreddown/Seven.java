package com.datasouce.leetcode.onehundreddown;

/**
 * @author yeyulin 2020-09-03
 *         7 整数反转
 */
public class Seven {

    public int reverse(int x) {
        if (x > 0) {
            return reverse(String.valueOf(x));
        }
        int i = x * -1;
        int reverse = reverse(String.valueOf(i));
        return 0 - reverse;
    }

    private int reverse(String s) {
        StringBuilder builder = new StringBuilder(s);
        try {
            return Integer.parseInt(builder.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    public static void main(String[] args) {
        Seven seven = new Seven();
        System.out.println(seven.reverse(123));
        System.out.println(seven.reverse(-123));
        System.out.println(seven.reverse(1534236469));

    }

}
