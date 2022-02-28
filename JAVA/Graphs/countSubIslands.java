// Problem Link :- https://leetcode.com/problems/count-sub-islands/submissions/

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int i = 0, j = 0, cnt = 0, row = grid1.length, col = grid1[0].length;
        
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (grid2[i][j] == 1) {
                    cnt = cnt + dfs(grid1, grid2, i, j, row, col);
                }
            }
        }
        
        return cnt;
    }
    
    public int dfs(int[][] grid1, int[][] grid2, int i, int j, int row, int col) {
        int res = 1;
        if (i < 0 || j < 0 || i == row || j == col || grid2[i][j] == 0) {
            return 1;
        }
         
        grid2[i][j] = 0;
        
        res &= dfs(grid1, grid2, i + 1, j, row, col);
        res &= dfs(grid1, grid2, i - 1, j, row, col);
        res &= dfs(grid1, grid2, i, j + 1, row, col);
        res &= dfs(grid1, grid2, i, j - 1, row, col);
            
        return res & grid1[i][j];
    }
}
