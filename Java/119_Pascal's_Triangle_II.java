/*
119_Pascal's_Triangle_II

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's 
triangle.

Example:
Input: 3
Output: [1,3,3,1]

*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)  return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(1);
            for (int j = res.size() - 2; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}