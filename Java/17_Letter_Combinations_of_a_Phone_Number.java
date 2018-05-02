/*
17_Letter_Combinations_of_a_Phone_Number

Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in 
any order you want.

*/

class Solution {    
    public List<String> letterCombinations(String digits) {
    	String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	List<String> res = new ArrayList<String>();
    	if (digits.length() == 0)
    		return res;
    	helper(res, "", digits, keys);
    	return res;
	}

	private void helper (List<String> res, String sol, String digits, String [] keys) {
		if (digits.length() == 0) {
			res.add(sol);
			return;
		}
		for (int i = 0; i < keys[digits.charAt(0) - '0'].length(); i++) {
			sol += keys[digits.charAt(0) - '0'].charAt(i);
            helper(res, sol, digits.substring(1), keys);
            sol = sol.substring(0, sol.length() - 1);
		}
	}
}