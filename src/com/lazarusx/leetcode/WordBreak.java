package com.lazarusx.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LazarusX on 15/7/19.
 */
public class WordBreak {
    public static void main(String[] args) {
        HashSet<String> wordDict = new HashSet<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcodeleet", wordDict));
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        int length = s.length();
        boolean[][] flags = new boolean[length][length];
        for (String word : wordDict) {
            int index = s.indexOf(word);
            while (index >= 0 && index < s.length()) {
                flags[index][word.length() - 1] = true;
                index = s.indexOf(word, index + 1);
            }
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < length - i; j++) {
                boolean result = flags[j][i];
                for (int k = 0; k < i && !result; k++) {
                    result = flags[j][k] && flags[j + k + 1][i - k - 1];
                }
                flags[j][i] = result;
            }
        }

        return flags[0][length - 1];
    }
}
