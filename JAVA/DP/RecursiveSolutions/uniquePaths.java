// Problem Link :- https://leetcode.com/problems/unique-paths/submissions/

class Solution {
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;
        int[][] dp = new int[m][n];
        
        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(dp, m, n, 0, 0);       
    }
    
    public int solve(int[][] dp, int m , int n, int i, int j) {
        if ( i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        dp[i][j] = solve(dp, m, n, i + 1, j) + solve(dp, m, n, i, j + 1);
        
        return dp[i][j]; 
    }
}
