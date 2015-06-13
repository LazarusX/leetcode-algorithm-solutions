package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/6/13.
 */
class TrieNode {
    TrieNode[] children;

    // Initialize your data structure here.
    public TrieNode() {
        // 26 lower case letters and the last node indicates end of word
        children = new TrieNode[27];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = current.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new TrieNode();
                current.children[word.charAt(i) - 'a'] = child;
            }
            current = child;
        }
        current.children[26] = new TrieNode();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = current.children[word.charAt(i) - 'a'];
            if (child == null) {
                return false;
            }
            current = child;
        }

        return current.children[26] != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode child = current.children[prefix.charAt(i) - 'a'];
            if (child == null) {
                return false;
            }
            current = child;
        }

        return true;
    }
}
