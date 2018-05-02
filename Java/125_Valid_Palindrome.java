/*
125_Valid_Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

*/

class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0)  return true;
        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            char c1 = s.charAt(head);
            char c2 = s.charAt(tail);
            if(!Character.isLetterOrDigit(c1))  head++;
            else if (!Character.isLetterOrDigit(c2))    tail--;
            else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
                head++;
                tail--;
            }
        }
        return true;
    }
}