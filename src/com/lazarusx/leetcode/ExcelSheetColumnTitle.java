package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/14.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        int quotient = n;
        int remainder;
        String title = "";

        do {
            n = quotient;
            quotient = n / 26;
            remainder = n % 26;
            if (remainder == 0) {
                quotient--;
                remainder = 26;
            }
            title = (char)('A' + remainder - 1) + title;
        } while (quotient > 0);

        return title;
    }
}
