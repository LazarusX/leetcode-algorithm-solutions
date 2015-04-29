package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/29.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 7, 0, 0, 0, 0, 0};
        int[] B = {0, 3, 4, 5, 8};
        merge(A, 4, B, 5);
        for (int i : A) {
            System.out.print(i);
        }
    }

    public static void merge(int A[], int m, int B[], int n) {
        if (B == null) {
            return;
        }

        int newLength = m + n;
        int ia = m - 1;
        int ib = n - 1;
        for (int i = newLength - 1; i >= 0; i--) {
            if (ia >= 0 && ib >= 0) {
                if (A[ia] > B[ib]) {
                    A[i] = A[ia];
                    ia--;
                } else {
                    A[i] = B[ib];
                    ib--;
                }
            } else if (ib >= 0) {
                A[i] = B[ib];
                ib--;
            }
        }
    }
}
