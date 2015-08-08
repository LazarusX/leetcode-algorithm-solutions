package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/8.
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  the  sky is blue  "));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = new char[s.length()];
        int realLength = 0;
        boolean isPreviousWhiteSpace = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                isPreviousWhiteSpace = true;
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                i--;
            } else {
                if (isPreviousWhiteSpace && realLength != 0) {
                    chars[realLength] = ' ';
                    realLength++;
                }
                isPreviousWhiteSpace = false;
                chars[realLength] = s.charAt(i);
                realLength++;
            }
        }

        swapChars(chars, 0, realLength - 1);

        for (int i = 0; i < realLength; i++) {
            int j = i;
            while (j < realLength && chars[j] != ' ') {
                j++;
            }
            j--;
            swapChars(chars, i, j);
            i = j + 1;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < realLength; i++) {
            output.append(chars[i]);
        }

        return output.toString();
    }

    public static void swapChars(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
