package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/25.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean shouldSetFirstRow = false;
        boolean shouldSetFirstColumn = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                shouldSetFirstRow = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                shouldSetFirstColumn = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        if (matrix.length > 0) {
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }

        if (matrix[0].length > 0) {
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (shouldSetFirstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (shouldSetFirstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
