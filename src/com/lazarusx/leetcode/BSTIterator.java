package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/5/1.
 */
public class BSTIterator {
    TreeNode root;
    Stack<TreeNode> nodes;

    public BSTIterator(TreeNode root) {
        this.root = root;

        if (root != null) {
            this.nodes = new Stack<TreeNode>();
            buildStack(root, this.nodes);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (this.root != null && !nodes.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            return this.nodes.pop().val;
        } else {
            return 0;
        }
    }

    public void buildStack(TreeNode root, Stack<TreeNode> nodes) {
        if (root.right != null) {
            buildStack(root.right, nodes);
        }

        nodes.add(root);

        if (root.left != null) {
            buildStack(root.left, nodes);
        }
    }
}
