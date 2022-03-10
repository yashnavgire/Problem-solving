// Problem Link :- https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int i = 0, j = 0, max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {
                // System.out.println("Coming here");
                max = Math.max(max, solve(i, j, matrix, dp,  -1));
            }
        }
        
        return max;
    }
    
    public int solve(int i, int j, int[][] matrix, int[][] dp, int prev) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        
        if (matrix[i][j] > prev) {
            
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            
            return (dp[i][j] = (1  + Math.max(solve(i + 1, j, matrix, dp, matrix[i][j]), 
                Math.max(solve(i - 1, j, matrix, dp, matrix[i][j]),
                Math.max(solve(i, j + 1, matrix, dp, matrix[i][j]),
                solve(i, j - 1, matrix, dp, matrix[i][j]))))));
        }
        
        return 0;
    }
}
