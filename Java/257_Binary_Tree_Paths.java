/*
257_Binary_Tree_Paths

Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:
["1->2->5", "1->3"]

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
 	public List<String> binaryTreePaths (TreeNode root) {
 		List<String> res = new ArrayList<String>();
 		if (root != null)
 			helper(root, "", res);
 		retur res;
 	}

 	 private void helper(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null)
        	res.add(path + root.val);
        if (root.left != null) 
        	helper(root.left, path + root.val + "->", res);
        if (root.right != null) 
        	helper(root.right, path + root.val + "->", res);
    }
 }