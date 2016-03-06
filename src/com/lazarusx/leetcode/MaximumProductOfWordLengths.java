package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 16/3/6.
 */
public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};

        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }

        int[] ints = convertStringsToInts(words);

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((ints[i] & ints[j]) == 0 && (words[i].length() * words[j].length() > max)) {
                    max = words[i].length() * words[j].length();
                }
            }
        }

        return max;
    }

    public static int[] convertStringsToInts(String[] words) {
        int[] ret = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                ret[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        return ret;
    }
}
