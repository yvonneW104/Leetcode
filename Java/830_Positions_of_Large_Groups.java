/*
830_Positions_of_Large_Groups

In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions
of every large group.

The final answer should be in lexicographic order.


Example 1:
Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.

Example 2:
Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.

Example 3:
Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]

Note:  1 <= S.length <= 1000
*/

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = S.length();
        if (n < 3) return res;
        
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (j == n - 1 || S.charAt(j) != S.charAt(j + 1)) {
                if (j - i + 1 >= 3)
                    res.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }
        return res;
    }
}