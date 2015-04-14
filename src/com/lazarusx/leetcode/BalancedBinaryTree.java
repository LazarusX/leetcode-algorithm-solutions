package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/11.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(20);

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        return isBalancedAndGetHeight(root) >= 0;
    }

    public static int isBalancedAndGetHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedAndGetHeight(root.left);
        int rightHeight = isBalancedAndGetHeight(root.right);

        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
