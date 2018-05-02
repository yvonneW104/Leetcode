/*
501_Find_Mode_in_Binary_Search_Tree

Given a binary search tree (BST) with duplicates, find all the 
mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:
1. The left subtree of a node contains only nodes with keys less than 
or equal to the node's key.
2. The right subtree of a node contains only nodes with keys greater 
than or equal to the node's key.
3. Both the left and right subtrees must also be binary search trees.

For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that 
the implicit stack space incurred due to recursion does not count).
*/

class Solution {
	int max = 0;
	Map<Integer, Integer> map;

	public int[] findMode (TreeNode root) {
		if (root == null)	return new int[0];
		map = new HashMap<Integer, Integer>();
		helper(root);

		// use list to save all node that occurance "max" times
		List<Integer> list = new ArrayList<Integer>();
		for (int key: map.keySet())
			if (map.get(key) == max)
				list.add(key);

		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = list.get(i);

		return res;

	}

	// use map to save the occurance of each node
	public void helper (TreeNode node) {
		if (node.left != null)
			helper(node.left);
		map.put(node.val, map.getOrDefault(node.val, 0) + 1);
		max = Math.max(max, map.get(node.val));
		if (node.right != null)
			helper(node.right);
	}
}