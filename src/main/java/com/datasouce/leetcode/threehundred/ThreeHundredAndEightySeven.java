package com.datasouce.leetcode.threehundred;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yeyulin 2020-09-04
 *         387 字符串中的第一个唯一字符
 */
public class ThreeHundredAndEightySeven {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        ThreeHundredAndEightySeven threeHundredAndEightySeven = new ThreeHundredAndEightySeven();
//        s = "leetcode"
//        返回 0
//
//        s = "loveleetcode"
//        返回 2
        int leetcode = threeHundredAndEightySeven.firstUniqChar("leetcode");
        System.out.println(leetcode);
        int leetcode1 = threeHundredAndEightySeven.firstUniqChar("loveleetcode");
        System.out.println(leetcode1);
    }

}
