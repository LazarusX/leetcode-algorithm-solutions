package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/30.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        boolean found = false;
        int start = 0;
        int end = 0;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while (end < nums.length && start < nums.length) {
            if (sum < s) {
                end++;
                if (end == nums.length) {
                    break;
                } else {
                    sum += nums[end];
                }
            } else {
                found = true;

                if (end - start + 1 < min) {
                    min = end - start + 1;
                }

                if (start == end) {
                    end++;
                    if (end == nums.length) {
                        break;
                    } else {
                        sum += nums[end];
                    }
                } else {
                    sum -= nums[start];
                    start++;
                }
            }
        }

        if (found) {
            return min;
        } else {
            return 0;
        }
    }
}
