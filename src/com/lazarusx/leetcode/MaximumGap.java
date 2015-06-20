package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/20.
 */
public class MaximumGap {
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{1,1,1,1,1,5,5,5,5,5}));
    }

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
        int bucketCount = (max - min) / bucketSize + 1;

        int[] maxs = new int[bucketCount];
        int[] mins = new int[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            maxs[i] = -1;
            mins[i] = -1;
        }

        for (int num : nums) {
            int bucketID = (num - min) / bucketSize;
            if (num > maxs[bucketID]) {
                maxs[bucketID] = num;
            }
            if (mins[bucketID] == -1 || mins[bucketID] > num) {
                mins[bucketID] = num;
            }
        }

        int maxGap = 0;
        int previousMax = maxs[0];
        for (int i = 1; i < bucketCount; i++) {
            if (mins[i] != -1 && mins[i] - previousMax > maxGap) {
                maxGap = mins[i] - previousMax;
            }
            if (maxs[i] != -1) {
                previousMax = maxs[i];
            }
        }

        return maxGap;
    }
}
