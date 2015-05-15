package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/15.
 */
public class BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(0, 2147483647));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }

        return m & n;
    }
}
