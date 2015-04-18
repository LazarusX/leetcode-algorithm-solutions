package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/18.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right = new TreeLinkNode(3);
        root.right.right = new TreeLinkNode(7);
        connect(root);
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode firstOfCurrentLevel = root;

        while (firstOfCurrentLevel != null) {
            TreeLinkNode current = firstOfCurrentLevel;
            TreeLinkNode firstOfNextLevel = null;
            TreeLinkNode previousOfNextLevel = null;
            while (current != null) {
                if (current.left != null) {
                    if (previousOfNextLevel != null) {
                        previousOfNextLevel.next = current.left;
                    }
                    previousOfNextLevel = current.left;

                    if (firstOfNextLevel == null) {
                        firstOfNextLevel = current.left;
                    }
                }
                if (current.right != null) {
                    if (previousOfNextLevel != null) {
                        previousOfNextLevel.next = current.right;
                    }
                    previousOfNextLevel = current.right;

                    if (firstOfNextLevel == null) {
                        firstOfNextLevel = current.right;
                    }
                }

                current = current.next;
            }

            firstOfCurrentLevel = firstOfNextLevel;
        }
    }
}
