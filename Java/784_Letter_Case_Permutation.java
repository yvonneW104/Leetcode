/*
784_Letter_Case_Permutation

Given a string S, we can transform every letter individually to be lowercase or 
uppercase to create another string.  Return a list of all possible strings we 
could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

*/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        res.add(new StringBuilder());
        
        for (char c: S.toCharArray()) {
            int n = res.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(c));
                    res.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++)
                    res.get(i).append(c);
            }
        }
        
        List<String> res_str = new ArrayList<String>();
        for (StringBuilder sb: res)
            res_str.add(sb.toString());
        return res_str;
    }
}