/*
347_Top_K_Frequent_Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	Your algorithm's time complexity must be better than O(n log n), 
	where n is the array's size.

*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) 
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        
        List<Integer>[] count = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (count[frequency] == null) 
                count[frequency] = new ArrayList<>();
            count[frequency].add(key);
        }
        
        for (int i = count.length - 1; i >= 0 && res.size() < k; i--) {
            if (count[i] != null)
                res.addAll(count[i]);
        }
        
        return res;
    }
}