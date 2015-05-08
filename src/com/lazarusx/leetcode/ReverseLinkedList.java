package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/8.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = null;

        while (p2 != null) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }
}
