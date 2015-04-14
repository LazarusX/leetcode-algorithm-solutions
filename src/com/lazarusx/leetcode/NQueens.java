package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/5.
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<String[]> solveNQueens(int n) {
        ArrayList<String[]> solutions = new ArrayList<String[]>();
        ArrayList<int[]> solutionsInIntegers = new ArrayList<int[]>();

        int[] columns = new int[n];
        for (int i = 0; i < n; i++) {
            columns[i] = -1;
        }

        solveNQueensHelper(n, columns, 0, solutionsInIntegers);

        for (int[] solutionInInteger: solutionsInIntegers) {
            String[] solution = new String[n];
            for (int i = 0; i < n; i++) {
                Integer column = solutionInInteger[i];
                String line = "";
                for (int j = 0; j < n; j++) {
                    if (j != column) {
                        line += ".";
                    } else {
                        line += "Q";
                    }
                }
                solution[i] = line;
            }
            solutions.add(solution);
        }

        return solutions;
    }

    public static void solveNQueensHelper(int n, int[] columns,
                                          int row, ArrayList<int[]> solutions) {
        if (row == n) {
            solutions.add(columns.clone());
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(columns, row, i)) {
                    columns[row] = i;
                    solveNQueensHelper(n, columns, row + 1, solutions);
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
