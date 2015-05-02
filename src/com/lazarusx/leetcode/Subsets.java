package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LazarusX on 15/5/2.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return subsets;
        }

        Arrays.sort(nums);
        int size = 1 << nums.length;
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<Integer>();

            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            
            subsets.add(subset);
        }

        return subsets;
    }
}
