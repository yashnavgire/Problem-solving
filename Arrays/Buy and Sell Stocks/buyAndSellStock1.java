// Problem link :- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

class Solution {
    public int maxProfit(int[] prices) {
        int max_so = 0, max_end = 0;
        
        for(int i = 1; i < prices.length; i++) {
            max_end = max_end + (prices[i] - prices[i - 1]);
            
            if (max_so < max_end) {
                max_so = max_end;
            }
            
            if (max_end < 0) {
                max_end = 0;
            }
        }
        
        return max_so;
    }
}