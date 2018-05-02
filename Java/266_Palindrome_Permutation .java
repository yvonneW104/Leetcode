/*
266_Palindrome_Permutation

Given a string, determine if a permutation of the string could 
form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

*/

class Solution {
    public boolean canPermutePalindrome(String s) {
        // count of each ASCII character
        int [] counts = new int[128];
        
        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i)]++;
        
        boolean single_char = false;
        for (int j = 0; j < counts.length; j++) {
            if (counts[j] % 2 != 0 && single_char)
                return false;

            // update flag
            if (counts[j] % 2 != 0)
                single_char = true;
        }
        
        return true;
    }
}