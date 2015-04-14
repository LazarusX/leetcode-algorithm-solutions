package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/13.
 */
public class GrayCode {
    public static void main(String[] args) {
        List<Integer> sequence = grayCode(3);
        for (Integer value : sequence) {
            System.out.println(value);
        }
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        sequence.add(0);

        for (int i = 0; i < n; i++) {
            int size = sequence.size();
            for (int j = size - 1; j >= 0; j--) {
                sequence.add(sequence.get(j) + size);
            }
        }

        return sequence;
    }
}
