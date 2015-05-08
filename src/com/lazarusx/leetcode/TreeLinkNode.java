package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/3/21.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
