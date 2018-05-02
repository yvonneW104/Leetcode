/*
5_Longest_Palindromic_Substring

Given a string s, find the longest palindromic substring in s. You may assume 
that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"

*/

class Solution {
    public String longestPalindrome(String s) {
        int startIndex = 0;
        int endIndex = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(i, i + 1, s);
            int len2 = expandAroundCenter(i, i, s);
            int len = Math.max(len1, len2);
            if (len > endIndex - startIndex) {
                startIndex = i - (len - 1) / 2;
                endIndex = i + len / 2;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
    
    private int expandAroundCenter (int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1; //return the length of palindromic substring
    }
}