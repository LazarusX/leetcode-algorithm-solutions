package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/8.
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head = deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
                slow.next = fast;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return head;
    }
}
