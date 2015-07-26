package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/26.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int localMax = nums[0];
        int localMin = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int localMaxCopy = localMax;
            localMax = Math.max(nums[i], Math.max(localMax * nums[i], localMin * nums[i]));
            localMin = Math.min(nums[i], Math.min(localMaxCopy * nums[i], localMin * nums[i]));
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;
    }
}
