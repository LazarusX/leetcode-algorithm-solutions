package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by LazarusX on 15/4/15.
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = postorderTraversal(root);
        for (Integer val: result) {
            System.out.println(val);
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        TreeNode previous = null;
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    nodes.push(current.left);
                } else if (current.right != null) {
                    nodes.push(current.right);
                } else {
                    result.add(current.val);
                    nodes.pop();
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    nodes.push(current.right);
                } else {
                    result.add(current.val);
                    nodes.pop();
                }
            } else if (current.right == previous) {
                result.add(current.val);
                nodes.pop();
            }
            previous = current;
        }

        return result;
    }

    public static List<Integer> postorderTraversalRecursively(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        left.addAll(right);
        left.add(root.val);

        return left;
    }
}
