package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/8.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCMXCIX"));
    }

    public static int romanToInt(String s) {
        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = romanToInt(s.charAt(i));
            if (i + 1 < s.length() && romanToInt(s.charAt(i + 1)) > digit) {
                value -= digit;
            } else {
                value += digit;
            }
        }

        return value;
    }

    public static int romanToInt(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
