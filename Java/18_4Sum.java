/*
18_4Sum

Given an array nums of n integers and an integer target, are there elements 
a, b, c, and d in nums such that a + b + c + d = target? Find all unique 
quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4)    return res;
        
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int newTarget = target - nums[i] - nums[j];
                int left = j + 1;
                int right = len - 1;
                
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == newTarget) {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        res.add(l);
                    
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right])   right--;
                        left++;
                        right--;
                    } else if (sum < newTarget) left++;
                    else    right--;
                    
                }
                while (j + 1 < len - 2 && nums[j] == nums[j + 1])  j++;
            }
            while (i + 1 < len - 3 && nums[i] == nums[i + 1])  i++;
        }
        return res;
    }
}