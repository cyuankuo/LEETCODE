// You should design a data structure that supports adding new words and finding if a string matches any previously added string.

// Implement the WordDictionary class:

// WordDictionary() Initializes the object.
// void addWord(word) adds word to the data structure, it can be matched later.
// bool search(word) returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

// Example:

// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True
 

// Constraints:

// 1 <= word.length <= 500
// word in addWord consists lower-case English letters.
// word in search consist of  '.' or lower-case English letters.
// At most 50000 calls will be made to addWord and search

class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean hasWord = false;
        TrieNode() {}
    }
    /** Initialize your data structure here. */
    TrieNode trieRoot;
    public WordDictionary() {
        this.trieRoot = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trieRoot;
        for(char element : word.toCharArray()) {
            if(!node.children.containsKey(element)) {
                node.children.put(element, new TrieNode());
            }
            node = node.children.get(element);
        }
        node.hasWord = true; // once we get to the leaf of the Trie, we indicate that this word is available
    }
    
    public boolean searchTrie(String word, TrieNode node) {
        int wordLength = word.length();
        for(int i = 0; i < wordLength; i++) {
            char currChar = word.charAt(i);
            if(!node.children.containsKey(currChar)) {
                if(currChar == '.') {
                    for(char key : node.children.keySet()) {
                        // search every children of current node to see if matches
                        if(searchTrie(word.substring(i + 1), node.children.get(key))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            else {
                node = node.children.get(currChar);
            } 
        }
        return node.hasWord;
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */    
    public boolean search(String word) {
        return searchTrie(word, trieRoot);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */