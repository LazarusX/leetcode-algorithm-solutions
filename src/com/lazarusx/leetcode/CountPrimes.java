package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/27.
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(1000000));
    }

    public static int countPrimes(int n) {
        boolean[] status = new boolean[n];
        for (int i = 2; i < n; i++) {
            status[i] = true;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (status[i]) {
                count++;
                int temp = i + i;
                while (temp < n) {
                    status[temp] = false;
                    temp += i;
                }
            }
        }

        return count;
    }
}
