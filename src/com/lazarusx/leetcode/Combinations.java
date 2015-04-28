package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/28.
 */
public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> combinations = combine(6, 5);
        for (List<Integer> combination : combinations) {
            for (Integer i : combination) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> combination = new ArrayList<Integer>();
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        combineHelper(n, k, combination, combinations, 0);

        return combinations;
    }

    public static void combineHelper(int n, int k,
                                     List<Integer> combination, List<List<Integer>> combinations, int biggest) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<Integer>(combination));
        } else {
            for (int i = biggest + 1; i <= n; i++) {
                combination.add(i);
                combineHelper(n, k, combination, combinations, i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
