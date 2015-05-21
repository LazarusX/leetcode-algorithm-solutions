package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/21.
 */
public class GasStation {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{6, 1, 4, 3, 5}, new int[]{3, 8, 2, 4, 2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length || gas.length == 0) {
            return -1;
        }

        if (gas.length == 1) {
            return gas[0] - cost[0] >= 0 ? 0 : -1;
        }
        
        int[] delta = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            delta[i] = gas[i] - cost[i];
        }

        int remaining = 0;
        for (int i : delta) {
            remaining += i;
        }

        if (remaining < 0) {
            return -1;
        }

        int index = -1;
        int min = 0;
        for (int i = 1; i < delta.length; i++) {
            if (delta[i - 1] < 0 && delta[i] >= 0 && delta[i - 1] < min) {
                index = i;
                min = delta[i - 1];
            }
        }

        if (delta[delta.length - 1] < 0 && delta[0] >= 0 && delta[delta.length - 1] < min) {
            index = 0;
        }

        return index;
    }
}
