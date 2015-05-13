package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/13.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int furthestPosition = 0;

        for (int i = 0; i <= furthestPosition && i < nums.length; i++) {
            if (nums[i] + i > furthestPosition) {
                furthestPosition = nums[i] + i;
            }
            if (furthestPosition >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
