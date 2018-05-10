/*
242_Valid_Anagram

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
Note:
	You may assume the string contains only lowercase alphabets.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())   return false;
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            charCount[t.charAt(i) - 'a']--;
            if (charCount[t.charAt(i) - 'a'] < 0)   return false;
        }
        return true;
    }
}
