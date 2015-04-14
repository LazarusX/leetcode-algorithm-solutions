package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/5.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        System.out.println(searchInsert(A, 5));
    }

    /*
    [1,3,5,6], 5 → 2
    [1,3,5,6], 2 → 1
    [1,3,5,6], 7 → 4
    [1,3,5,6], 0 → 0
    */
    public static int searchInsert(int[] A, int target) {
        return searchInsertHelper(A, target, 0, A.length - 1);
    }

    public static int searchInsertHelper(int[] A, int target, int left, int right) {
        if (left > right) {
            if (right < 0) {
                return 0;
            } else if (left >= A.length) {
                return left;
            } else if (target > A[left]){
                return left + 1;
            } else {
                return right + 1;
            }
        }

        int mid = (left + right) / 2;
        if (target == A[mid]) {
            return mid;
        } else if (target < A[mid]) {
            return searchInsertHelper(A, target, left, mid - 1);
        } else {
            return searchInsertHelper(A, target, mid + 1, right);
        }
    }
}
