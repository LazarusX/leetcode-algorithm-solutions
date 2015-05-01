package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/1.
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(1);

        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        boolean isLeave = true;
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            isLeave = false;
            int depth = minDepth(root.left);
            if (depth < min) {
                min = depth;
            }
        }
        if (root.right != null) {
            isLeave = false;
            int depth = minDepth(root.right);
            if (depth < min) {
                min = depth;
            }
        }

        if (isLeave) {
            return 1;
        } else {
            return min + 1;
        }
    }
}
