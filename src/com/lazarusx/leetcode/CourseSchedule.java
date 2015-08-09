package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/8/9.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}}));
        System.out.println(canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
        System.out.println(canFinish(4, new int[][]{new int[]{0, 1}, new int[]{1, 2},
                new int[]{0, 2}}));
        System.out.println(canFinish(4, new int[][]{new int[]{0, 1}, new int[]{3, 1},
                new int[]{1, 3}, new int[]{3,2}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null
                || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }

        UndirectedGraphNode[] nodes = new UndirectedGraphNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new UndirectedGraphNode(i);
        }

        for (int[] prerequisite : prerequisites) {
            UndirectedGraphNode node = nodes[prerequisite[0]];
            UndirectedGraphNode preNode = nodes[prerequisite[1]];
            if (!node.neighbors.contains(preNode)) {
                node.neighbors.add(preNode);
            }
        }

        for (UndirectedGraphNode node : nodes) {
            boolean[] visited = new boolean[numCourses];
            if (foundCycle(node, visited)) {
                return false;
            }
        }

        return true;
    }

    public static boolean foundCycle(UndirectedGraphNode node, boolean[] visited) {
        if (visited[node.label]) {
            return true;
        }

        visited[node.label] = true;
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (foundCycle(neighbor, visited)) {
                return true;
            }
        }

        visited[node.label] = false;
        return false;
    }
}
