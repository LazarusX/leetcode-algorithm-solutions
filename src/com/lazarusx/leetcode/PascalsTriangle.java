package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/29.
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(5);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return triangle;
        }

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            List<Integer> previous = null;
            if (i > 2) {
                 previous = triangle.get(i - 2);
            }
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    row.add(1);
                } else if (j == i - 1) {
                    row.add(1);
                } else {
                    row.add(previous.get(j - 1) + previous.get(j));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }
}
