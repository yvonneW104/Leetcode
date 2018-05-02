/*
298_Binary_Tree_Longest_Consecutive_Sequence

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node 
in the tree along the parent-child connections. The longest consecutive path 
need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }
    
    public int dfs (TreeNode p, TreeNode parent, int length) {
        if (p == null)  return length;
        length = (parent != null && p.val == parent.val + 1) ? length + 1: 1;
        return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
    }
}