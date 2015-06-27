package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/27.
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("abababaabab", "aabab"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        buildNext(needle, next);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && needle.charAt(j + 1) != haystack.charAt(i)) {
                j = next[j];
            }
            if (needle.charAt(j + 1) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - j;
            }
        }

        return -1;
    }

    public static void buildNext(String needle, int[] next) {
        next[0] = -1;
        for (int i = 1; i < needle.length(); i++) {
            int j = next[i - 1];
            while (j >= 0 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = next[j];
            }
            if (needle.charAt(j + 1) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
