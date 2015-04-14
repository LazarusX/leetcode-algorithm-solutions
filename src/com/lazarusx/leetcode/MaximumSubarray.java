package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/6.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(A));
    }

    public static int maxSubArray(int[] A) {
        int maxSum = 0;
        int sum = 0;
        int maxNonPositive = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0 && A[i] > maxNonPositive) {
                maxNonPositive = A[i];
            }
            sum += A[i];
            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }

        if (maxSum > 0) {
            return maxSum;
        } else {
            return maxNonPositive;
        }
    }
}
