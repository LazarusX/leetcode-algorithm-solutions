package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/22.
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 4;
        int[][] result = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        if (n  == 0) {
            return result;
        }

        int i = 0;
        int j = 0;
        result[0][0] = 1;

        int k = 2;
        while (k <= n * n) {
            while (j < n - 1 && result[i][j + 1] == 0) {
                result[i][++j] = k++;
            }
            while (i < n - 1 && result[i + 1][j] == 0) {
                result[++i][j] = k++;
            }
            while (j > 0 && result[i][j - 1] == 0) {
                result[i][--j] = k++;
            }
            while (i > 0 && result[i - 1][j] == 0) {
                result[--i][j] = k++;
            }
        }

        return result;
    }
}
