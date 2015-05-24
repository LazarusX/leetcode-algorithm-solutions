package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/23.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{1}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }

        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            return (findKthSortedArrays(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 - 1)
                    + findKthSortedArrays(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2))
                    / 2.0;
        } else {
            return findKthSortedArrays(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2);
        }
    }

    public static int findKthSortedArrays(int[] nums1, int left1, int right1,
                                          int[] nums2, int left2, int right2,
                                          int k) {
        int m = right1 - left1 + 1;
        int n = right2 - left2 + 1;

        if (m <= 0) {
            return nums2[left2 + k];
        }

        if (n <= 0) {
            return nums1[left1 + k];
        }

        if (k == 0) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        int mid1 = (left1 + right1 + 1) / 2;
        int mid2 = (left2 + right2 + 1) / 2;

        if (nums1[mid1] <= nums2[mid2]) {
            if (m / 2 + n / 2 >= k) {
                return findKthSortedArrays(nums1, left1, right1, nums2, left2, mid2 - 1, k);
            } else {
                return findKthSortedArrays(nums1, mid1 + 1, right1, nums2, left2, right2, k - m / 2 - 1);
            }
        } else {
            if (m / 2 + n / 2 >= k) {
                return findKthSortedArrays(nums1, left1, mid1 - 1, nums2, left2, right2, k);
            } else {
                return findKthSortedArrays(nums1, left1, right1, nums2, mid2 + 1, right2, k - n / 2 - 1);
            }
        }
    }
}
