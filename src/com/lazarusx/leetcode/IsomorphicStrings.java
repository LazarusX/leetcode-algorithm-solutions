package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by LazarusX on 15/6/27.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        Hashtable<Character, Character> map1 = new Hashtable<Character, Character>();
        Hashtable<Character, Character> map2 = new Hashtable<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) {
                    return false;
                }
            } else {
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
