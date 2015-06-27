package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/27.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("1a1"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i < s.length() && j >= 0) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            }
            i++;
            j--;
        }

        return true;
    }
}
