package com.lazarusx.leetcode;

import java.util.HashMap;

/**
 * Created by LazarusX on 15/7/26.
 */
public class LRUCache {
    HashMap<Integer, Node> map;
    Node recent;
    Node leastRecent;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.recent = null;
        this.leastRecent = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node;
        if ((node = map.get(key)) != null) {
            if (recent != node) {
                if (leastRecent == node) {
                    leastRecent = node.next;
                    leastRecent.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                node.prev = recent;
                node.next = null;
                recent.next = node;
                recent = node;
            }

            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node node;
        if ((node = map.get(key)) != null) {
            if (recent != node) {
                if (leastRecent == node) {
                    leastRecent = node.next;
                    leastRecent.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                node.prev = recent;
                node.next = null;
                recent.next = node;
                recent = node;
            }

            node.value = value;
        } else {
            size++;
            if (size > capacity) {
                map.remove(leastRecent.key);
                if (leastRecent.next != null) {
                    leastRecent.next.prev = null;
                }
                leastRecent = leastRecent.next;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            newNode.prev = recent;
            newNode.next = null;
            if (recent != null) {
                recent.next = newNode;
            }
            recent = newNode;
            if (leastRecent == null) {
                leastRecent = newNode;
            }
        }
    }

    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 2);
        cache.set(3, 3);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.set(4, 4);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
