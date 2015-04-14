package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 2; i <= n; i++) {
            counts[i] = counts[i - 1] + counts[i - 2];
        }

        return counts[n];
    }
}
