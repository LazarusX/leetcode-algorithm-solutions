package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/11.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] A = {0, 2, 1, 2, 0, 1, 0, 2, 1, 1};
        sortColors(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }
    }

    public static void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int index0 = 0;
        int index1 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[i] = 2;
                A[index1] = 1;
                A[index0] = 0;
                index0++;
                index1++;
            } else if (A[i] == 1) {
                A[i] = 2;
                A[index1] = 1;
                index1++;
            }
        }
    }
}
