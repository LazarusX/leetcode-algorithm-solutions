package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/14.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if (root == null)
            return ret;

        ret.add(root.val);

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        if (left != null) {
            for (int i: left) {
                ret.add(i);
            }
        }

        if (right != null) {
            for (int i: right) {
                ret.add(i);
            }
        }

        return ret;
    }
}
