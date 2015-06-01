package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/31.
 */
public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] amounts = new int[length];

        amounts[0] = nums[0];
        amounts[1] = nums[0];
        for (int i = 2; i < length; i++) {
            amounts[i] = Math.max(amounts[i - 1], amounts[i - 2] + nums[i]);
        }
        int max1 = amounts[length - 2];

        amounts[0] = 0;
        amounts[1] = nums[1];
        for (int i = 2; i < length; i++) {
            amounts[i] = Math.max(amounts[i - 1], amounts[i - 2] + nums[i]);
        }
        int max2 = amounts[length - 1];

        return Math.max(max1, max2);
    }
}
