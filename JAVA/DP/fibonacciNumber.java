// Problem Link :- https://leetcode.com/problems/fibonacci-number/submissions/

class Solution {
    int[] dp;
    
    public Solution() {
        int i = 0;
        dp = new int[31];    
        dp[0] = 0;
        dp[1] = 1;
        
        for (i = 2 ; i < 31; i++) {
            dp[i] = dp[i-1] + dp[i-2];    
        }
    }
    
    public int fib(int n) {
        return dp[n];
    }
}
