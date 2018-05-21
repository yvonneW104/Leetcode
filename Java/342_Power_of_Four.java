/*
342_Power_of_Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
	Given num = 16, return true. Given num = 5, return false.

*/

class Solution {
    public boolean isPowerOfFour(int num) {
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}