/*
270_Closest_Binary_Search_Tree_Value

Given a non-empty binary search tree and a target value, 
find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the 
BST that is closest to the target.

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
	public int closestValue (TreeNode root, double target) {
		int closed_val = root.val;
		while (root != null) {
			closed_val = Math.abs(root.val - taget) < Math.abs(closed_val - target) ? root.val : closed_val;
			if (closed_val == target)
				return closed_val;
			root = (root.val > targer) ? root.left : root.right;
		}
		return closed_val;
 	}
}