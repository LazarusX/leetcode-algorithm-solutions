package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/5/16.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("[])"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char current = stack.peek();
                if (c == ')' && current != '(') {
                    return false;
                }
                if (c == ']' && current != '[') {
                    return false;
                }
                if (c == '}' && current != '{') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
