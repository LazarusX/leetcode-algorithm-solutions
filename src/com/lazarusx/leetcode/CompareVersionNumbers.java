package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/27.
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.5", "1.5.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int i1 = i < v1.length? Integer.parseInt(v1[i]) : 0;
            int i2 = i < v2.length? Integer.parseInt(v2[i]) : 0;
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
        }

        return 0;
    }
}
