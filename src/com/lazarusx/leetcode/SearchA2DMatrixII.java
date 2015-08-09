package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/9.
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 9));
        System.out.println(searchMatrix(matrix, 11));
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrix(matrix, 29));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return searchMatrixHelper(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    public static boolean searchMatrixHelper(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
        int centerX = (x1 + x2) / 2;
        int centerY = (y1 + y2) / 2;
        int center = matrix[centerX][centerY];

        if (x1 == x2) {
            if (y1 == y2) {
                return matrix[x1][y1] == target;
            } else if (center == target) {
                return true;
            } else if (center > target){
                return searchMatrixHelper(matrix, x1, y1, x1, centerY, target);
            } else {
                return searchMatrixHelper(matrix, x1, centerY + 1, x1, y2, target);
            }
        } else if (y1 == y2) {
            if (center == target) {
                return true;
            } else if (center > target) {
                return searchMatrixHelper(matrix, x1, y1, centerX, y1, target);
            } else {
                return searchMatrixHelper(matrix, centerX + 1, y1, x2, y2, target);
            }
        } else {
            if (center == target) {
                return true;
            } else if (center > target) {
                return searchMatrixHelper(matrix, x1, y1, centerX, centerY, target)
                        || searchMatrixHelper(matrix, x1, centerY + 1, centerX, y2, target)
                        || searchMatrixHelper(matrix, centerX + 1, y1, x2, centerY, target);
            } else {
                return searchMatrixHelper(matrix, centerX + 1, centerY + 1, x2, y2, target)
                        || searchMatrixHelper(matrix, x1, centerY + 1, centerX, y2, target)
                        || searchMatrixHelper(matrix, centerX + 1, y1, x2, centerY, target);
            }
        }
    }
}
