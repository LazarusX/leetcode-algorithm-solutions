package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/15.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        List<Integer> height = new ArrayList<Integer>();
        height.add(1);
        height.add(2);
        height.add(1);
        System.out.println(maxArea(height));
    }

    public static int maxArea(List<Integer> height) {
        if (height == null || height.size() < 2) {
            return 0;
        }

        int max = 0;
        int i = 0;
        int j = height.size() - 1;

        while (i != j) {
            int hi = height.get(i);
            int hj = height.get(j);
            int area;
            if (hi > hj) {
                area = hj * (j - i);
                j--;
            } else {
                area = hi * (j - i);
                i++;
            }
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}
