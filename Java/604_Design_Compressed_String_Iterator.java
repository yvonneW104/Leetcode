/*
604_Design_Compressed_String_Iterator

Design and implement a data structure for a compressed string iterator. 
It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by 
a positive integer representing the number of this letter existing in the 
original uncompressed string.

next() - if the original string still has uncompressed characters, return 
the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, 
as static/class variables are persisted across multiple test cases. Please 
see here for more details.

Example:
StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

*/

class StringIterator {
    String s;
    int index = 0;
    int num = 0;
    char c = ' ';
    public StringIterator(String compressedString) {
        s = compressedString;
    }
    
    public char next() {
        if (!hasNext())
            return ' ';
        // move to next character
        if (num == 0) {
            c = s.charAt(index);
            index++;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
        }
        num--;
        return c;
    }
    
    public boolean hasNext() {
        return index != s.length() || num != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 