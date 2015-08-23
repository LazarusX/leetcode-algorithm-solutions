package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/23.
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(5));
        System.out.println(mySqrt(24));
        System.out.println(mySqrt(25));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sq = mid * mid;

            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}
