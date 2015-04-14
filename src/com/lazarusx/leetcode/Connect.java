package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/3/21.
 */
public class Connect {
    public static void main(String[] args) {
        connect(null);
    }

    public static void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode father = root;
        TreeLinkNode current = root.left;
        while (current != null) {
            TreeLinkNode hFather = father;
            TreeLinkNode hCurrent = current;
            while (hFather != null) {
                if (hCurrent == hFather.left) {
                    hCurrent.next = hFather.right;
                    hCurrent = hCurrent.next;
                } else if (hCurrent == hFather.right) {
                    hFather = hFather.next;
                    if (hFather == null) {
                        hCurrent.next = null;
                        break;
                    } else {
                        hCurrent.next = hFather.left;
                        hCurrent = hCurrent.next;
                    }
                }
            }
            father = current;
            current = current.left;
        }
    }
}
