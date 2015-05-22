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
        int subRemaining = 0;
        int index = 0;
        for (int i = 0; i < delta.length; i++) {
            remaining += delta[i];
            subRemaining += delta[i];

            if (subRemaining < 0) {
                subRemaining = 0;
                index = i+1;
            }
        }

        if (remaining < 0) {
            return -1;
        } else {
            return index;
        }
    }
}
