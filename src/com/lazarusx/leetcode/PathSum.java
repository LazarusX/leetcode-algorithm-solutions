package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/21.
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            if (root.left == null && root.right == null) {
                if (sum == root.val) {
                    return true;
                } else {
                    return false;
                }
            } else {
                boolean result = false;
                if (root.left != null) {
                    result |= hasPathSum(root.left, sum - root.val);
                }
                if (root.right != null) {
                    result |= hasPathSum(root.right, sum - root.val);
                }

                return result;
            }
        }
    }
}
