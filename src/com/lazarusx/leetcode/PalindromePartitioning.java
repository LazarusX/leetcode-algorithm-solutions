package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by LazarusX on 15/5/17.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        for (List<String> palindrome : result) {
            System.out.println(palindrome);
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (s == null || s.length() == 0) {
            return result;
        }

        Stack<String> current = new Stack<String>();

        partitionHelper(s, 0, current, result);

        return result;
    }

    public static void partitionHelper(String s, int begin, Stack<String> current, List<List<String>> result) {
        if (begin == s.length()) {
            result.add(new ArrayList<String>(current));
        } else {
            for (int i = begin; i < s.length(); i++) {
                if (isPalindrome(s, begin, i)) {
                    current.push(s.substring(begin, i + 1));
                    partitionHelper(s, i + 1, current, result);
                    current.pop();
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int begin, int end) {
        int mid = (begin + end) / 2;
        for (int i = begin; i <= mid; i++) {
            if (s.charAt(i) != s.charAt(begin + end - i)) {
                return false;
            }
        }

        return true;
    }
}
