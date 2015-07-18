package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/12.
 */
public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(isScramble("rgtae", "great"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        int length = s1.length();
        int[] A = new int[26];
        for (int i = 0; i < length; i++) {
            A[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < length; i++) {
            A[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (A[i] != 0)
                return false;
        }

        boolean[][][] flags = new boolean[length][length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                flags[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 1; k < length; k++) {
            for (int i = 0; i < length - k; i++) {
                for (int j = 0; j < length - k; j++) {
                    boolean result = false;
                    for (int l = 0; l < k && !result; l++) {
                        result = (flags[l][i][j] && flags[k - l - 1][i + l + 1][j + l + 1])
                                || (flags[l][i][j + k - l] && flags[k - l - 1][i + l + 1][j]);
                    }
                    flags[k][i][j] = result;
                }
            }
        }

        return flags[length - 1][0][0];
    }
}
