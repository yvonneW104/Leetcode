/*
506_Relative_Ranks

Given scores of N athletes, find their relative ranks and 
the people with the top three highest scores, who will be 
awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest 
scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative 
ranks according to their scores.

Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

*/

// map
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        String [] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        
        Arrays.sort(nums);
        
        int count = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1)
                res[map.get(nums[i])] = "Gold Medal";
            else if (i == nums.length - 2)
                res[map.get(nums[i])] = "Silver Medal";
            else if (i == nums.length - 3)
                res[map.get(nums[i])] = "Bronze Medal";
            else 
                res[map.get(nums[i])] = count + "";
            count++;
        }
        
        return res;
    }
}

// sorting
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) 
            index[i] = i;
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        String [] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                res[index[i]] = "Gold Medal";
            else if (i == 1)
                res[index[i]] = "Silver Medal";
            else if (i == 2)
                res[index[i]] = "Bronze Medal";
            else
                res[index[i]] = (i + 1) + "";
        }
        return res;
    }
}