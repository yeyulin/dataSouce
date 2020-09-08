package com.datasouce.leetcode.onehundred;

/**
 * @author yeyulin 2020-09-08
 *         125 验证回文串
 */
public class OneHundredAndTwentyFive {

    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        char[] chars = s1.toCharArray();
        StringBuilder builder = new StringBuilder(chars.length);
        for (char c : chars) {
            boolean lowerCase = c >= 'a' && c <= 'z';
            boolean number = c >= '0' && c <= '9';
            if (lowerCase || number) {
                builder.append(c);
            }
        }
        int left = 0;
        int[] ints = builder.chars().toArray();
        int right = builder.length() - 1;
        while (left < right) {
            if (ints[left] != ints[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        OneHundredAndTwentyFive oneHundredAndTwentyFive = new OneHundredAndTwentyFive();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(oneHundredAndTwentyFive.isPalindrome(s));
    }

}
