package com.datasouce.leetcode.onehundreddown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yeyulin 2020-11-11
 *         49 字母异位词分组
 */
public class FortyNine {

    public List<List<String>> groupAnagrams(String[] strs) {
        String[] strings = Arrays.copyOf(strs, strs.length + 1);
        List<List<String>> result = new ArrayList<>();
        if (strs == null) {
            return result;
        }
        int length = strs.length;
        if (length <= 1) {
            result.add(Collections.singletonList(strs[0]));
            return result;
        }
        Map<Integer, String> tempMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            tempMap.put(i, strs[i]);
        }
        for (int i = 0; i < length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            strs[i] = s;
        }
        Map<Integer, String> tempDisMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i + 1; j < length; j++) {
                if (strs[i].equals(strs[j])) {
                    String s = tempMap.get(i);
                    String s1 = tempMap.get(j);
                    if (Objects.isNull(tempDisMap.get(i))) {
                        tempDisMap.put(i, s);
                        list.add(s);
                    }

                    if (Objects.isNull(tempDisMap.get(j))) {
                        tempDisMap.put(j, s1);
                        list.add(s1);
                    }

                }
            }
            if (!list.isEmpty()) {
                result.add(list);
            }

        }
        for (int i = 0; i < strings.length; i++) {
            if (!Objects.equals(tempDisMap.get(i),strings[i])) {
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                result.add(list);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FortyNine fortyNine = new FortyNine();
        String[] nums = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = fortyNine.groupAnagrams(nums);
        System.out.println(lists);
        String[] num1 = new String[]{"", ""};
        System.out.println(fortyNine.groupAnagrams(num1));
    }

}
