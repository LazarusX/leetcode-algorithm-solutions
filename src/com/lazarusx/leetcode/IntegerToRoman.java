package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/8.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(2011));
    }

    public static String intToRoman(int num) {
        String symbols[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman = "";

        int i = 0;
        while (i < values.length) {
            while (num >= values[i]) {
                num -= values[i];
                roman += symbols[i];
            }
            i++;
        }

        return roman;
    }
}
