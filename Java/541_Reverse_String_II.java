/*
541_Reverse_String_II

Given a string and an integer k, you need to reverse the first 
k characters for every 2k characters counting from the start of 
the string. If there are less than k characters left, reverse 
all of them. If there are less than 2k but greater than or equal 
to k characters, then reverse the first k characters and left 
the other as original.

Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

*/

class Solution {
	public String reverseStr (String s, int k) {
		char[] s_chars = s.toCharArray();
		for (int start = 0; start < s_chars.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, s_chars.length - 1);
			while (i < j) {
				char tmp = s_chars[i];
				s_chars[i++] = s_chars[j];
				s_chars[j--] = tmp;
			}
		}
		return new String(s_chars);
	}
}