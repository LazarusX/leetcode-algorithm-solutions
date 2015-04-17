package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/16.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> permutations = permute(num);
        for (List<Integer> permutation : permutations) {
            System.out.print("[");
            for (Integer value : permutation) {
                System.out.print(value + ",");
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return permutations;
        }

        permutations.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            int element = num[i];
            List<List<Integer>> newPermutations = new ArrayList<List<Integer>>();
            for (List<Integer> permutation : permutations) {
                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(permutation);
                    newPermutation.add(j, element);
                    newPermutations.add(newPermutation);
                }
            }
            permutations = newPermutations;
        }

        return permutations;
    }
}
