package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/12/20.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        Utility.printIntArray(nums);
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                nums[i - zero] = nums[i];
            }
        }

        for (int i = nums.length - zero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
