package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LazarusX on 15/5/8.
 */
public class SubsetsII {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        ArrayList<Integer> current = new ArrayList<Integer>();
        result.add(current);

        subsetsWithDupHelper(nums, 0, current, result);

        return result;
    }

    public static void subsetsWithDupHelper(int[] nums, int index,
                                            ArrayList<Integer> current, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            result.add(new ArrayList<Integer>(current));

            if (i < nums.length - 1) {
                subsetsWithDupHelper(nums, i + 1, current, result);
            }

            current.remove(current.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
