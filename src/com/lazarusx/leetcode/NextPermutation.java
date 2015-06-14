package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/14.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        Utility.printIntArray(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums != null && nums.length > 1) {
            int i;
            for (i = nums.length - 2; i >= 0 ; i--) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }

            if (i == -1) {
                reverseArray(nums, 0, nums.length - 1);
            } else {
                int min = Integer.MAX_VALUE;
                int newFirst = 0;
                for (int j = nums.length - 1; j >= i + 1; j--) {
                    if (nums[j] > nums[i] && nums[j] < min) {
                        min = nums[j];
                        newFirst = j;
                    }
                }

                int temp = nums[newFirst];
                nums[newFirst] = nums[i];
                nums[i] = temp;
                reverseArray(nums, i + 1, nums.length - 1);
            }
        }
    }

    public static void reverseArray(int[] nums, int fromIndex, int toIndex) {
        int midIndex = (fromIndex + toIndex) / 2;
        for (int i = fromIndex; i <= midIndex; i++) {
            int destIndex = fromIndex + toIndex - i;
            int temp = nums[destIndex];
            nums[destIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
