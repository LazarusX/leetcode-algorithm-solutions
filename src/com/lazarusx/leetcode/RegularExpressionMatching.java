package com.lazarusx.leetcode;

/**
 * Created by LazarusX on 15/4/4.
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("a", ".*..a*"));
    }

    // '.' Matches any single character.
    // '*' Matches zero or more of the preceding element.
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            }

            return false;
        } else if (p.length() == 1) {
            if (s.length() == 1) {
                if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                    return true;
                }
            }

            return false;
        } else if (p.length() > 1) {
            if (p.charAt(1) == '*') {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }

                int i = 0;
                while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
                    if (isMatch(s.substring(i + 1), p.substring(2)))
                        return true;
                    i++;
                }

                return false;
            } else {
                if (s.length() == 0) {
                    return false;
                }

                if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                    return isMatch(s.substring(1), p.substring(1));
                }

                return false;
            }
        }

        return false;
    }
}
