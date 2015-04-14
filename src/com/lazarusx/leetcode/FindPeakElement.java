package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/11.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1};
        System.out.println(findPeakElement(num));
    }

    public static int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        return findPeakElementHelper(num, 0, num.length - 1);
    }

    public static int findPeakElementHelper(int[] num, int left, int right) {
        if ((right - left) < 2) {
            return (num[left] > num[right])? left : right;
        }

        int mid = (left + right) / 2;
        if (num[mid] > num[mid + 1]) {
            if (num[mid] > num[mid - 1]) {
                return mid;
            }
            return findPeakElementHelper(num, left, mid);
        } else {
            return findPeakElementHelper(num, mid, right);
        }
    }
}
