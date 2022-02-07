// Problem lInk :- https://leetcode.com/problems/climbing-stairs/submissions/

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            System.out.println(dp[i]);
        }
        
        return dp[n-1];
    }
}
