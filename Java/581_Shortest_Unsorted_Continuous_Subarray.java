/*
581_Shortest_Unsorted_Continuous_Subarray

Given an integer array, you need to find one continuous subarray that 
if you only sort this subarray in ascending order, then the whole 
array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to 
make the whole array sorted in ascending order.

Note:
1. Then length of the input array is in range [1, 10,000].
2. The input array may contain duplicates, so ascending order here 
means <=.

*/

class Solution {
	public int findUnsortedSubarray (int[] nums) {
		int[] sorted_nums = nums.clone();
		Array.sort(sorted_nums);
		int start = sorted_nums.length, end = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != sorted_nums[i]) {
				start = Math.min(start, i);
				end = Math.min(end, i);
			}
		}
		return end - start >= 0 ? end - start + 1 : 0;
	}
}
