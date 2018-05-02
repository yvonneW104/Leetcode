/*
387_First_Unique_Character_in_a_String

Given a string, find the first non-repeating character in it and 
return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        /*
        int[26] for Letters 'a' - 'z' or 'A' - 'Z'
        int[128] for ASCII
        int[256] for Extended ASCII
        */
        
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1)   return i;
        }
        return -1;
    }
}