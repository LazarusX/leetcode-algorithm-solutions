package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/26.
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        if ((p.val - root.val) * (q.val - root.val) <= 0) {
            return root;
        }

        if ((p.val - root.val) > 0) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
