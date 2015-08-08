package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/30.
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] leftMaxes = new int[prices.length];
        int[] rightMaxes = new int[prices.length];
        
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            leftMaxes[i] = prices[i] - min > leftMaxes[i - 1]? prices[i] - min : leftMaxes[i - 1];

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            rightMaxes[i] = max - prices[i] > rightMaxes[i + 1]? max - prices[i] : rightMaxes[i + 1];

            if (prices[i] > max) {
                max = prices[i];
            }
        }

        max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (leftMaxes[i] + rightMaxes[i] > max) {
                max = leftMaxes[i] + rightMaxes[i];
            }
        }

        return max;
    }
}
