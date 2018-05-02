/*
15_3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that 
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0)   return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right] + target;
                if (sum == 0) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(target);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    res.add(l);
                    while (left < right && nums[left] == nums[left+1])  left++;
                    while (left < right && nums[right] == nums[right-1])    right--;
                } if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i+1])    i++;
        }
        return res;
    }
}