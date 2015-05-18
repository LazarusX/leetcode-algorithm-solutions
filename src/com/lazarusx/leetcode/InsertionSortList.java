package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/18.
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);
        head = insertionSortList(head);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val <= current.val) {
                pre = pre.next;
            }

            current.next = pre.next;
            pre.next = current;
            current = next;
        }

        return dummy.next;
    }
}
