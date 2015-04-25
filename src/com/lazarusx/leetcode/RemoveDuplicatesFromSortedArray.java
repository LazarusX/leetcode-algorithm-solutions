package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/25.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 5};
        int length = removeDuplicates(A);
        for (int i = 0; i < length; i++) {
            System.out.println(A[i]);
        }
    }

    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 1;
        }

        int slow = 0;
        int fast = slow + 1;
        int length = A.length;
        while (fast < A.length) {
            if (A[fast] != A[slow]) {
                A[++slow] = A[fast++];
            } else {
                length--;
                fast++;
            }
        }

        return length;
    }
}
