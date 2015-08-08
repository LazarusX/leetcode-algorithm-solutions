package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/8/8.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> operands = new Stack<Integer>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                operands.push(operand1 + operand2);
            } else if (token.equals("-")) {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                operands.push(operand2 - operand1);
            } else if (token.equals("*")) {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                operands.push(operand1 * operand2);
            } else if (token.equals("/")) {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                operands.push(operand2 / operand1);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }

        return operands.pop();
    }
}
