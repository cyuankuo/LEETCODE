// Say you have an array for which the i-th element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most k transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

// Example 1:

// Input: [2,4,1], k = 2
// Output: 2
// Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
// Example 2:

// Input: [3,2,6,5,0,3], k = 2
// Output: 7
// Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
//              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) { // if k >= n/2, then you can make maximum number of transactions
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            return profit;
        }
        
        int[] holdArr = new int[k];
        int[] soldArr = new int[k];
        int result = 0;
        for(int i = 0; i < holdArr.length; i++) {
            holdArr[i] = Integer.MIN_VALUE;
        }
        
        for(int price : prices) {
            holdArr[0] = Math.max(holdArr[0], - price);
            soldArr[0] = Math.max(soldArr[0], holdArr[0] + price);
            for(int i = 1; i < holdArr.length; i++) {
                holdArr[i] = Math.max(holdArr[i], soldArr[i - 1] - price);
                soldArr[i] = Math.max(soldArr[i], holdArr[i] + price);
            }
        }
        for(int sold : soldArr) {
            result = Math.max(sold, result);
        }
        return result;
    }
}