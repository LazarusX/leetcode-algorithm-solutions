package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/25.
 */
public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    // This solution exceeded time limit. I got accepted by translating it into C++.
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
