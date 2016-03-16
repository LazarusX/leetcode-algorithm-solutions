package com.lazarusx.leetcode;

import java.util.HashMap;

/**
 * Created by LazarusX on 16/3/15.
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        HashMap<TreeNode, Integer> cache = new HashMap<TreeNode, Integer>();
        cache.put(null, 0);

        return robHelper(root, cache);
    }

    public static int robHelper(TreeNode root, HashMap<TreeNode, Integer> cache) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }

        int robChildren = robHelper(root.left, cache) + robHelper(root.right, cache);

        int robGrandChildren = 0;
        if (root.left != null) {
            robGrandChildren += robHelper(root.left.left, cache) + robHelper(root.left.right, cache);
        }
        if (root.right != null) {
            robGrandChildren += robHelper(root.right.left, cache) + robHelper(root.right.right, cache);
        }
        robGrandChildren += root.val;

        int max = Math.max(robChildren, robGrandChildren);
        cache.put(root, max);

        return max;
    }
}
