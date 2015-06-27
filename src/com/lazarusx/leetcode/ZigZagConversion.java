package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/27.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }

        int unitLength = 2 * numRows - 2;
        int unitCount = (int)Math.ceil((double)s.length() / unitLength);
        int slopeLength = unitLength - numRows;

        String result = "";
        int m = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < unitCount; j++) {
                if (j * unitLength + i < s.length()) {
                    result += s.charAt(j * unitLength + i);
                }
                if (i != 0 && i != numRows - 1 && m < slopeLength) {
                    if ((j + 1) * unitLength - m - 1 < s.length()) {
                        result += s.charAt((j + 1) * unitLength - m - 1);
                    }
                }
            }
            if (i != 0 && i != numRows - 1) {
                m++;
            }
        }

        return result;
    }
}
