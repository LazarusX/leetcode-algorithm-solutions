package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/8/10.
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        Utility.printIntArray(findOrder(2, new int[][]{new int[]{1, 0}}));
        Utility.printIntArray(findOrder(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
        Utility.printIntArray(findOrder(4,
                new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}}));
        Utility.printIntArray(findOrder(10,
                new int[][]{new int[]{5, 8}, new int[]{3, 5}, new int[]{1, 9}, new int[]{4, 5},
                        new int[]{0, 2}, new int[]{1, 9},new int[]{7, 8}, new int[]{4, 9}}));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null
                || prerequisites.length == 0 || prerequisites[0].length == 0) {
            int[] output = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                output[i] = i;
            }

            return output;
        }

        boolean[][] matrix = new boolean[numCourses][numCourses];
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (!matrix[prerequisite[0]][prerequisite[1]]) {
                matrix[prerequisite[0]][prerequisite[1]] = true;
                indegrees[prerequisite[0]]++;
            }
        }

        int[] output = new int[numCourses];
        int outputLength = 0;
        Stack<Integer> noIncomingList = new Stack<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                noIncomingList.push(i);
            }
        }

        while (!noIncomingList.isEmpty()) {
            int current = noIncomingList.pop();
            output[outputLength] = current;
            outputLength++;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[i][current]) {
                    matrix[i][current] = false;
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        noIncomingList.push(i);
                    }
                }
            }
        }

        if (outputLength != numCourses) {
            return new int[0];
        } else {
            return output;
        }
    }
}
