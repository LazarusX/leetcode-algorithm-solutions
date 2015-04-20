package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/21.
 */
public class PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        pathSumHelper(root, sum, result, results);

        return results;
    }

    public static void pathSumHelper(TreeNode root, int sum, List<Integer> result, List<List<Integer>> results) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(root.val);
                results.add(new ArrayList<Integer>(result));
                result.remove(result.size() - 1);
            }
        } else {
            if (root.left != null) {
                result.add(root.val);
                pathSumHelper(root.left, sum - root.val, result, results);
                result.remove(result.size() - 1);
            }
            if (root.right != null) {
                result.add(root.val);
                pathSumHelper(root.right, sum - root.val, result, results);
                result.remove(result.size() - 1);
            }
        }
    }
}
