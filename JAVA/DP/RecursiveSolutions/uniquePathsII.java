// Problem Link :- https://leetcode.com/problems/unique-paths-ii/submissions/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(obstacleGrid, dp, obstacleGrid.length, obstacleGrid[0].length, 0, 0);
    }
    
    public int solve(int[][] grid, int[][] dp, int row, int col, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 1) {
            return 0;
        }
        
        if (i == row - 1 && j == col - 1) {
            return 1;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        dp[i][j] = solve(grid, dp, row, col, i + 1, j) + solve(grid, dp, row, col, i, j + 1);
        
        return dp[i][j];
    }
}
