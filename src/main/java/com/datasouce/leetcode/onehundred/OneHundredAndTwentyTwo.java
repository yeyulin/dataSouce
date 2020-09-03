package com.datasouce.leetcode.onehundred;

/**
 * 122 买卖股票的最佳时机 II
 */
public class OneHundredAndTwentyTwo {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            int i1 = prices[i + 1] - prices[i];
            if (i1 > 0) {
                result += i1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OneHundredAndTwentyTwo oneHundredAndTwentyTwo = new OneHundredAndTwentyTwo();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int maxProfit = oneHundredAndTwentyTwo.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
