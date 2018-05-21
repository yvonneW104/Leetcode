/*
500_Keyboard_Row

Given a List of words, return the words that can be typed using letters of alphabet 
on only one row's of American keyboard like the image below.

Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

*/

class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < strs.length; i++) {
            for (char c: strs[i].toCharArray()) {
                map.put(c, i);
            }
        }
        
        List<String> l = new ArrayList<String>();
        for (String word : words) {
            if (word.equals("")) continue;
            int index = map.get(word.toUpperCase().charAt(0));
            for (char c: word.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1)
                l.add(word);
        }
        return l.toArray(new String[0]);
    }
}