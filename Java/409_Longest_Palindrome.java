/*
409_Longest_Palindrome

Given a string which consists of lowercase or uppercase 
letters, find the length of the longest palindromes that 
can be built with those letters.

This is case sensitive, for example "Aa" is not considered 
a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose 
length is 7.

*/

class Solution {
    public int longestPalindrome(String s) {
        int [] charcount = new int[128];
        
        for (int i = 0; i < s.length(); i++) 
            charcount[s.charAt(i)]++;
        
        boolean has_single = false;
        int count = 0;
        for (int i = 0; i < charcount.length; i++) {
            if (charcount[i] % 2 == 1) has_single = true;
            count += charcount[i] / 2;
        }
        return has_single ? count * 2 + 1 : count * 2;
    }
}