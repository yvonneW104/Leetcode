/*
34_Search_for_a_Range

Given an array of integers nums sorted in ascending order, find the starting 
and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
        if (nums == null || nums.length == 0)   return res;
        
        int left = findStartIndex(nums, target, 0, nums.length - 1);
        if (left == -1) return res;
        int right = findEndIndex(nums, target, 0, nums.length - 1);
        res[0] = left;
        res[1] = right;
        return res;
    }
    
    private int findStartIndex (int[] nums, int target, int left, int right) {
        if (left > right)   return -1;
        int mid = (left + right) / 2;
        if (target < nums[mid]) return findStartIndex(nums, target, left, mid - 1);
        else if (target > nums[mid])    return findStartIndex(nums,target, mid + 1, right);
        else {
            if (mid == 0 || nums[mid - 1] != target)    return mid;
            return findStartIndex(nums, target, left, mid - 1);
        }
    }
    
    private int findEndIndex (int[] nums, int target, int left, int right) {
        if (left > right)   return -1;
        int mid = (left + right) / 2;
        if (target < nums[mid]) return findEndIndex(nums, target, left, mid - 1);
        else if (target > nums[mid])    return findEndIndex(nums, target, mid + 1, right);
        else {
            if (mid == nums.length - 1 || nums[mid + 1] != target)  return mid;
            return findEndIndex(nums, target, mid + 1, right);
        }
    }
}