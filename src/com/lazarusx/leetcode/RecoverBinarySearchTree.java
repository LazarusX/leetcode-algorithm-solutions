package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/21.
 */
public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(1);

        recoverTree(root);
    }

    public static void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode mistake1 = null;
        TreeNode mistake2 = null;

        while (current != null) {
            if (current.left == null) {
                if (prev != null) {
                    if (prev.val > current.val) {
                        if (mistake1 == null) {
                            mistake1 = prev;
                        }
                        mistake2 = current;
                    }
                }

                prev = current;
                current = current.right;
            } else {
                TreeNode rightmostOfLeft = current.left;
                while (rightmostOfLeft.right != null && rightmostOfLeft.right != current) {
                    rightmostOfLeft = rightmostOfLeft.right;
                }

                if (rightmostOfLeft.right == null) {
                    rightmostOfLeft.right = current;
                    current = current.left;
                } else {
                    rightmostOfLeft.right = null;
                    if (prev != null) {
                        if (prev.val > current.val) {
                            if (mistake1 == null) {
                                mistake1 = prev;
                            }
                            mistake2 = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }

        int temp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = temp;
    }
}
