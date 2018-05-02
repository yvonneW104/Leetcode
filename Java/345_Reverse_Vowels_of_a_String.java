/*
345_Reverse_Vowels_of_a_String

Write a function that takes a string as input and reverse 
only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

*/

class Solution {
	public String reverseVowels(String s){
		if (s.length() == 0)	return "";
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();

		int left = 0;
		int right = chars.length - 1;

		while (left < right) {
			// find the nth left vowel
			if (left < right && !vowels.contians(chars[left]+""))
				left++;
			// find the nth right vowel
			if (left < right && !vowels.contains(chars[right]+""))
				right--;

			// swap characters
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			
			// update index
			left++;
			right--;
		}
		return new String(chars);
	}
}