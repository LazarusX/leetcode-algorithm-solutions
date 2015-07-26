package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/26.
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int[][] status = new int[matrix.length][matrix[0].length];

        if (matrix[0][0] == '1') {
            status[0][0] = 1;
            max = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                status[i][0] = 1;
                max = 1;
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1') {
                status[0][j] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    status[i][j] = Math.min(status[i - 1][j - 1],
                            Math.min(status[i - 1][j], status[i][j - 1])) + 1;

                    if (status[i][j] > max) {
                        max = status[i][j];
                    }
                }
            }
        }

        return max * max;
    }
}
