package com.datasouce.leetcode.onehundreddown;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yeyulin 2020-11-12
 *         3 无重复字符的最长子串
 */
public class Three {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        int max = 0;
        for (int i = 0; i < length; i++) {
            int temp = 0;
            Set<Character> disSet = new HashSet<>();
            for (int j = i; j < length; j++) {
                char charAt = s.charAt(j);
                if (disSet.contains(charAt)) {
                    break;
                }
                disSet.add(charAt);
                temp++;
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(three.lengthOfLongestSubstring("bbbbb"));
        System.out.println(three.lengthOfLongestSubstring("pwwkew"));
    }

}
