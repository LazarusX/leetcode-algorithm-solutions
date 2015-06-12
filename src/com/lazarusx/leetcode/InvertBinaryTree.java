package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/12.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);;
        root.right = invertTree(temp);

        return root;
    }
}
