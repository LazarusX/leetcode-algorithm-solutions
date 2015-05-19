package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/18.
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }

        int[][] nums = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            nums[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }

        return nums[s.length()][t.length()];
    }
}
