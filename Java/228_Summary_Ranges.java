/*
228_Summary_Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]

Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]

*/

class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums.length == 0)
			return res;

		for (int j = 0; j < nums.length; j++) {
			int i = j;
			while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
				j++;
			if (i == j)
				res.add(nums[i] + "");
			else
				res.add(nums[i] + "->" + nums[j]);
		}
		return res;
	}
}