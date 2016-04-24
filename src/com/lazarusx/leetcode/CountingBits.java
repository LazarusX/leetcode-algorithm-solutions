package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 16/4/24.
 */
public class CountingBits {
    public static void main(String[] args) {
        Utility.printIntArray(countBits(0));
        Utility.printIntArray(countBits(1));
        Utility.printIntArray(countBits(5));
        Utility.printIntArray(countBits(8));
    }

    public static int[] countBits(int num) {
        if (num < 0) {
            return null;
        }

        int[] result = new int[num + 1];
        int nextPowerOfTwo = 1;

        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i == nextPowerOfTwo) {
                result[i] = 1;
                nextPowerOfTwo *= 2;
            } else {
                result[i] = result[nextPowerOfTwo / 2] + result[i - nextPowerOfTwo / 2];
            }
        }

        return result;
    }
}
