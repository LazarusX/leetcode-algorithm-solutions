package com.lazarusx.leetcode;

import java.util.HashMap;

/**
 * Created by LazarusX on 15/4/23.
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(10598542));
    }

    public static boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }

        HashMap<Integer, Boolean> records = new HashMap<Integer, Boolean>();

        return isHappyHelper(n, records);
    }

    public static boolean isHappyHelper(int n, HashMap<Integer, Boolean> records) {
        if (n == 1) {
            return true;
        }

        int sum = getSum(n);

        if (records.get(sum) != null) {
            return false;
        } else {
            records.put(sum, true);
            return isHappyHelper(sum, records);
        }
    }

    public static int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }
}
