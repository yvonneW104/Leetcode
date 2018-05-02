/*
110_Balanced_Binary_Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ 
by more than 1.

Example 1:
Given the following tree [3,9,20,null,null,15,7]:
    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:
Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) != -1;
    }
    
    private int height (TreeNode node) {
        if (node == null) 
            return 0;
        
        int lh = height(node.left);
        if (lh == -1)
            return -1;
        
        int rh = height(node.right);
        if (rh == -1)
            return -1;
        
        if (lh - rh < -1 || lh - rh > 1) 
            return -1;
        
        return Math.max(lh, rh) + 1;
    }
}