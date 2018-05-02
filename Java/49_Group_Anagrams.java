/*
49_Group_Anagrams

Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.


*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)   return new ArrayList<List<String>>();
        Map<String, List<String>> res = new HashMap<String, List<String>>();
        for (String s : strs) {
            char [] chararray = s.toCharArray();
            Arrays.sort(chararray);
            String key = String.valueOf(chararray);
            if (!res.containsKey(key))  res.put(key, new ArrayList<String>());
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }
    
    private boolean isAnagram (String a, String b) {
        char[] charcount = new char[26];
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            charcount[c - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            char c = a.charAt(i);
            charcount[c - 'a']--;
            if (charcount[c - 'a'] < 0) return false;
        }
        return true;
    }
}