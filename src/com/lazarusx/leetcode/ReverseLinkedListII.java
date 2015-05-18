package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/18.
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode left = dummy;
        for (int i = 0; i < m - 1; i++) {
            left = left.next;
        }

        ListNode right = dummy;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        ListNode p1 = left.next;
        ListNode p2 = left.next.next;
        p1.next = right.next;

        int diff = n - m;
        while (diff > 0) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            diff--;
        }

        left.next = p1;

        return dummy.next;
    }
}
