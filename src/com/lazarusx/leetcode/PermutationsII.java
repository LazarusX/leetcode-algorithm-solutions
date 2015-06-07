package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by LazarusX on 15/6/7.
 */
public class PermutationsII {
    public static void main(String[] args) {
        Utility.printListOfListsOfIntegers(permuteUnique(new int[]{1, 1, 2, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        HashSet<Integer> uniqueNumbers = new HashSet<Integer>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        if (uniqueNumbers.size() == 1) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int num : nums) {
                result.add(num);
            }
            results.add(result);
            return results;
        }

        for (int num : uniqueNumbers) {
            int[] subArray = new int[nums.length - 1];
            boolean found = false;
            int i = 0;
            for (int num1 : nums) {
                if (!found && num1 == num) {
                    found = true;
                } else {
                    subArray[i] = num1;
                    i++;
                }
            }

            List<List<Integer>> subResult = permuteUnique(subArray);
            for (List<Integer> permutation : subResult) {
                permutation.add(num);
                results.add(permutation);
            }
        }

        return results;
    }
}
