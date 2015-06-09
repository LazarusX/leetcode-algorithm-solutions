package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/9.
 */
public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-2, -2, 2, 2, -3, -3, 3, -1));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x;
        if (A == C && E == G) {
            x = 0;
        } else if ((A - E) * (A - G) <= 0 && (C - E) * (C - G) <= 0) {
            x = Math.abs(A - C);
        } else if ((E - A) * (E - C) <= 0 && (G - A) * (G - C) <= 0) {
            x = Math.abs(E - G);
        } else {
            int i = Math.max(A, C) - Math.min(E, G);
            int j = Math.max(E, G) - Math.min(A, C);
            if (i * j <= 0) {
                x = 0;
            } else {
                x = Math.min(i, j);
            }
        }

        int y;
        if (B == D || F == H) {
            y = 0;
        } else if ((B - F) * (B - H) <= 0 && (D - F) * (D - H) <= 0) {
            y = Math.abs(B - D);
        } else if ((F - B) * (F - D) <= 0 && (H - D) * (H - B) <= 0) {
            y = Math.abs(F - H);
        } else {
            int i = Math.max(B, D) - Math.min(F, H);
            int j = Math.max(F, H) - Math.min(B, D);
            if (i * j <= 0) {
                y = 0;
            } else {
                y = Math.min(i, j);
            }
        }

        return Math.abs(A - C) * Math.abs(B - D) + Math.abs(E - G) * Math.abs(F - H) - x * y;
    }
}
