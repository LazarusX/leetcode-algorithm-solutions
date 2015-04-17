package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/17.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int sideLength = matrix.length;
        for (int i = 0; i < sideLength / 2; i++) {
            for (int j = i; j < sideLength - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[sideLength - j - 1][i];
                matrix[sideLength - j - 1][i] = matrix[sideLength - i - 1][sideLength - j - 1];
                matrix[sideLength - i - 1][sideLength - j - 1] = matrix[j][sideLength - i - 1];
                matrix[j][sideLength - i - 1] = temp;
            }
        }
    }
}
