// Design an Iterator class, which has:

// A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
// A function next() that returns the next combination of length combinationLength in lexicographical order.
// A function hasNext() that returns True if and only if there exists a next combination.
 

// Example:

// CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

// iterator.next(); // returns "ab"
// iterator.hasNext(); // returns true
// iterator.next(); // returns "ac"
// iterator.hasNext(); // returns true
// iterator.next(); // returns "bc"
// iterator.hasNext(); // returns false
 

// Constraints:

// 1 <= combinationLength <= characters.length <= 15
// There will be at most 10^4 function calls per test.
// It's guaranteed that all calls of the function next are valid.

class CombinationIterator {
    private String characters;
    private int charLength;
    private int combinationLength;
    private Deque<String> result;
    
    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.charLength = characters.length();
        this.combinationLength = combinationLength;
        StringBuilder currString = new StringBuilder();
        this.result = new ArrayDeque<>();
        backtracking(currString, 0); 
    }
    
    public String next() {
        return result.pollLast();
    }
    
    public boolean hasNext() {
        return !result.isEmpty();
    }
    
    private void backtracking(StringBuilder currString, int startIndex) {
        if(currString.length() == combinationLength) {
            result.offerFirst(currString.toString());
            return;
        };
        
        for(int i = startIndex; i < charLength; i++) {
            // add i into the current combination
            currString.append(characters.charAt(i));
            backtracking(currString, i + 1);
            // remove most recent entry to get ready for the new one
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */