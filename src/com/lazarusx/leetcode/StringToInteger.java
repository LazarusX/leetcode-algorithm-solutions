package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/27.
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }

        boolean isNegative = false;
        boolean foundSymbol = false;
        int number = 0;
        for (;i < str.length(); i++) {
            char c = str.charAt(i);
            int digit = c - '0';
            if (digit >= 0 && digit < 10) {
                if (isNegative) {
                    if (number > Integer.MAX_VALUE / 10 || Integer.MIN_VALUE + number * 10 + digit >= 0) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (number > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE - number * 10 - digit <= 0) {
                        return Integer.MAX_VALUE;
                    }
                }
                number *= 10;
                number += digit;
            } else {
                if (foundSymbol) {
                    break;
                } else {
                    if (c == '-') {
                        foundSymbol = true;
                        isNegative = true;
                    } else if (c == '+') {
                        foundSymbol = true;
                    } else {
                        break;
                    }
                }
            }
        }

        if (isNegative) {
            number *= -1;
        }

        return number;
    }
}
