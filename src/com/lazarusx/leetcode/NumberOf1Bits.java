package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/3/21.
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }

    public static int hammingWeight(int n) {
        int weight = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                weight++;
            }
        }

        return weight;
    }
}
