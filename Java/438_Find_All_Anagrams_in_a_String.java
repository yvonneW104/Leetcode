/*
438_Find_All_Anagrams_in_a_String

Given a string s and a non-empty string p, find all the start indices of p's anagrams 
in s.

Strings consists of lowercase English letters only and the length of both strings s 
and p will not be larger than 20,100.

The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /* run time 806ms 5% */
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || p == null || s.length() < p.length())  return res;
        
        for (int i = 0; i < s.length() - p.length() + 1; i++) {         
            if (compare(s.substring(i, i + p.length()), p))   res.add(i);
        }
        return res;
    }
    
    private boolean compare(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        int[] dict = new int[26];
        for (int i = 0; i < a.length(); i++) {
            dict[a.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < b.length(); i++) {
            dict[b.charAt(i) - 'a']--;
            if (dict[b.charAt(i)] < 0)  return false;
        }
        return true;
    }
}