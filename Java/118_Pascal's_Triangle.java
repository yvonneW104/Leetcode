/*
118_Pascal's_Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0)   return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>(1);
        
        for (int i = 1; i <= numRows; i++) {
            l.add(1);
            for (int j = l.size() - 2; j > 0; j--) {
                l.set(j, l.get(j) + l.get(j-1));
            }
            res.add(new ArrayList<Integer>(l));
        }
        return res;
    }
}