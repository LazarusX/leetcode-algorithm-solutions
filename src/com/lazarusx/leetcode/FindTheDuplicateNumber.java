package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 16/3/10.
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 2, 4, 4, 4}));
    }

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int low = 1;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low < high) {
            int count = 0;
            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }

        return low;
    }
}
