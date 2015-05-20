package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/5/20.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("233f"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] chars = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            chars[i] = convertDigitToChars(digits.charAt(i));
        }

        letterCombinationsHelper(chars, "", result, 0);

        return result;
    }

    public static void letterCombinationsHelper(String[] chars, String current, List<String> result, int i) {
        if (i == chars.length) {
            result.add(current);
        } else if (chars[i].length() > 0){
            for (int j = 0; j < chars[i].length(); j++) {
                current += chars[i].charAt(j);
                letterCombinationsHelper(chars, current, result, i + 1);
                current = current.substring(0, current.length() - 1);
            }
        } else {
            letterCombinationsHelper(chars, current, result, i + 1);
        }
    }

    public static String convertDigitToChars(char digit) {
        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
