package com.datasouce.leetcode.onehundreddown;

/**
 * @author yeyulin 2020-11-16
 *         5 最长回文子串
 */
public class Five {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String result = s.substring(0, 1);

        // 从头开始找回文
        for (int i = 0; i < s.length() ; i++) {
            // 尝试检查每一组
            for (int j = i + 1; j < s.length(); j++) {
                // 当前组长度是否大于以及找到的，并且还是回文
                if (j + 1 - i > result.length() && isValidPalindrome(s, i, j)) {
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;

    }

    /**
     * 简单验证是否为回文
     *
     * @param s 字符串
     * @param i 开始位置
     * @param j 结束位置
     */
    private boolean isValidPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.longestPalindrome("babad"));
        five.longestPalindrome("bb");
        System.out.println(five.longestPalindrome("ac"));
        System.out.println(five.longestPalindrome("ccc"));
    }

}
