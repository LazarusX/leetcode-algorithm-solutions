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
        int[] mins = new int[triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            mins[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                mins[j] = Math.min(mins[j], mins[j + 1]) + triangle.get(i).get(j);
            }
        }

        return mins[0];
    }
}
