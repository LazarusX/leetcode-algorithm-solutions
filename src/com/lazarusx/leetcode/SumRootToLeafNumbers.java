package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/28.
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] sum = {0};
        sumNumbersHelper(root, 0, sum);

        return sum[0];
    }

    public static void sumNumbersHelper(TreeNode root, int current, int[] sum) {
        current = current * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum[0] += current;
        }

        if (root.left != null) {
            sumNumbersHelper(root.left, current, sum);
        }

        if (root.right != null) {
            sumNumbersHelper(root.right, current, sum);
        }
    }
}
