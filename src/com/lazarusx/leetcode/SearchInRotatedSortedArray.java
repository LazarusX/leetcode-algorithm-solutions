package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/24.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, 1, 2};
        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public static int searchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[left]) {
            if (target >= nums[left] && target < nums[mid]) {
                return searchHelper(nums, target, left, mid - 1);
            } else {
                return searchHelper(nums, target, mid + 1, right);
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                return searchHelper(nums, target, mid + 1, right);
            } else {
                return searchHelper(nums, target, left, mid - 1);
            }
        }
    }
}
