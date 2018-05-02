/*
758_Bold_Words_in_String

Given a set of keywords words and a string S, make all appearances 
of all keywords in S bold. Any letters between <b> and </b> tags 
become bold.

The returned string should use the least number of tags possible, 
and of course the tags should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we 
should return "a<b>abc</b>d". Note that returning 
"a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Note:
	1. words has length in range [0, 50].
	2. words[i] has length in range [1, 10].
	3. S has length in range [0, 500].
	4. All characters in words[i] and S are lowercase letters.

*/

class Solution {
    public String boldWords(String[] words, String S) {
        if (words.length == 0)
            return "";
        boolean[] mark = new boolean[S.length()];
        for (String w : words) 
            markword (S, w, mark);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (mark[i] && (i == 0 || !mark[i - 1]))
                sb.append("<b>");
            sb.append(S.charAt(i));
            if (mark[i] && (i == S.length() - 1 || !mark[i + 1]))
                sb.append("</b>");
        }
        return sb.toString();
    }
    
    private void markword (String S, String w, boolean[] mark) {
        for (int i = 0; i <= S.length() - w.length(); i++) {
            String substr = S.substring(i, i + w.length());
            if (substr.equals(w)) {
                for (int j = i; j < i + w.length(); j++) 
                    mark[j] = true;
            }
        }
    }
}
