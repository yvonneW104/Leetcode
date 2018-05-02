/*
67_Add_Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carryout = 0;
        int x, y, sum;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            y = (j >= 0) ? b.charAt(j--) - '0' : 0;
            sum = x + y + carryout;
            sb.append(sum % 2);
            carryout = sum / 2;
        }
        if (carryout != 0)  sb.append(carryout);
        return sb.reverse().toString();
    }
}