// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// Example 1:

// Input: "3+2*2"
// Output: 7
// Example 2:

// Input: " 3/2 "
// Output: 1
// Example 3:

// Input: " 3+5 / 2 "
// Output: 5
// Note:

// You may assume that the given expression is always valid.
// Do not use the eval built-in library function.

class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int length = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int num = 0;
        int result = 0;
        for(int i = 0; i < length; i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = 10 * num + (s.charAt(i) - '0');
            }
             if (!Character.isDigit(s.charAt(i)) || i == length - 1){
                if(sign == '+') {
                    stack.offerLast(num);
                }
                else if(sign == '-') {
                    stack.offerLast(-num);
                }
                else if(sign == '*') {
                    stack.offerLast(stack.pollLast() * num);
                }
                else if(sign == '/') {
                    stack.offerLast(stack.pollLast() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        for(int number : stack) {
            result += number;
        }
        return result;
    }
}