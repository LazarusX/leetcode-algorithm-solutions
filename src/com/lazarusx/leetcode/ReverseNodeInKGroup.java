package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/12.
 */
public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Utility.printLinkedList(reverseKGroup(head, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode nextGroup = head;

        int i = 0;
        while (nextGroup != null && i < k) {
            nextGroup = nextGroup.next;
            i++;
        }

        if (i < k) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = reverseKGroup(nextGroup, k);
        while (p2 != nextGroup) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return p1;
    }
}
