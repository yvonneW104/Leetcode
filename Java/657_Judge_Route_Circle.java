/*
657_Judge_Route_Circle

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
judge if this robot makes a circle, which means it moves back to the original 
place.

The move sequence is represented by a string. And each move is represent by a 
character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true

Example 2:
Input: "LL"
Output: false
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if (n == 0)    return true;
        if (n % 2 != 0)    return false;
        
        // set the origin point
        int x = 0;
        int y = 0;
        
        // loop through each Character of the String
        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            if (c == 'U')
                y++;
            else if (c == 'D')
                y--;
            else if (c == 'L')
                x--;
            else if (c == 'R')
                x++;
        }
        
        //check whether return the origin point
        return x == 0 && y == 0;
    }
}