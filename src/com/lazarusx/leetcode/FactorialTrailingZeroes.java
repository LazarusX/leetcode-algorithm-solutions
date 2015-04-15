package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/15.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }

    public static int trailingZeroes(int n) {
        long i = 5;
        int count = 0;
        while ((n / i) > 0) {
            count += (n / i);
            i *= 5;
        }

        return count;
    }
}
