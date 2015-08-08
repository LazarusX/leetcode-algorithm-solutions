package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/9.
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        System.out.println(kthSmallest(root, 5));
    }

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                if (k == 1) {
                    return current.val;
                } else {
                    current = current.right;
                    k--;
                }
            } else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    temp.right = null;
                    if (k == 1) {
                        return current.val;
                    } else {
                        current = current.right;
                        k--;
                    }
                }
            }
        }

        return current.val;
    }
}
