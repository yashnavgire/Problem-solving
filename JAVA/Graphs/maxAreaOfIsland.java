// Problem Link :- https://leetcode.com/problems/max-area-of-island/submissions/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int i = 0, j = 0, maxArea = 0, no = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        
        for (i = 0; i < visited.length; i++) {
            for (j = 0; j < visited[0].length; j++) {
                visited[i][j] = -1;
            }
        }
        
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == -1) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                    no++;
                }
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int[][] visited, int i, int j) {
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1) {
            return 0;
        }
        
        if (visited[i][j] == -1) {
            
            visited[i][j] = 1;
        
            if (grid[i][j] == 1) {
                return (1 + dfs(grid, visited, i+1, j) +
                            dfs(grid, visited, i-1,j) + 
                            dfs(grid, visited, i, j+1) +
                            dfs(grid, visited, i, j-1));
            }    
        }
        
        return 0;
    }
}
