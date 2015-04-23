package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/23.
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head = removeElements(head, 6);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode current = dummy;
        while (current != null && current.next != null) {
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
