package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/4/15.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> parentheses = generateParenthesis(0);
        for (String parenthesis: parentheses) {
            System.out.println(parenthesis);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        generateParenthesisHelper(n, n, "", results);

        return results;
    }

    public static void generateParenthesisHelper(int left, int right, String current,List<String> results) {
        if (left == 0 && right == 0) {
            results.add(current);
        }
        if (left > 0) {
            generateParenthesisHelper(left - 1, right, current + "(", results);
        }
        if (left < right) {
            generateParenthesisHelper(left, right - 1, current + ")", results);
        }
    }
}
