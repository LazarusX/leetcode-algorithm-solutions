package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/20.
 */
public class CountAndSay {
    public static void main(String[] args) {
        for (int i = 1; i <= 18; i++) {
            System.out.println(countAndSay(i));
        }
    }

    public static String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        String current = "1";

        for (int i = 1; i < n; i++) {
            String previous = current;
            current = "";
            for (int j = 0; j < previous.length(); j++) {
                int count = 1;
                char digit = previous.charAt(j);
                while (j + 1 < previous.length() && previous.charAt(j + 1) == digit) {
                    count++;
                    j++;
                }
                current += "" + count + digit;
            }
        }
        
        return current;
    }
}
