/*
22_Generate_Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

class Solution {
	public List<String> generatedParenthesis (int n) {
		List<String> res = new ArrayList<String>();
		if (n <= 0) 
			return res;
		this.helper(0, 0, n, res, "");
		return res;
	}

	private void helper(int left, int right, int n, List<String> res, String sol) {
		if (left + right == n * 2)
			res.add(sol);
		if (left < n)
			this.helper(left + 1, right, n, res, sol + "(");
		if (right < left) 
			this.helper(left, right + 1, n, res, sol + ")");
	}
}