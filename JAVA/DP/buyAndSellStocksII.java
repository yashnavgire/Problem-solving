// Problem Link :- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
// we solve this question using valley peak approach
// means that we will buy a stock on the lowest prices and sell it at the highest price


class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        
        int i = 0, maxProfit = 0;
        
        for (i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        
        return maxProfit;
    }
}
