package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 16/3/15.
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Utility.printLinkedList(oddEvenList(Utility.constructLinkedListFromArray(new int[]{1, 2, 3, 4})));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;

        ListNode current = head.next;
        while (current.next != null) {
            odd.next = current.next;
            odd = odd.next;
            if (current.next.next != null) {
                even.next = current.next.next;
                even = even.next;
            } else {
                break;
            }

            current = even;
        }

        even.next = null;
        odd.next = evenHead;

        return head;
    }
}
