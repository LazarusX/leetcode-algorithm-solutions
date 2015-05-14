package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/15.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{2, 1, 4, 3, 5}, new int[]{2, 4, 5, 3, 1});
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null
                || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }

        return buildTreeHelper(inorder, postorder, 0, 0, inorder.length);
    }

    public static TreeNode buildTreeHelper(int[] inorder, int[] postorder,
                                    int startIndexInInorder, int startIndexInPostorder, int length) {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            return new TreeNode(inorder[startIndexInInorder]);
        }

        int rootValue = postorder[startIndexInPostorder + length - 1];

        int rootOffsetInInorder;
        for (rootOffsetInInorder = 0;
             rootOffsetInInorder < length;
             rootOffsetInInorder++) {
            if (inorder[rootOffsetInInorder + startIndexInInorder] == rootValue) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeHelper(inorder, postorder,
                startIndexInInorder, startIndexInPostorder,
                rootOffsetInInorder);
        root.right = buildTreeHelper(inorder, postorder,
                startIndexInInorder + rootOffsetInInorder + 1, rootOffsetInInorder + startIndexInPostorder,
                length - rootOffsetInInorder - 1);

        return root;
    }
}
