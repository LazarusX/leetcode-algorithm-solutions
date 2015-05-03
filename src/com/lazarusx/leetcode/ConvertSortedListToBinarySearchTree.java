package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/5/2.
 */
public class ConvertSortedListToBinarySearchTree {
    static ListNode currentHead = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);

        TreeNode root = sortedListToBST(head);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode p = head;

        while (p != null) {
            length++;
            p = p.next;
        }

        currentHead = head;

        return sortedListToBST(0, length - 1);
    }

    public static TreeNode sortedListToBST(int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;

        TreeNode leftNode = sortedListToBST(left, mid - 1);
        TreeNode root = new TreeNode(currentHead.val);
        currentHead = currentHead.next;
        TreeNode rightNode = sortedListToBST(mid + 1, right);

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
