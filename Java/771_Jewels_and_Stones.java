/*
771_Jewels_and_Stones

You're given strings J representing the types of stones that are jewels, and S 
representing the stones you have.  Each character in S is a type of stone you have.  
You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. 
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0

*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        int [] charcount = new int[58];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            charcount[c - 'A']++;
        }
        
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            if (charcount[c - 'A'] > 0) {
                count += charcount[c - 'A'];
                charcount[c - 'A'] = 0;
            }
        }
        return count;
    }
}