package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LazarusX on 15/8/19.
 */
public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("11-2+23"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<Integer>();
        }
        
        ArrayList<Integer> operands = new ArrayList<Integer>();
        ArrayList<Character> operators = new ArrayList<Character>();
        int current = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                current = current * 10 + input.charAt(i) - '0';
            } else {
                operands.add(current);
                current = 0;
                operators.add(input.charAt(i));
            }
        }
        operands.add(current);

        if (operands.size() != operators.size() + 1) {
            return new ArrayList<Integer>();
        }

        int operandCount = operands.size();
        ArrayList<Integer>[][] results = (ArrayList<Integer>[][])new ArrayList[operandCount][operandCount];

        // i : length of substring
        for (int i = 1; i <= operandCount; i++) {
            // j : start of substring
            for (int j = 0; j <= operandCount - i; j++) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                if (i == 1) {
                    result.add(operands.get(j));
                    results[j][j] = result;
                } else {
                    for (int k = j; k < j + i - 1; k++) {
                        for (Integer operand1 : results[j][k]) {
                            for (Integer operand2 : results[k + 1][j + i - 1]) {
                                result.add(calculate(operand1, operand2, operators.get(k)));
                            }
                        }
                    }
                    results[j][j + i - 1] = result;
                }
            }
        }

        return results[0][operandCount - 1];
    }

    public static int calculate(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                return 0;
        }
    }
}
