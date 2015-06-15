package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/16.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}
