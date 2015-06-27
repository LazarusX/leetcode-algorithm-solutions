package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/6/27.
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            int j;
            for (j = i + 1; j < nums.length && nums[j] - current == 1; j++) {
                current = nums[j];
            }

            if (nums[j - 1] != nums[i]) {
                result.add(nums[i] + "->" + nums[j - 1]);
            } else {
                result.add(nums[i] + "");
            }

            i = j - 1;
        }

        return result;
    }
}
