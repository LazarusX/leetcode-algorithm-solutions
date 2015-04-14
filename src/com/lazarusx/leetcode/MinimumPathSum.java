package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class MinimumPathSum {
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] minSums = new int[m][n];
        minSums[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    minSums[i][j] = minSums[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    minSums[i][j] = minSums[i - 1][j] + grid[i][j];
                } else {
                    minSums[i][j] = Math.min(minSums[i][j - 1], minSums[i - 1][j]) + grid[i][j];
                }
            }
        }

        return minSums[m - 1][n - 1];
    }
}
