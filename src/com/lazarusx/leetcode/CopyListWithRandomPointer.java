package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/16.
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode current = head;
        RandomListNode headCopy = null;
        RandomListNode currentCopy;

        while (current != null) {
            currentCopy = new RandomListNode(current.label);
            if (headCopy == null) {
                headCopy = currentCopy;
            }
            currentCopy.next = current.next;
            current.next = currentCopy;
            current = current.next.next;
        }

        current = head;
        currentCopy = headCopy;
        while (current != null) {
            if (current.random != null) {
                currentCopy.random = current.random.next;
            }
            current = current.next.next;
            if (currentCopy.next != null) {
                currentCopy = currentCopy.next.next;
            }
        }

        current = head;
        currentCopy = headCopy;
        while (current != null) {
            current.next = current.next.next;
            if (currentCopy.next != null) {
                currentCopy.next = currentCopy.next.next;
            }
            current = current.next;
            currentCopy = currentCopy.next;
        }

        return headCopy;
    }
}
