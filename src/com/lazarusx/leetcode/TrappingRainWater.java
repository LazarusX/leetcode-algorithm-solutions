package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/27.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {5, 4, 1, 2};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int water = 0;
        int max = height[0];
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        maxL[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxL[i] = max;
            if (max < height[i]) {
                max = height[i];
            }
        }

        max = height[height.length - 1];
        maxR[height.length - 1] = max;
        for (int i = height.length - 1; i >= 0; i--) {
            maxR[i] = max;

            int temp = Math.min(maxL[i], maxR[i]) - height[i];
            if (temp > 0) {
                water += temp;
            }

            if (max < height[i]) {
                max = height[i];
            }
        }

        return water;
    }
}
