package com.datasouce.leetcode.onehundreddown;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author yeyulin 2020-09-10
 *         28 实现 strStr()
 */
public class TwentyEight {

    public int strStr(String haystack, String needle) {

        if (needle.equals("")) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        char[] chars = needle.toCharArray();
        int charsLength = chars.length - 1;
        char[] charArray = haystack.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charArray[i] != chars[0]) {
                continue;
            }
            if (i + charsLength > length) {
                return -1;
            }
            int j = i;
            boolean falg = true;
            for (int i1 = 1; i1 < chars.length; i1++) {
                j++;
                if (j >= length) {
                    return -1;
                }
                if (charArray[j] != chars[i1]) {
                    falg = false;
                    break;
                }
            }
            if (falg) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TwentyEight twentyEight = new TwentyEight();
        System.out.println(twentyEight.strStr("hello", "ll"));
        System.out.println(twentyEight.strStr("aaaaa", "bba"));
        System.out.println(twentyEight.strStr("aaaaa", ""));
        System.out.println(twentyEight.strStr("aaa", "aaaa"));
        System.out.println(twentyEight.strStr("mississippi", "issip"));
        System.out.println(twentyEight.strStr("mississippi", "sippia"));

        LocalDate date=LocalDate.of(2020,9,10);
        LocalDate date1=LocalDate.of(2020,11,28);
        long l = date1.toEpochDay() - date.toEpochDay();
        System.out.println(l);
        System.out.println(l*12);
        BigDecimal bigDecimal=new BigDecimal(12);
        BigDecimal bigDecimal1=new BigDecimal(12);
        System.out.println(bigDecimal.subtract(bigDecimal1).toString());
        System.out.println(bigDecimal.multiply(bigDecimal1).toString());
    }

}
