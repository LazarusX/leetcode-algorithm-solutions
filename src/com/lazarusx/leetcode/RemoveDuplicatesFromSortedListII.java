package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/15.
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        Utility.printLinkedList(deleteDuplicates(
                Utility.constructLinkedListFromArray(new int[]{1, 2, 3, 3, 4, 4, 5})));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode current = dummy.next;

        while (current != null && current.next != null) {
            ListNode next = current.next;
            if (next.val != current.val) {
                pre = current;
                current = current.next;
            } else {
                while (next != null && next.val == current.val) {
                    next = next.next;
                }

                pre.next = next;
                current = next;
            }
        }

        return dummy.next;
    }
}
