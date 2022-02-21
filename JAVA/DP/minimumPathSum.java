// Problem Link :- https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(grid, dp, 0, 0, grid.length, grid[0].length);  
    }
    
    public int solve(int[][] grid, int[][] dp, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return 99999;
        }
        
        if (i == row-1 && j == col-1) {
            return grid[i][j];
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        dp[i][j] = grid[i][j] + Math.min(solve(grid, dp, i, j+1, row, col), solve(grid, dp, i+1, j, row, col));
        
        return dp[i][j];
    }
}
