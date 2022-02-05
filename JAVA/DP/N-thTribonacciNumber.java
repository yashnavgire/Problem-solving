// Problem Link :- https://leetcode.com/problems/n-th-tribonacci-number/submissions/

class Solution {
    int[] dp;
    int MAX_LEN = 38;
    
    public Solution() {
        int i = 0;
        dp = new int[MAX_LEN];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for (i = 3; i < MAX_LEN; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
    }
    
    public int tribonacci(int n) {
        return dp[n];    
    }
}
