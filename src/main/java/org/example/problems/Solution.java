package org.example.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution{
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/ solved in 2 hours
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> chars = new HashMap<>();
        int lengthLongest = 0, end = 0, last = 1, length = s.length();

        chars.put(s.charAt(0), 0);

        for (; last < length; last++) {
            char character = s.charAt(last);

            lengthLongest = Math.max(lengthLongest, last - end);
            if (chars.containsKey(character)) {
                end = Math.max(end, chars.put(character, last) + 1);
            } else {
                chars.put(character, last);
            }
        }
        lengthLongest = Math.max(lengthLongest, last - end);

        return lengthLongest;
    }
    /*
    2. Add Two Numbers
    * https://leetcode.com/problems/add-two-numbers/
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, false);
    }

    private ListNode add(ListNode l1, ListNode l2, boolean flg) {
        if (l1 == null && l2 == null)
            return flg ? new ListNode(1) : null;

        int val = flg ? 1 : 0;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }

        boolean flgPlus = false;
        if (val >= 10) {
            val -= 10;
            flgPlus = true;
        }

        return new ListNode(val, add(l1, l2, flgPlus));
    }
    /*
    1. Two Sum
    * https://leetcode.com/problems/two-sum/
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
