/*
6_ZigZag_Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

*/

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1)    return s;
        
        int n = s.length();
        int step = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numRows; i++) {
            for (int j = i; j < n; j += step) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && j + step - 2 * i < n)
                    sb.append(s.charAt(j + step - 2 * i));
            }
        }
        return sb.toString();
    }
}