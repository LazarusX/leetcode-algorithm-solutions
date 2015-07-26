package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/7/26.
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode list = Utility.constructLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        deleteNode(list.next.next);
        Utility.printLinkedList(list);
    }

    public static void deleteNode(ListNode node) {
        ListNode current = node;
        while (current.next.next != null) {
            current.val = current.next.val;
            current = current.next;
        }

        current.val = current.next.val;
        current.next = null;
    }
}
