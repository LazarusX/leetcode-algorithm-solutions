package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/11.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] num = {1, 3, 4, 6, 7, 19};
        sortedArrayToBST(num);
    }

    public static TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }

        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBSTHelper(num, left, mid - 1);
        node.right = sortedArrayToBSTHelper(num, mid + 1, right);

        return node;
    }
}
