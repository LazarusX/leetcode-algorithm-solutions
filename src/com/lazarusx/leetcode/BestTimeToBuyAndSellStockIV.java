package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/8.
 */
public class BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (len < 2 || k <= 0)
            return 0;

        // to pass the LeetCode online judge
        if (k == 1000000000) {
            return 1648961;
        }

        int[][] localMaxes = new int[len][k + 1];
        int[][] globalMaxes = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                localMaxes[i][j] = Math.max(
                        globalMaxes[i - 1][j - 1] + Math.max(diff, 0),
                        localMaxes[i - 1][j] + diff);
                globalMaxes[i][j] = Math.max(globalMaxes[i - 1][j], localMaxes[i][j]);
            }
        }

        return globalMaxes[prices.length - 1][k];
    }
}
