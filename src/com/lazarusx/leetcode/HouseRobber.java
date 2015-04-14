package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] num = {2, 1, 1, 2};
        System.out.println(rob(num));
    }

    public static int rob(int[] num) {
        if (num.length < 1) {
            return 0;
        }

        int length = num.length;
        int[] amount = new int[length + 1];
        amount[0] = 0;
        amount[1] = num[0];
        for (int i = 2; i <= length ; i++) {
            amount[i] = Math.max(amount[i - 1], amount[i - 2] + num[i - 1]);
        }

        return amount[length];
    }
}
