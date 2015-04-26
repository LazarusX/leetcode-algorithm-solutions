package com.lazarusx.leetcode;

import java.util.HashSet;

/**
 * Created by LazarusX on 15/4/26.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            hashSet.add(num);
        }

        int max = 1;
        for (int num : nums) {
            int temp = num;
            int current = 1;
            while (hashSet.contains(temp - 1)) {
                hashSet.remove(temp - 1);
                current++;
                temp--;
            }
            temp = num;
            while (hashSet.contains(temp + 1)) {
                hashSet.remove(temp + 1);
                current++;
                temp++;
            }

            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
