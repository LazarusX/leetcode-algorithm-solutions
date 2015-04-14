package com.lazarusx.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // Good. It works. O(n^2)
    public static int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] indices = new int[2];

        for (int i=0; i<numbers.length; i++) {
            indices[0] = i + 1;
            indices[1] = 0;
            for (int j=i+1; j < numbers.length; j++) {
                if (numbers[j] == target-numbers[i]) {
                    indices[1] = j + 1;
                    break;
                }
            }
            if (indices[1] > 0)
                break;
        }

        return indices;
    }

    // Better. Use HashMap to reduce complexity. O(n)
    public static int[] twoSum2(int[] numbers, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i=0; i<numbers.length; i++) {
            if (map.get(target - numbers[i]) != null) {
                indices[0] = i+1;
                indices[1] = map.get(target - numbers[i]) + 1;
                break;
            }
        }

        return indices;
    }

    // Best. Reduce loop. O(n)
    public static int[] twoSum3(int[] numbers, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                indices[0] = map.get(numbers[i])+1;
                indices[1] = i+1;
                break;
            } else {
                map.put(target-numbers[i], i);
            }
        }

        return indices;
    }

    // Better. What if using HashMap is prevented. O(n*log(n))
    public static int[] twoSum4(int[] numbers, int target) {
        int[] indices = new int[2];
        Node[] nodes = new Node[numbers.length];

        for (int i=0; i<numbers.length;i++) {
            nodes[i] = new Node(numbers[i], i);
        }
        Arrays.sort(nodes);

        int i=0;
        int j=numbers.length-1;

        while (i<j) {
            int sum = nodes[i].value + nodes[j].value;
            if (sum == target) {
                indices[0] = Math.min(nodes[i].index+1, nodes[j].index+1);
                indices[1] = Math.max(nodes[i].index+1, nodes[j].index+1);
                return indices;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return indices;
    }

    static class Node implements Comparable<Node> {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        int getVal() {
            return this.value;
        }

        @Override
        public int compareTo(Node o) {
            return this.getVal() - o.getVal();
        }

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 75, 25};
        int target = 100;
        int[] indices = new int[2];
        indices = twoSum4(numbers, target);
        for (int i=0; i<indices.length; i++)
            System.out.println(indices[i]);
    }
}