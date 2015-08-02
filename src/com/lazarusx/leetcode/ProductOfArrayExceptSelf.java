package com.lazarusx.leetcode;

import java.util.Arrays;

/**
 * Created by LazarusX on 15/8/2.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Utility.printIntArray(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= leftProduct;
            result[nums.length - 1 - i] *= rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];
        }

        return result;
    }
}
