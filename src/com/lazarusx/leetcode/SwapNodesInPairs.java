package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/14.
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = current.next.next;
        head = current.next;
        head.next = current;
        current.next = next;

        ListNode previous = current;
        current = current.next;
        while (current != null && current.next != null) {
            next = current.next.next;
            previous.next = current.next;
            previous.next.next = current;
            current.next = next;
            previous = current;
            current = current.next;
        }

        return head;
    }
}
