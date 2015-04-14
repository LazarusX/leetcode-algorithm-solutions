package com.lazarusx.leetcode;

public class ReverseInteger {

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int ret = 0;
        int xx = Math.abs(x);

        while (xx > 0) {
            if ((Integer.MAX_VALUE - xx % 10) /10 < ret)
                return 0;

            ret = ret * 10 + xx % 10;
            xx /= 10;
        }

        return ret * (x / Math.abs(x));
    }

    public static void main(String[] args) {
        System.out.println(reverse(1000000003));
    }

}
