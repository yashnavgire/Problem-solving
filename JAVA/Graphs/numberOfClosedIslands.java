// Problem Link :- https://leetcode.com/problems/number-of-closed-islands/submissions/

class Solution {
    public int closedIsland(int[][] grid) {
        int i = 0, j = 0, islands = 0;
        int[][] dirs = {{0, 1}, {0 ,-1}, {1, 0}, {-1, 0}};
        
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid, dirs)) {
                        islands++;
                    }   
                }
            }
        }
        
        return islands;
    }
    
    public boolean dfs(int i, int j, int[][] grid, int[][] dirs) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false; 
        }
        
        if (grid[i][j] == 1) {
            return true;
        }
        
        grid[i][j] = 1;
        
        boolean result = true;
        
        for (int[] dir : dirs) {
            result = result & dfs(i + dir[0], j + dir[1], grid, dirs);
        }
        
        return result;
    }
}
