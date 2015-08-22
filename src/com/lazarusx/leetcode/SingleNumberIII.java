package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/22.
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        Utility.printIntArray(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
    }

    public static int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 4) {
            return nums;
        }

        int m = 0;
        for (int num : nums) {
            m ^= num;
        }

        m = Integer.highestOneBit(m);

        int[] result = new int[2];
        for (int num : nums) {
            if ((num & m) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}
