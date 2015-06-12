package com.lazarusx.leetcode;

import java.util.LinkedList;

/**
 * Created by LazarusX on 15/6/12.
 */
public class MyStack {
    LinkedList<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int element = queue.poll();
            queue.add(element);
        }

        queue.poll();
    }

    // Get the top element.
    public int top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            int element = queue.poll();
            queue.add(element);
        }

        int element = queue.poll();
        queue.add(element);
        return element;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
