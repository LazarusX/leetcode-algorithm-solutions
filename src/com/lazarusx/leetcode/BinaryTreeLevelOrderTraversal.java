package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/9.
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> results = levelOrder(root);
        for (List<Integer> result: results) {
            for (Integer value: result) {
                System.out.println(value);
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        levelOrderHelper(root, 0, results);

        return results;
    }

    public static void levelOrderHelper(TreeNode node, int level, List<List<Integer>> results) {
        if (node == null) {
            return;
        }

        List<Integer> result;

        if (results.size() == level) {
            result = new ArrayList<Integer>();
            results.add(result);
        } else {
            result = results.get(level);
        }

        result.add(node.val);

        levelOrderHelper(node.left, level + 1, results);
        levelOrderHelper(node.right, level + 1, results);
    }
}
