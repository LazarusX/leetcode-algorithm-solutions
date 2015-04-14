package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/4/11.
 */
public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        stack.push(x);
        if (x <= min) {
            mins.push(x);
            min = x;
        }
    }

    public void pop() {
        if (stack.pop() == min) {
            mins.pop();
            if (mins.size() > 0) {
                min = mins.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
