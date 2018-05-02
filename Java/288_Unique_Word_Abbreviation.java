/*
288_Unique_Word_Abbreviation

An abbreviation of a word follows the form <first letter><number><last letter>. 
Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is 
unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true

*/

class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = toAbbr(s);
            Set<String> words = map.containsKey(abbr) ? map.get(abbr) : new HashSet<String>();
            words.add(s);
            map.put(abbr, words);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> words = map.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }
    
    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */