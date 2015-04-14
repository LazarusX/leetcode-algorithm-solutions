package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/9.
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> results = levelOrderBottom(root);
        for (List<Integer> result: results) {
            for (Integer value: result) {
                System.out.println(value);
            }
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        levelOrderBottomHelper(root, 0, results);

        return results;
    }

    public static void levelOrderBottomHelper(TreeNode node, int level, List<List<Integer>> results) {
        if (node == null) {
            return;
        }

        List<Integer> result;

        if (results.size() == level) {
            result = new ArrayList<Integer>();
            results.add(0, result);
        } else {
            result = results.get(results.size() - level - 1);
        }

        result.add(node.val);

        levelOrderBottomHelper(node.left, level + 1, results);
        levelOrderBottomHelper(node.right, level + 1, results);
    }
}
