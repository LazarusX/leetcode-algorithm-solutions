package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/14.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sumValue = carry;
        if (l1 != null)
            sumValue += l1.val;
        if (l2 != null)
            sumValue += l2.val;

        ListNode sum = new ListNode(sumValue % 10);
        carry = sumValue / 10;

        ListNode next = addTwoNumbers(l1 == null? null : l1.next, l2 == null? null : l2.next, carry);
        sum.next = next;

        return sum;
    }
}
