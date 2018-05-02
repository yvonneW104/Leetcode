/*
259_3Sum_Smaller

Given an array of n integers nums and a target, find the number of index triplets 
i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

Follow up:
Could you solve it in O(n2) runtime?
*/

class Solution {
	public int threeSumSmaller (int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++)
			count += helper(nums, i + 1, target - nums[i]);
		return count;
	}

	public int helper (int[] nums, int index, int target) {
		int sum = 0;
		int start = index;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] < target) {
				sum += end - start;
				start++;
			} else {
				end--;
			}
		}
		return sum;
	}
}