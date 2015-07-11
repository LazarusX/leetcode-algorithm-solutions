package com.lazarusx.leetcode;

import java.util.ArrayList;

/**
 * Created by LazarusX on 15/6/24.
 */
public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(calculate("9/5+10+1-8-10-5+9-3-5-5+8+8-8-3"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int operand = 1;
        int mode = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + (s.charAt(j) - '0');
                    j++;
                }
                i = j - 1;
                if (mode == 0) {
                    operand *= num;
                } else {
                    operand /= num;
                }
            } else if (c == '+') {
                result += operand;
                operand = 1;
                mode = 0;
            } else if (c == '-') {
                result += operand;
                operand = -1;
                mode = 0;
            } else if (c == '*') {
                mode = 0;
            } else if (c == '/') {
                mode = 1;
            }
        }

        result += operand;

        return result;
    }
}
