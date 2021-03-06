/*
56_Merge_Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
	class SortByStart implements Comparator<Interval> {
		@Override
		public int compare (Interval a, Interval b) {
			return (a.start < b.start) ? -1 : (a.start == b.start) ? 0 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		Collection.sort(intervals, new SortByStart());
		List<Interval> list = new LinkedList<Interval>();

		for (Interval interval : intervals) {
			if (list.isEmpty() || list.getLast().end < interval.start) 
				list.add(interval);
			else
				list.getLast().end = Math.max(list.getLast().end, interval.end);
		}
		return list;
	}
}