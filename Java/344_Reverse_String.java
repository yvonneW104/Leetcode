/*
344_Reverse_String

Write a function that takes a string as input and returns the string reversed.

Example:
	Given s = "hello", return "olleh".

*/

class Solution {
    public String reverseString(String s) {
        // Using char array run time ~48% 
        
        /*
        char[] word = s.toCharArray();
        for (int i = 0; i < word.length / 2; i++) {
            char temp = word[i];
            word[i] = word[word.length - i- 1];
            word[word.length - i- 1] = temp;
        }
        return new String(word);
        */
        return new StringBuilder(s).reverse().toString();
    }
}