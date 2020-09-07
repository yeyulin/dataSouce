package com.datasouce.leetcode.twohundred;

import java.util.Arrays;

/**
 * @author yeyulin 2020-09-07
 *         242  有效的字母异位词
 */
public class TwoHundredAndFortyTwo {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    public static void main(String[] args) {
        TwoHundredAndFortyTwo twoHundredAndFortyTwo = new TwoHundredAndFortyTwo();
        String s = "abcq", t = "qbca";
        System.out.println(twoHundredAndFortyTwo.isAnagram(s, t));
    }

}
