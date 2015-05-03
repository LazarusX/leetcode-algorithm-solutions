package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LazarusX on 15/5/3.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> combinations = combinationSum(candidates, 7);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0) {
            return  combinations;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new LinkedList<Integer>();

        combinationsSumHelper(candidates, target, combination, combinations, candidates.length - 1);

        return combinations;
    }

    public static void combinationsSumHelper(int[] candidates, int target,
                                             List<Integer> combination, List<List<Integer>> combinations, int biggest) {
        if (target == 0) {
            combinations.add(new LinkedList<Integer>(combination));
        } else if (biggest >= 0) {
            int i = 0;
            while (candidates[biggest] * i <= target) {
                for (int j = 0; j < i; j++) {
                    combination.add(0, candidates[biggest]);
                }
                combinationsSumHelper(candidates, target - candidates[biggest] * i,
                        combination, combinations, biggest - 1);
                for (int j = 0; j < i; j++) {
                    combination.remove(0);
                }
                i++;
            }
        }
    }
}
