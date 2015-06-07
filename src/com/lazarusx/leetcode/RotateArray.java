package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/22.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotate(nums, 3);

        Utility.printIntArray(nums);
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }

        k = k % nums.length;

        if (k == 0) {
            return;
        }

        int temp;
        int start = 0;
        int next = start;
        int current = nums[start];
        for (int i = 0; i < nums.length; i++) {
            next = (next + k) % nums.length;
            temp = nums[next];
            nums[next] = current;
            current = temp;

            if (next == start) {
                start++;
                next = start;
                current = nums[start];
            }
        }
    }
}
