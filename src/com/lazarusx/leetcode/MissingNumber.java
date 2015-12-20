package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/12/20.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 1, 5};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= (i + 1) ^ nums[i];
        }

        return result;
    }
}
