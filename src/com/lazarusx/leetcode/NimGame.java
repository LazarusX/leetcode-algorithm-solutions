package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/12/20.
 */
public class NimGame {
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
        System.out.println(canWinNim(5));
        System.out.println(canWinNim(6));
        System.out.println(canWinNim(7));
        System.out.println(canWinNim(8));
        System.out.println(canWinNim(1348820612));
    }

    public static boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
