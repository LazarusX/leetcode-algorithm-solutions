package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/11.
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(num));
    }

    public static int findMin(int[] num) {
        return findMinHelper(num, 0, num.length - 1);
    }

    public static int findMinHelper(int[] num, int left, int right) {
        if ((right - left) < 2) {
            return Math.min(num[left], num[right]);
        }

        int mid = (left + right) / 2;

        if (num[left] > num[mid]) {
            return findMinHelper(num, left, mid);
        } else if (num[mid] > num[right]) {
            return findMinHelper(num, mid, right);
        } else {
            return num[left];
        }
    }
}
