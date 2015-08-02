package com.lazarusx.leetcode;

import java.util.Arrays;

/**
 * Created by LazarusX on 15/8/2.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
