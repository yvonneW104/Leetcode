/*
231_Power_of_Two

Given an integer, write a function to determine if it 
is a power of two.

*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        //return n > 0 && Integer.bitCount(n) == 1;
        if (n <= 0) return false;
        return ((n & (n-1)) == 0);
    }
}