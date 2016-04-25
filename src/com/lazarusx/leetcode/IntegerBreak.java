package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 16/4/25.
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(10));
        System.out.println(integerBreak(13));
    }

    public static int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }

        if (n <= 3) {
            return n - 1;
        }

        int[] maxes = new int[n - 1];
        maxes[0] = 2;
        maxes[1] = 3;
        maxes[2] = 4;

        for (int i = 5; i <= n ; i++) {
            maxes[i - 2] = Math.max(maxes[i - 4] * 2, maxes[i - 5] * 3);
        }

        return maxes[n - 2];
    }

    public static int integerBreak2(int n) {
        if (n < 2) {
            return 0;
        }

        if (n <= 3) {
            return n - 1;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) Math.pow(3, n / 3 - 1) * 4;
        } else {
            return (int) Math.pow(3, n / 3) * 2;
        }
    }
}
