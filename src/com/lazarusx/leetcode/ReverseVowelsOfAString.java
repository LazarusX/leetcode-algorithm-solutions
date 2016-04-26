package com.lazarusx.leetcode;

import java.util.HashSet;

/**
 * Created by LazarusX on 16/4/26.
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("Hello!"));
        System.out.println(reverseVowels("Leetcode"));
        System.out.println(reverseVowels("about"));
        System.out.println(reverseVowels("rhythm"));
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] string = s.toCharArray();
        int i = 0;
        int j = string.length - 1;
        while (true) {
            while (i < string.length && !vowels.contains(string[i])) {
                i++;
            }
            while (j >= 0 && !vowels.contains(string[j])) {
                j--;
            }

            if (i < j) {
                char temp = string[j];
                string[j] = string[i];
                string[i] = temp;
            } else {
                break;
            }

            i++;
            j--;
        }

        return new String(string);
    }
}
