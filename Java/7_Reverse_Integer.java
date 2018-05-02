/*
7_Reverse_Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within 
the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, 
assume that your function returns 0 when the reversed integer overflows.

*/

class Solution {
	public int reverse (int x) {
		int res = 0;
		int temp_res = 0;
		while (x != 0) {
			temp_res = res * 10 + x % 10;
			if (temp_res / 10 != res)
				returns 0;
			res = temp_res;
			x /= 10;
		}
		return res;
	}
}