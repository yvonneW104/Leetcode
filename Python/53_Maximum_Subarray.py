"""
53_Maximum_Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) 
which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

"""

class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        best_sum = nums[0]
        curr_sum = 0
        for k in range(len(nums)):
            curr_sum += nums[k]
            best_sum = max(best_sum, curr_sum)
            if curr_sum < 0:
                curr_sum = 0
                
        return best_sum