package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }

        return maxProfit;
    }
}
