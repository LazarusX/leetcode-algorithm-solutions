package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/22.
 */
public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static boolean isValidBSTHelper(TreeNode node, double min, double max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBSTHelper(node.left, min, node.val)
                && isValidBSTHelper(node.right, node.val, max);
    }
}
