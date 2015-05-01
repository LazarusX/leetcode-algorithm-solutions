package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/5/1.
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();

        if (rowIndex < 0) {
            return row;
        }
        
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = row.size() - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }

            row.add(1);
        }

        return row;
    }
}
