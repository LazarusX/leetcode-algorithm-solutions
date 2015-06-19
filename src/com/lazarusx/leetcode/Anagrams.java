package com.lazarusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by LazarusX on 15/6/19.
 */
public class Anagrams {
    public static void main(String[] args) {
        System.out.println(anagrams(new String[]{"tea", "and", "ate", "eat", "dan"}));
    }

    public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();

        if (strs == null || strs.length < 2) {
            return result;
        }

        Hashtable<String, ArrayList<String>> map = new Hashtable<String, ArrayList<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                ArrayList<String> entry = new ArrayList<String>();
                entry.add(str);
                map.put(sorted, entry);
            }
        }

        for (ArrayList<String> entry : map.values()) {
            if (entry.size() > 1) {
                result.addAll(entry);
            }
        }

        return result;
    }
}
