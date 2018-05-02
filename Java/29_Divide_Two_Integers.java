/*
29_Divide_Two_Integers

Given two integers dividend and divisor, divide two integers without using 
multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
of this problem, assume that your function returns 231 − 1 when the 
division result overflows.

*/

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)   return Integer.MAX_VALUE;
        if (divisor == 1)   return dividend;
        if (dividend == 0)  return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        
        int res = 0;
        while (x >= y) {
            int shift = 0;
            while (x >= (y << shift))   shift++;
            res += 1 << (shift - 1);
            x -= y << (shift - 1);
        }
        
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))   return res;
        else    return -1 * res;
    }
}