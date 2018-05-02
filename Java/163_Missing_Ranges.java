/*
163_Missing_Ranges

Given a sorted integer array nums, where the range of elements are in the inclusive 
range [lower, upper], return its missing ranges.

Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*/

class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();
		long low = (long) lower;
		long high = (long) lower;

		for (int i = 0; i <= nums.length; i++) {
			low = i == 0 ? low : (long) nums[i - 1] + 1;
			high = i == nums.length ? (long) upper : (long) nums[i] - 1;
			if (low == high)
				res.add(low + "");
			if (low < high)
				res.add(low + "->" + high);
		}
		return res;
	}
}