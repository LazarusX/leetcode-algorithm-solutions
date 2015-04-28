package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/28.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 2, 2, 3};
        int length = removeDuplicates(A);
        for (int i = 0; i < length; i++) {
            System.out.print(A[i] + ",");
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
        int dup = 0;
        while (fast < A.length) {
            if (A[fast] != A[slow]) {
                A[++slow] = A[fast++];
                dup = 0;
            } else {
                if (dup == 1) {
                    length--;
                    fast++;
                } else {
                    A[++slow] = A[fast++];
                    dup++;
                }
            }
        }

        return length;
    }
}
