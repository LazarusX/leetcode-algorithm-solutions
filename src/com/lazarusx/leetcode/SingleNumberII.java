package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/7.
 */
public class SingleNumberII {
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] A) {
        int one = 0, two = 0;
        for (int i = 0; i < A.length; i++) {
            two |= A[i] & one;//two 积累值
            one ^= A[i];//one不断求反
            int t = one & two;//第三次的时候one和two都保留了该位的值
            one &= ~t;//清零出现三次的该位的值
            two &= ~t;
        }
        return one;
    }
}
