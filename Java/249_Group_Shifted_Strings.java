/*
249_Group_Shifted_Strings

Given a string, we can "shift" each of its letter to its successive letter, 
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all 
strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

*/

class Solution {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strings) {
			int offset = s.charAt(0) - 'a';
			String key = "";
			for (int i = 0; i < s.length(); i++) {
				char c = (char) (s.charAt(i) - offset);
				if (c < 'a')
					a += 26;
				key += c;
			}
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}

		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			res.add(list);
		}
		return res;
	}
}