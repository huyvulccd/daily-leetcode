package org.example;

import org.example.problems.Solution;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        test5(solution);
    }

    private static void test5(Solution solution) {
        System.out.println(solution.longestPalindrome("ababa"));
        System.out.println(solution.longestPalindrome("aa"));
        System.out.println(solution.longestPalindrome("ab"));
        System.out.println(solution.longestPalindrome("a"));
//        System.out.println(solution.longestPalindrome("123432432478753"));
//        System.out.println(solution.longestPalindrome("123432432478753"));
//        System.out.println(solution.longestPalindrome("123243247875323432"));
//        System.out.println(solution.longestPalindrome(""));
    }

    private static void equal(String output) {
        System.out.println("Test passed: " + output);
    }
}