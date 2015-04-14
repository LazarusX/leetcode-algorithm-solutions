package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/11.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1, p2;
        if (l1.val > l2.val) {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        p1 = l1;
        p2 = l2;

        while (p2 != null) {
            if (p1.next == null || p1.next.val > p2.val) {
                ListNode temp = p1.next;
                p1.next = p2;
                p2 = p2.next;
                p1.next.next = temp;
            }
            p1 = p1.next;
        }

        return l1;
    }
}
