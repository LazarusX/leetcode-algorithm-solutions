package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/27.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {0};
        digits = plusOne(digits);
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int digit = digits[digits.length - 1] + 1;
        int carry = digit / 10;
        digits[digits.length - 1] = digit % 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            digit = digits[i] + carry;
            carry = digit / 10;
            digits[i] = digit % 10;
        }

        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }

            return newDigits;
        } else {
            return digits;
        }
    }
}
