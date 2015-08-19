package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/8/19.
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<String>();

        if (root == null) {
            return result;
        }

        ArrayList<Integer> history = new ArrayList<Integer>();
        binaryTreePathsHelper(root, history, result);
        return result;
    }

    public static void binaryTreePathsHelper(TreeNode root, ArrayList<Integer> history, List<String> result) {
        history.add(root.val);

        if (root.left == null && root.right == null) {
            String s = "";
            s += history.get(0);
            for (int i = 1 ; i < history.size(); i++) {
                s += "->" + history.get(i);
            }
            result.add(s);
        }

        if (root.left != null) {
            binaryTreePathsHelper(root.left, history, result);
        }

        if (root.right != null) {
            binaryTreePathsHelper(root.right, history, result);
        }

        history.remove(history.size() - 1);
    }
}
