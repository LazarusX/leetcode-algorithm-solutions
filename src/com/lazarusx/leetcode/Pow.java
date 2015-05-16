package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/16.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(myPow(34.00515, -3));
        System.out.println(Math.pow(34.00515, -3));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == -1) {
            return 1.0 / x;
        }

        int m = n / 2;
        double k = myPow(x, m);
        if (n % 2 == 0) {
            return k * k;
        } else {
            return n > 0 ? k * k * x : k * k * (1.0 / x);
        }
    }
}
