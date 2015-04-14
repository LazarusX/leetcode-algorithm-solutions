package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/12.
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1};
        System.out.println(removeElement(A, 0));
    }

    public static int removeElement(int[] A, int elem) {
        int i = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] != elem) {
                A[i] = A[j];
                i++;
            }
        }

        return i;
    }
}
