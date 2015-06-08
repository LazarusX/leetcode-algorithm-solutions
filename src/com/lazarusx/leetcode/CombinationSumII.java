package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LazarusX on 15/6/7.
 */
public class CombinationSumII {
    public static void main(String[] args) {
        Utility.printListOfListsOfIntegers(combinationSum2(new int[]{10, 1, 2, 7, 6, 1 , 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0) {
            return combinations;
        }

        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, new ArrayList<Integer>(), combinations);

        return combinations;
    }

    public static void combinationSum2Helper(int[] candidates, int n, int current,
                                             List<Integer> combination, List<List<Integer>> combinations) {
        if (n == 0) {
            combinations.add(new ArrayList<Integer>(combination));
        } else {
            for (int i = current; i < candidates.length && candidates[i] <= n; i++) {
                if (i > current && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                combination.add(candidates[i]);
                combinationSum2Helper(candidates, n - candidates[i], i + 1, combination, combinations);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
