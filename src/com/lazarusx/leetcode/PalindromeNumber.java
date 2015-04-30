package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/30.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(5));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int highest = 1;
        while (x / highest >= 10) {
            highest *= 10;
        }

        while (highest > 1) {
            int right = x % 10;
            int left = x / highest;

            if (left != right) {
                return false;
            }

            x /= 10;
            x %= (highest / 10);
            highest /= 100;
        }

        return true;
    }
}
