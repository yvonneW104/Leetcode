/*
643_Maximum_Average_Subarray_I

Given an array consisting of n integers, find the contiguous 
subarray of given length k that has the maximum average value. 
And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

Note:
1. 1 <= k <= n <= 30,000.
2. Elements of the given array will be in the range [-10,000, 10,000].

*/

class Solution {
	public double findMaxAverage (int[] nums, int k) {
		int sum = 0;

		// get the sum of first k num
		for (int i = 0; i < k; i++) 
			sum += nums[i];

		int max = sum;
		for (int i = 1; i < nums.length - k + 1; i++) {
			sum = sum - nums[i - 1] + nums[i + k - 1];
			max = Math.max(max, sum);
		}

		return (double) max / k;
	}
}