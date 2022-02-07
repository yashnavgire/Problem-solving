// Problem Link :- https://leetcode.com/problems/min-cost-climbing-stairs/submissions/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int minCost1 = solve(cost, dp, 0);
        int minCost2 = solve(cost, dp, 1);
        
        return Math.min(minCost1, minCost2);
    }
    
    public int solve(int[] cost, int[] dp, int index) {
        if (index >= cost.length) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        
        return (dp[index] = Math.min(cost[index] + solve(cost, dp, index+1), 
                       cost[index] + solve(cost, dp, index+2)));
    }
}
