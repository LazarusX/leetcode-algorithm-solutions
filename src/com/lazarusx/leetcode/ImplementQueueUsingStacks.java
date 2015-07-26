package com.lazarusx.leetcode;

import java.util.Stack;

/**
 * Created by LazarusX on 15/7/26.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    boolean isLifoOrder = true;

    // Push element x to the back of queue.
    public void push(int x) {
        if (!isLifoOrder) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            isLifoOrder = true;
        }

        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (isLifoOrder) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            isLifoOrder = false;
        }

        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (isLifoOrder) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            isLifoOrder = false;
        }

        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
