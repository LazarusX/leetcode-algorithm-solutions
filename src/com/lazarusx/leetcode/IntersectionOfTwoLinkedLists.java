package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/2.
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;

        getIntersectionNode(a1, b2);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        int lengthA = 1;
        while (pointerA.next != null) {
            pointerA = pointerA.next;
            lengthA++;
        }

        ListNode pointerB = headB;
        int lengthB = 1;
        while (pointerB.next != null) {
            pointerB = pointerB.next;
            lengthB++;
        }

        if (pointerA != pointerB) {
            return null;
        }

        int diff;
        if (lengthA < lengthB) {
            pointerA = headB;
            pointerB = headA;
            diff = lengthB - lengthA;
        } else {
            pointerA = headA;
            pointerB = headB;
            diff = lengthA - lengthB;
        }

        while (diff > 0) {
            pointerA = pointerA.next;
            diff--;
        }

        while (pointerA != pointerB) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }

        return pointerA;
    }
}
