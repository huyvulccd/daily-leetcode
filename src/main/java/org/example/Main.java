package org.example;

import org.example.problems.Solution;

public class Main {
    public static void main(String[] args) {
        testcase3();
    }

    private static void testcase3 () {
        test3("abcabcbb", 3);
        test3("pwwkew", 3);
        test3("", 0);
        test3("b", 1);
        test3("bb", 1);
        test3("bbbbb", 1);
        test3("01", 2);
        test3("abba", 2);

    }
    private static void test3 (String input, int expected) {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring(input);
        if (actual != expected) {
            System.out.println(input);
            throw new AssertionError("Expected: " + expected + ", but got: " + solution.lengthOfLongestSubstring(input));
        }
    }
}