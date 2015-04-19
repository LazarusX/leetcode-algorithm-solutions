package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/19.
 */
public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    public static int findMinHelper(int[] nums, int left, int right) {
        if ((right - left) < 2) {
            return Math.min(nums[left], nums[right]);
        }

        int mid = (left + right) / 2;
        int oldMid = mid;
        while (mid > left && nums[mid] == nums[mid - 1]) {
            mid--;
        }
        if (mid == left) {
            return findMinHelper(nums, oldMid, right);
        }
        if (nums[mid] > nums[right]) {
            return findMinHelper(nums, mid, right);
        } else {
            return findMinHelper(nums, left, mid);
        }
    }
}
