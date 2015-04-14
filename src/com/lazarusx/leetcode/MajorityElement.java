package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/7.
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] num) {
        int x = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == x) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                x = num[i];
                count = 1;
            }
        }

        return x;
    }
}
