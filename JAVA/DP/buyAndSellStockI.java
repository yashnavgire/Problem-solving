// Problem Link :- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, max = 0, maxE = Integer.MIN_VALUE, minE = Integer.MAX_VALUE;
        
        for (i = 0; i < prices.length; i++) {
            
            if (prices[i] > maxE) {
                maxE = prices[i];
            }
            
            if (prices[i] < minE) {
                minE = prices[i];
                maxE = 0;
            }
            
            max = Math.max(max, maxE-minE);
        }
        
        return (max > 0 ? max : 0); 
        
    }
}
