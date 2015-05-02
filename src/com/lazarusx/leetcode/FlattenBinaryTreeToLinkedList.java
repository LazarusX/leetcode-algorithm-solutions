package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/2.
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);

        flatten(root.right);

        if (root.left != null) {
            TreeNode current = root.left;
            while (current.right != null) {
                current = current.right;
            }

            current.right = root.right;
            root.right = root.left;
        }

        root.left = null;
    }
}
