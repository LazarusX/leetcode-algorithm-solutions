package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/3.
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(65536));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 31 - i);
        }

        return n;
    }

    public static int swapBits(int n, int i, int j) {
        int low = (n >> i) & 1;
        int high = (n >> j) & 1;

        if ((low ^ high) == 1) {
            n ^= ((1 << i) | (1 << j));
        }

        return n;
    }
}
