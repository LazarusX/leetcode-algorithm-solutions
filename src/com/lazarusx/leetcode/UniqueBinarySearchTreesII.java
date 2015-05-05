package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/5/5.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        List<TreeNode> trees = generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    public static List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end) {
            trees.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = generateTreesHelper(start, i - 1);
                List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);

                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        trees.add(root);
                    }
                }
            }
        }

        return trees;
    }
}
