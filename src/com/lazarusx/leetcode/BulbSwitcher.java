package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/12/23.
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(15));
    }

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
