package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LazarusX on 15/5/12.
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(2)),
                        new ArrayList<Integer>(Arrays.asList(3, 4)),
                                new ArrayList<Integer>(Arrays.asList(6, 5, 7)),
                                        new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3))));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int rowCount = triangle.size();
        int[] lengths = new int[rowCount];
        lengths[0] = triangle.get(0).get(0);

        for (int i = 1; i < rowCount; i++) {
            int[] tempLengths = new int[i + 1];
            tempLengths[0] = lengths[0] + triangle.get(i).get(0);
            tempLengths[i] = lengths[i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                tempLengths[j] = Math.min(lengths[j - 1], lengths[j]) + triangle.get(i).get(j);
            }

            System.arraycopy(tempLengths, 0, lengths, 0, i + 1);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            if (lengths[i] < min) {
                min = lengths[i];
            }
        }

        return min;
    }
}
