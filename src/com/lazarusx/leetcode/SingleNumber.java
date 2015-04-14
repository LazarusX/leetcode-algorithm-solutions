package com.lazarusx.leetcode;

public class SingleNumber {

    public static int singleNumber(int[] A) {
        int x = 0;

        for (int i:A) {
            x = x ^ i;
        }

        return x;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 4, 3, 3, 2, 5};
        System.out.println(singleNumber(a));
    }

}
