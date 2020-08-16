// Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

// Example 1:

// Input: "aba"
// Output: True
// Example 2:

// Input: "abca"
// Output: True
// Explanation: You could delete the character 'c'.
// Note:

// The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

class Solution {
    private boolean isPalindrome(String s, int from, int to) {
        while(from < to) {
            if(s.charAt(from) != s.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }
}