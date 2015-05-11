package com.lazarusx.leetcode;

import java.util.HashSet;

/**
 * Created by LazarusX on 15/5/10.
 */
public class ValidSudoku {
    public static void main(String[] args) {
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (row.contains(c)) {
                        return false;
                    } else {
                        row.add(c);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> column = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (column.contains(c)) {
                        return false;
                    } else {
                        column.add(c);
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                HashSet<Character> cell = new HashSet<Character>();
                for (int k = 0; k < 9; k++) {
                    int x = k / 3 + i * 3;
                    int y = k % 3 + j * 3;
                    char c = board[x][y];
                    if (c != '.') {
                        if (cell.contains(c)) {
                            return false;
                        } else {
                            cell.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }
}
