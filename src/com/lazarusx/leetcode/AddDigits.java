package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/19.
 */
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
