package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/7.
 */
public class SearchForARange {
    public static void main(String[] args) {
        int[] range = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i : range) {
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }

        return searchRangeHelper(nums, target, 0, nums.length - 1);
    }

    public static int[] searchRangeHelper(int[] nums, int target, int left, int right) {
        if (left == right - 1 || left == right) {
            if (nums[left] == target && nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] == target) {
                return new int[]{left, left};
            } else if (nums[right] == target) {
                return new int[]{right, right};
            } else {
                return new int[]{-1, -1};
            }
        }

        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return searchRangeHelper(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return searchRangeHelper(nums, target, mid + 1, right);
        } else {
            int[] leftPart = searchRangeHelper(nums, target, left, mid);
            int[] rightPart = searchRangeHelper(nums, target, mid, right);
            return new int[]{leftPart[0], rightPart[1]};
        }
    }
}
