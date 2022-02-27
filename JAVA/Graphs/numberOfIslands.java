// Problem Link :- https://leetcode.com/problems/number-of-islands/submissions/

class Solution {
    public int numIslands(char[][] grid) {
        int i = 0, j = 0, islands = 0;
        
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    solve(i, j, grid);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    public void solve(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        solve(i + 1, j, grid);
        solve(i - 1, j, grid);
        solve(i, j + 1, grid);
        solve(i, j - 1, grid);
        
    }
}
