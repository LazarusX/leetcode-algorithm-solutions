package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/3/25.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "11"));
    }

    public static String addBinary(String a, String b) {
        if (a == null || b == null)
            return  null;

        int iA = a.length() - 1;
        int iB = b.length() - 1;
        int carry = 0;
        String sum = "";

        while (iA >= 0 && iB >= 0) {
            int intA = a.charAt(iA) - '0';
            int intB = b.charAt(iB) - '0';

            int s = intA + intB + carry;
            sum = s % 2 + sum;
            carry = s / 2;

            iA--;
            iB--;
        }

        while (iA >= 0) {
            int s = a.charAt(iA) - '0' + carry;
            sum = s % 2 + sum;
            carry = s / 2;
            iA--;
        }

        while (iB >= 0) {
            int s = b.charAt(iB) - '0' + carry;
            sum = s % 2 + sum;
            carry = s / 2;
            iB--;
        }

        if (carry > 0)
            sum = carry + sum;

        return sum;
    }
}
