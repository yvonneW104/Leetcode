/*
3_Longest_Substring_Without_Repeating_Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must 
be a substring, "pwke" is a subsequence and not a substring.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] count_char = new int[128];
        int res = 0;
        int left, right;
        
        for (left = 0, right = 0; right < n; right++) {
            left = Math.max(left, count_char[s.charAt(right)]);
            res = Math.max(res, right - left + 1);
            count_char[s.charAt(right)] = right + 1;
        }
        return res;
    }
}