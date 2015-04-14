package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;

        if (length <= 1) {
            return 0;
        }

        int profit = 0;
        for(int i = 0; i < length - 1; i++)
            if (prices[i+1]-prices[i] > 0)
                profit += prices[i+1] - prices[i];

        return profit;
    }
}
