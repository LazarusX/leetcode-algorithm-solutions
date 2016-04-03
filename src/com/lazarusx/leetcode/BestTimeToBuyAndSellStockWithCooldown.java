package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 16/3/19.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int lastCd = 0;
        int lastButOneCd = 0;
        int lastSold = prices[1] - prices[0];

        for (int i = 2; i < prices.length; i++) {
            int temp = lastCd;
            lastCd = Math.max(lastSold, lastCd);
            lastSold = prices[i] - prices[i - 1] + Math.max(lastSold, lastButOneCd);
            lastButOneCd = temp;
        }

        return Math.max(lastCd, lastSold);
    }
}
