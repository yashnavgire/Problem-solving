// Problem Link :- https://leetcode.com/problems/maximal-square/submissions/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int i = 0, j = 0, res = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        
        // for (i = 0; i < dp.length; i++) {
        //     for (j = 0; j < dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        
        for (i = 1; i < matrix.length+1; i++) {
            for (j = 1; j < matrix[0].length+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    res = Math.max(res, dp[i][j]);
                    //res = Math.max(res, solve(matrix, dp, i ,j , matrix.length, matrix[0].length));
                }
            }
        }
        
        return res*res;
    }
    
    public int solve(char[][] matrix, int[][] dp, int i, int j, int row, int col) {
        
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int right = solve(matrix, dp, i, j+1, row, col);
        int down = solve(matrix, dp, i+1, j, row, col);
        int diagonal = solve(matrix, dp, i+1, j+1, row, col);
        
        int res = Math.min(right, Math.min(diagonal, down));
        
        dp[i][j] = 1 + res;
        
        return dp[i][j];
    }
}
