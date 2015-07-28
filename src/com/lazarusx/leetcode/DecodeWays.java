package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/28.
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("01"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("27"));
        System.out.println(numDecodings("123"));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int last = checkSubstring(s, 0, 1) ? 1 : 0;
        if (s.length() == 1) {
            return last;
        }

        int lastButOne = 1;
        int current= 0;
        for (int i = 1; i < s.length(); i++) {
            current = 0;

            if (last > 0 && checkSubstring(s, i, i + 1)) {
                current += last;
            }

            if (lastButOne > 0 && checkSubstring(s, i - 1, i + 1)) {
                current += lastButOne;
            }

            lastButOne = last;
            last = current;
        }

        return current;
    }

    public static boolean checkSubstring(String s, int beginIndex, int endIndex) {
        if (endIndex - beginIndex == 1) {
            int digit = s.charAt(beginIndex) - '0';
            return digit > 0 && digit < 10;
        } else {
            int number = Integer.parseInt(s.substring(beginIndex, endIndex));
            return  number >= 10 && number <= 26;
        }
    }
}
