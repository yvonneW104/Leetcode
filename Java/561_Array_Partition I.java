/*
561_Array_Partition I

Given an array of 2n integers, your task is to group these integers into n pairs of 
integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i 
from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]
Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

*/

/*Method 1
Using sort: O(n log n)
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}

/*Method 2
Using extra array: O(n)
Map the numbers in the range -10000 <= i <= -1 onto the hashmap.

link: https://leetcode.com/problems/array-partition-i/solution/
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        int[] new_arr = new int[20001];
        int limit = 10000;
        for (int num: nums)
            new_arr[num + limit]++;
        
        int sum = 0, flag = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (new_arr[i + 10000] + 1 - flag) / 2 * i;
            flag = (2 + new_arr[i + limit] - flag) % 2;
        }
        return sum;
    }
