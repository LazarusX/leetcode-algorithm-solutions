package com.lazarusx.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LazarusX on 15/6/7.
 */
public class Utility {
    public static void printIntArray(int a[]) {
        System.out.println(Arrays.toString(a));
    }

    public static void printListOfListsOfIntegers(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
