package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/14.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int length = s.length();
        int number = 0;

        for (int i = length - 1; i >= 0; i--) {
            number += Math.pow(26, i) * (s.charAt(length - i - 1) - 'A' + 1) ;
        }

        return number;
    }
}
