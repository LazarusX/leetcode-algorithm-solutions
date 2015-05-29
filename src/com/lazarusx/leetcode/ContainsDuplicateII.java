package com.lazarusx.leetcode;

import java.util.HashMap;

/**
 * Created by LazarusX on 15/5/29.
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return false;
        }
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            Integer index = hashMap.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return false;
    }
}
