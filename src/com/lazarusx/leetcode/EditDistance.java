package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/28.
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("a", "b"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }

        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int length1 = word1.length();
        int length2 = word2.length();
        int[][] distance = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j - 1], distance[i - 1][j]),
                            distance[i][j - 1]) + 1;
                }
            }
        }

        return distance[length1][length2];
    }
}
