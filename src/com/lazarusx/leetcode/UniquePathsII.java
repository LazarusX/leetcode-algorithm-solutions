package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] paths = new int[m][n];

        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    paths[i][j] += paths[i - 1][j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    paths[i][j] += paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }
}
