package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/6/23.
 */
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("2-1 + 2"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = 10 * num + (s.charAt(j) - '0');
                    j++;
                }
                result += stack.pop() * num;
                i = j - 1;
            } else if (c == '+' || c == '(') {
                stack.push(stack.peek());
            } else if (c == '-') {
                stack.push(-1 * stack.peek());
            } else if (c == ')') {
                stack.pop();
            }
        }

        return result;
    }
}
