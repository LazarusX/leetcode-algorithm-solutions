package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/20.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"striig", "strii", "strang"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j;
            for (j = 0; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }

            if (j == 0) {
                return "";
            } else {
                prefix = prefix.substring(0, j);
            }
        }

        return prefix;
    }
}
