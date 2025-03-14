package org.example.problems;

import java.util.HashMap;
import java.util.Map;

public class Solution{

    //https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < s.length(); i++) {
            sb.append("*").append(s.charAt(i));
        }
        sb.append("*");
        int n = sb.length();

        int centerRes = 0, leftRes = 0;

        for (int center = 1 ; center < n - 1; center++) {
            int left = 1;
            int borderMax = center * 2 < n ? center : n - center - 1;


            while (left <= borderMax && sb.charAt(center - left) == sb.charAt(center + left)) {
                left++;
            }
            if (left > leftRes) {
                centerRes = center;
                leftRes = left - 1;
            }
        }

        return sb.subSequence(centerRes-leftRes, centerRes + leftRes).toString().replace("*", "");
    }
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int medianPosition = length/2;

        if (length == 0)
            return 0;

        if (length == 1)
            return nums1.length == 0 ? nums2[0] : nums1[0];

        boolean isEven = length % 2 == 1;

        int[] nums = new int[medianPosition+1];

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length && i + j < nums.length) {
            if (nums1[i] < nums2[j]) {
                nums[i+j] = nums1[i];
                i++;
            } else {
                nums[i+j] = nums2[j];
                j++;
            }
        }

        if (i + j < nums.length) {
            if (i < nums1.length) {
                System.arraycopy(nums1, i, nums, i+j, nums.length - (i+j));
            }
            if (j < nums2.length) {
                System.arraycopy(nums2, j, nums, i+j, nums.length - (i+j));
            }
        }

        return isEven
                ? nums[medianPosition]
                :(nums[medianPosition] + nums[medianPosition - 1]) / 2.0;
    }

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
