package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/15.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 4, 3, 5});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        return buildTreeHelper(preorder, inorder, 0, 0, preorder.length);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                           int startIndexInPreorder, int startIndexInInorder, int length) {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            return new TreeNode(preorder[startIndexInPreorder]);
        }

        int rootValue = preorder[startIndexInPreorder];

        int rootOffsetInInorder;
        for (rootOffsetInInorder = 0;
             rootOffsetInInorder < length;
             rootOffsetInInorder++) {
            if (inorder[rootOffsetInInorder + startIndexInInorder] == rootValue) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeHelper(preorder, inorder,
                startIndexInPreorder + 1, startIndexInInorder,
                rootOffsetInInorder);
        root.right = buildTreeHelper(preorder, inorder,
                startIndexInPreorder + rootOffsetInInorder + 1, startIndexInInorder + rootOffsetInInorder + 1,
                length - rootOffsetInInorder - 1);

        return root;
    }
}
