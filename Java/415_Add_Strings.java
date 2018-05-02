/*
415_Add_Strings

Given two non-negative integers num1 and num2 represented 
as string, return the sum of num1 and num2.

Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert 
the inputs to integer directly.

*/

class Solution {
	public String addStrings (String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carryout = 0;
		int n1 = num1.length();
		int n2 = num2.length();

		for (int i = n1 - 1, j = n2 - 2; i >= 0 || j >= 0 || carryout > 0; i--, j--) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = x + y + carryout;
			carryout = sum / 10;
			sb.append(sum % 10);
		}

		return sb.reverse().toString();
	}
}