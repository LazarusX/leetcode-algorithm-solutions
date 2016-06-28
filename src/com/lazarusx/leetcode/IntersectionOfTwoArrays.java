package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by LazarusX on 16/6/28.
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Utility.printIntArray(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }

        HashSet<Integer> resultSet = new HashSet<Integer>();
        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer n : resultSet) {
            result[i] = n;
            i++;
        }

        return result;
    }
}
