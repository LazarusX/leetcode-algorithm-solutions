package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/6.
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head = partition(head, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode endOfSmallList = dummy;
        while (endOfSmallList.next != null && endOfSmallList.next.val < x) {
            endOfSmallList = endOfSmallList.next;
        }

        ListNode current = endOfSmallList.next;
        while (current != null && current.next != null) {
            if (current.next.val < x) {
                ListNode temp = current.next.next;
                current.next.next = endOfSmallList.next;
                endOfSmallList.next = current.next;
                endOfSmallList = current.next;
                current.next = temp;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
