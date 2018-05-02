/*
400_Nth_Digit

Find the nth digit of the infinite integer sequence 
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer 
(n < 231).

Example 1:
Input:
3
Output:
3

Example 2:
Input:
11
Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 
is a 0, which is part of the number 10.

*/

class Solution {
    public int findNthDigit(int n) {
        int digit = 1;  // digit level
        long counts = 9;
        
        while (n - digit * counts > 0) {
            n -= digit * counts;
            digit++;
            counts *= 10;
        }
        // here, n means nth digits fomr the current baseNumber
        
        // base number is 1, 10, 100, 1000 ...
        int baseNumber = (int) Math.pow(10, digit - 1);
        // the number where nth digit locate
        int number = (n - 1) / digit + baseNumber;
        // find the digit where nth digit locate the number above
        int mod = (n - 1) % digit;
        return String.valueOf(number).charAt(mod) - '0';
    }
}