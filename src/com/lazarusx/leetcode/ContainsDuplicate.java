package com.lazarusx.leetcode;

import java.util.HashSet;

/**
 * Created by LazarusX on 15/5/29.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }

        return false;
    }
}
