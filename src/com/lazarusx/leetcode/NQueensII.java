package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/5.
 */
public class NQueensII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    public static int totalNQueens(int n) {
        int[] columns = new int[n];
        for (int i = 0; i < n; i++) {
            columns[i] = -1;
        }

        int[] solutionCount = new int[1];
        solveNQueensHelper(n, columns, 0, solutionCount);

        return solutionCount[0];
    }

    public static void solveNQueensHelper(int n, int[] columns,
                                          int row, int[] solutionCount) {
        if (row == n) {
            solutionCount[0]++;
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(columns, row, i)) {
                    columns[row] = i;
                    solveNQueensHelper(n, columns, row + 1, solutionCount);
                    columns[row] = -1;
                }
            }
        }
    }

    public static boolean isValid(int[] columns, int row, int column) {
        for (int i = 0; i < columns.length; i++) {
            Integer j = columns[i];
            if (i == row && j != -1) {
                return false;
            }

            if (j == column) {
                return false;
            }

            if (j != -1 && Math.abs(i - row) == Math.abs(j - column)) {
                return false;
            }
        }

        return true;
    }
}
