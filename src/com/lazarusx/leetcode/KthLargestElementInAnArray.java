package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/30.
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2, 1}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return -1;
        }

        return findKthLargestHelper(nums, 0, nums.length - 1, k);
    }

    public static int findKthLargestHelper(int[] nums, int left, int right, int k) {
        if (k == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }

            return max;
        }

        int pivot = (left + right) / 2;

        int temp = nums[pivot];
        nums[pivot] = nums[right];
        nums[right] = temp;

        int i = left;
        int j = right - 1;
        while (i <= j) {
            while (i < right && nums[i] >= nums[right]) {
                i++;
            }

            while (j >= 0 && nums[j] < nums[right]) {
                j--;
            }

            if (i <= j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if (i != right) {
            if (i - left + 1 == k) {
                return nums[right];
            } else if (i - left + 1 > k) {
                return findKthLargestHelper(nums, left, i - 1, k);
            } else { // i - left + 1 < k
                return findKthLargestHelper(nums, i, right - 1, k - (i -left + 1));
            }
        } else {
            if (i - left + 1 == k) {
                return nums[right];
            } else { // i - left + 1 > k
                return findKthLargestHelper(nums, left, i - 1, k);
            }
        }
    }
}
