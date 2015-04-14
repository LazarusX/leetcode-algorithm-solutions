package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/14.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if (root == null)
            return ret;

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        if (left != null) {
            for (int i: left) {
                ret.add(i);
            }
        }

        ret.add(root.val);

        if (right != null) {
            for (int i: right) {
                ret.add(i);
            }
        }

        return ret;
    }
}
