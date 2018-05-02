/*
276_Paint_Fence

There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts 
have the same color.
Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

*/

class Solution {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        
        int diff_col = k * (k - 1);
        int same_col = k;
        
        for (int i = 2; i < n; i++) {
            int temp = diff_col;
            diff_col = (diff_col + same_col) * (k - 1);
            same_col = temp;
        }
        
        return diff_col + same_col;
    }
}

// dp
class Solution {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        
        int[] same = new int[n];
        int[] diff = new int[n];
        
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        
        for (int i = 2; i < n; i++) {
            same[i] = diff[i - 1];
            diff[i] = (diff[i - 1] + same[i - 1]) * (k - 1);
        }
        return same[n-1] + diff[n-1];
    }
}