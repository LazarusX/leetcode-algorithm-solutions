package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/24.
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        System.out.println(search(nums, 1));
    }

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public static boolean searchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true;
        } else {
            while (nums[left] == nums[mid] && left < mid) {
                left++;
            }

            while (nums[right] == nums[mid] && right > mid) {
                right--;
            }

            if (nums[mid] >= nums[left]) {
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
}
