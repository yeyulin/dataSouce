package com.datasouce.leetcode.threehundred;

import java.util.Arrays;

/**
 * @author yeyulin 2020-09-02
 *         344  反转字符串
 */
public class ThreeHundredAndFortyAndFour {

    public void reverseString(char[] s) {
        int length = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            if(i>length/2){
                return;
            }
            int index = length - i;
            char temp = s[i];
            s[i] = s[index];
            s[index] = temp;
        }
    }

    public static void main(String[] args) {
        // ['h','e','l','l','o']
        ThreeHundredAndFortyAndFour threeHundredAndFortyAndFour = new ThreeHundredAndFortyAndFour();
        char[]s=new char[]{'h','e','l','l','o'};
        threeHundredAndFortyAndFour.reverseString(s);
        System.out.println(Arrays.toString(s));
        //['H','a','n','n','a','h']
        char[]s1=new char[]{'H','a','n','n','a','h'};
        threeHundredAndFortyAndFour.reverseString(s1);
        System.out.println(Arrays.toString(s1));
    }

}
