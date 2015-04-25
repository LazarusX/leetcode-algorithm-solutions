package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/25.
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 4));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        if (target < matrix[0][0]) {
            return false;
        }

        int row = getRow(matrix, target);
        if (row == matrix.length) {
            return true;
        } else {
            return binarySearch(matrix, row, target);
        }
    }

    public static int getRow(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[bottom][0]) {
                return bottom;
            } else if (target == matrix[mid][0]) {
                return matrix.length;
            } else if (target < matrix[mid][0]){
                bottom = mid - 1;
            } else {
                top = mid;
                bottom--;
            }
        }

        return top;
    }

    public static boolean binarySearch(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target < matrix[row][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return matrix[row][left] == target;
    }
}
