/*
459_Repeated_Substring_Pattern

Given a non-empty string check if it can be constructed by taking 
a substring of it and appending multiple copies of the substring 
together. You may assume the given string consists of lowercase 
English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring 
"abcabc" twice.)

*/

class Solution {
	public boolean repeatedSubstringPattern (String s) {
		/*
		s = a, ss = aa
		s = aa, ss = aaaa
		s = aaa, ss = aaaaaa
		*/
		String ss = s + s;
		return ss.indexOf(s, 1) < s.length();
	}
}