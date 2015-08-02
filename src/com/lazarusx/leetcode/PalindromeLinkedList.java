package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/8/2.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        System.out.println(isPalindrome(Utility.constructLinkedListFromArray(new int[]{1, 2, 3, 2, 1})));
        System.out.println(isPalindrome(Utility.constructLinkedListFromArray(new int[]{1, 2, 2, 1})));
        System.out.println(isPalindrome(Utility.constructLinkedListFromArray(new int[]{1, 2, 2})));
    }

    public static boolean isPalindrome(ListNode head) {
        boolean[] result = new boolean[1];
        isPalindromeHelper(head, getListLength(head), result);

        return result[0];
    }

    public static ListNode isPalindromeHelper(ListNode head, int length, boolean[] result) {
        if (head == null || length == 0) {
            result[0] = true;
            return null;
        } else if (length == 1) {
            result[0] = true;
            return head.next;
        } else if (length == 2) {
            result[0] = head.val == head.next.val;
            return head.next.next;
        }

        ListNode node = isPalindromeHelper(head.next, length - 2, result);
        if (!result[0] || node == null) {
            return null;
        } else {
            result[0] = head.val == node.val;
            return node.next;
        }
    }

    public static int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
}
