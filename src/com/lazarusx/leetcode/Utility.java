package com.lazarusx.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by LazarusX on 15/6/7.
 */
public class Utility {
    public static void printIntArray(int a[]) {
        System.out.println(Arrays.toString(a));
    }

    public static void printListOfListsOfIntegers(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static void printLinkedList(ListNode head) {
        if (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print("->");
            }

            printLinkedList(head.next);
        }
    }

    public static ListNode constructLinkedListFromArray(int[] nums) {
        if (nums == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int num : nums) {
            ListNode next = new ListNode(num);
            current.next = next;
            current = next;
        }

        return dummy.next;
    }
}
