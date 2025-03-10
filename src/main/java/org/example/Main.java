package org.example;

import org.example.problems.Solution;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        testcase3();
        testcase4();
    }

    private static void testcase4() {
        test4(array(0,0,0,0,0), array(-1,0,0,0,0,0,1), 0);
        test4(array(1, 2, 3, 4), array(), 2.5);
    }

    private static int[] array(int ...arr) {
        return arr;
    }

    private static void test4(int[] list, int[] list1, double v) {
        Solution solution = new Solution();
        double actual = solution.findMedianSortedArrays(list1, list);
        if (actual != v) {
            throw new AssertionError("Expected: " + v + ", but got: " + solution.findMedianSortedArrays(list1, list));
        }
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