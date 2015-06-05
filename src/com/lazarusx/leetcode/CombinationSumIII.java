package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/6/5.
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        List<List<Integer>> combinations = combinationSum3(3, 9);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();

        combinationSum3Helper(k, n, 1, combination, combinations);

        return combinations;
    }

    public static void combinationSum3Helper(int k, int n, int current,
                                             List<Integer> combination, List<List<Integer>> combinations) {
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<Integer>(combination));
        } else if (k == 1 && n >= current && n <= 9)  {
            combination.add(n);
            combinations.add(new ArrayList<Integer>(combination));
            combination.remove(combination.size() - 1);
        } else if (k > 0 && n >= current) {
            for (int i = current; i <= Math.min(n, 9); i++) {
                combination.add(i);
                combinationSum3Helper(k - 1, n - i, i + 1, combination, combinations);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
